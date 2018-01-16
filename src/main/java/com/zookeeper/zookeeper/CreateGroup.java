package com.zookeeper.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.nio.charset.Charset;

import static redis.clients.jedis.Protocol.CHARSET;

/**
 * Created by pan on 2017/12/14.
 */
public class CreateGroup  implements Watcher {

    private static final int SESSION_TIMEOUT = 60000;//会话延时
    private static final int MAXRETRIES=3;
    private static final int RETRY_PERIOD_SECONDS=10;
    Stat stat = new Stat();

    private ZooKeeper zk = null;
    private CountDownLatch countDownLatch = new CountDownLatch(1);//同步计数器

    @Override
    public void process(WatchedEvent event) {
        if(event.getState() == Event.KeeperState.SyncConnected){
            System.out.println("收到连接完成事件 state = " + "SyncConnected");
            countDownLatch.countDown();//计数器减一
        }
        if(event.getState() == Event.KeeperState.Disconnected){
            System.out.println("收到连接断开事件 state = " + "Disconnected");
        }
        if(event.getType() == Event.EventType.NodeDataChanged){
            System.out.println("收到节点内容修改事件 state = " + "NodeDataChanged");
        }
    }

    /**
     * 创建zk对象
     * 当客户端连接上zookeeper时会执行process(event)里的countDownLatch.countDown()，计数器的值变为0，则countDownLatch.await()方法返回。
     * @param hosts
     * @throws IOException
     * @throws InterruptedException
     */
    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        countDownLatch.await();//阻塞程序继续执行
    }

    /**
     * 创建group
     *
     * @param groupName 组名
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void create(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        String createPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE/*允许任何客户端对该znode进行读写*/, CreateMode.PERSISTENT/*持久化的znode*/);
        System.out.println("Created " + createPath);
    }


    /**
     * 删除Group
     * @param groupName
     */
    public void delete(String groupName) {
        String path = "/" + groupName;
        try {
            List<String> children = zk.getChildren(path, false);

            for(String child : children){
                zk.delete(path + "/" + child, -1);
            }
            zk.delete(path, -1);//版本号为-1，
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    public String exists(String groupName){
//        String path = "/" + groupName;
//        Stat ex = null;
//        try {
//            ex = zk.exists(path,false);
//        } catch (KeeperException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Created " + createPath);
//    }

    public String getData(String groupName){

        String path = "/" + groupName;
        try {
            byte[] data = zk.getData(path,this,stat);
            System.out.println("stat = " + stat.toString());
            return new String(data);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 显示配置
     * @throws KeeperException 服务器发出错误信号或是服务器存在通信故障。该类现在共有21个子类，
     * 分为3大类：<br/>
     * 1、状态异常(如：BadVersionException、NoChildrenForEphemeralsException)；
     * 2、可恢复的异常（如：ConnectionLossException）；
     * 3、不可恢复的异常（如：SessionExpiredException、AuthFailedException）。
     * 每个子类对应一种异常状态，且每个子类都对应一个关于错误类型的信息代码，可以通过code方法拿到。
     * 处理该种异常有两种办法：<br/>
     * 1、通过<b>检测错误代码</b>来决定应该采取何种补救措施；<br/>
     * 2、通过<b>追捕等价的KeeperException异常</b>，然后再每段捕捉代码中执行相应的操作。
     * @throws InterruptedException zookeeper操作被中断。<b>并不一定就是出现故障，只能表明相对应的操作被取消</b>。
     */
    public void write(String groupName, String value) throws KeeperException, InterruptedException {
        String path="/"+groupName;
        int retries = 0;

        while (true) {
            try {
                Stat stat = zk.exists(path, false);
                if(stat == null){
                    zk.create(path, value.getBytes(CHARSET), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                }else {
                    zk.setData(path, value.getBytes(CHARSET), -1);
                }
                break;
            } catch(KeeperException.SessionExpiredException e){
                //TODO 此处会话过期，抛出异常，由上层调用来重新创建zookeeper对象
                throw e;
            }catch(KeeperException.AuthFailedException e){
                //TODO 此处身份验证时，抛出异常，由上层来终止程序运行
                throw e;
            }catch (KeeperException e) {
                //检查有没有超出尝试的次数
                if(retries == MAXRETRIES){
                    throw e;
                }
                retries++;
                TimeUnit.SECONDS.sleep(RETRY_PERIOD_SECONDS);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 关闭zk
     * @throws InterruptedException
     */
    public void close() throws InterruptedException {
        if(zk != null){
            try {
                zk.close();
            } catch (InterruptedException e) {
                throw e;
            }finally{
                zk = null;
                System.gc();
            }
        }
    }
}
