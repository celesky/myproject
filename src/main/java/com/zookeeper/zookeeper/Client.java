package com.zookeeper.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by pan on 2017/12/14.
 */
public class Client {
    static CreateGroup createGroup  = new  CreateGroup();
    static String hosts="localhost";


    public void keepwrite(){
        int flag = 0;
        String path="";
        String value="";
        while (true) {
            try {
                createGroup.write(path, value);
                break;
            } catch (KeeperException.SessionExpiredException e) {
                // TODO: 重新创建、开始一个新的会话
                e.printStackTrace();
                //zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
                try {
                    createGroup.connect(hosts);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            } catch (KeeperException e) {
                // TODO 尝试了多次，还是出错，只有退出了
                e.printStackTrace();
                flag = 1;
                break;
//            }catch(KeeperException.AuthFailedException e){
//                //TODO 此处身份验证时，终止程序运行
//                e.printStackTrace();
//                flag = 1;
//                break;
//            } catch (IOException e) {
//                // TODO 创建zookeeper对象失败，无法连接到zk集群
//                e.printStackTrace();
//                flag = 1;
//                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.exit(flag);

    }
    public static void main(String[] args)throws  Exception {

//        createGroup.connect("localhost");
//        createGroup.create("dubbo/userService");
//        createGroup.create("dubbo/deviceService");
//        createGroup.create("dubbo/sleepService");
        //createGroup.delete("dubbo/userService");

        testGetData();
    }


    public static void testGetData() throws  Exception {
        String groupName = "dubbo/sleepService";
        createGroup.connect("localhost");

        //先读取一次数据,并设置watcher
        String data = createGroup.getData(groupName);
        System.out.println("data1 = " + data);
        //修改数据内容
        createGroup.write(groupName, "getSleepList,getUserSleepByDay,getSleepByMonth,getSleepDetail");

        data = createGroup.getData(groupName);

        System.out.println("data2 = " + data);
    }
}
