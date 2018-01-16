package com.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * Created by pan on 2017/12/25.
 */
public class CuratorUtil {
    /** Zookeeper info */
    private static final String ZK_ADDRESS = "127.0.0.1:2181";

    private static CuratorFramework client;
    private static CuratorUtil curatorUtil;



    public static CuratorUtil getInstance(){
        if(curatorUtil!=null){
            return curatorUtil;
        }else {
            synchronized (CuratorUtil.class){
                if(curatorUtil==null){
                    curatorUtil = new CuratorUtil();
                    curatorUtil.initZkClient();
                }
            }
        }
        return curatorUtil;
    }

    private  CuratorFramework initZkClient(){
        client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryOneTime(1000));
        client.start();
        return client;
    }

    public void create(String path,String data){
        try{
            client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
                    .forPath(path, data.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getData(String path){
        try{
            Stat sts = new Stat();
            String data = new String(client.getData().storingStatIn(sts).forPath(path));
            print(sts.toString());
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setData(String path,String data){
        try{
            client.setData().withVersion(-1).forPath(path,data.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteNode(String path){
        try{
            client.delete().guaranteed().forPath(path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getChildren(String path){
        try{
            List<String> list = client.getChildren().forPath(path);
            if(list!=null){
                list.stream().forEach(System.out::println);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void existsPath(String path){
        try{
            Stat sts = client.checkExists().forPath(path);
            if(sts==null){
                print(path+" does not exist!");
            }else{
                print("sts:"+sts.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try{
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CuratorUtil util = CuratorUtil.getInstance();
        try{
            util.create("/curator/helloworld","helloworld!buddy! happy chrismas");
            print(util.getData("/curator/helloworld"));
            util.setData("/curator/helloworld","helloworld!buddy! happy chinese new year!");
            //util.deleteNode("/curator/helloworld0000000003");
            util.getChildren("/curator");
            util.existsPath("/curator/helloworld");
        }finally {
            util.disconnect();
        }
    }
    public static void print(String ss){
        System.out.println(ss);
    }
}
