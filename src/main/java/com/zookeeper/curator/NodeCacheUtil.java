package com.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * Created by pan on 2017/12/25.
 */
public class NodeCacheUtil {
    /** Zookeeper info */
    private static final String ZK_ADDRESS = "127.0.0.1:2181";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString(ZK_ADDRESS)
            .sessionTimeoutMs(30000)
            .retryPolicy(new ExponentialBackoffRetry(1000,3))
            .build();


    public void initClient(String path,String data){
        try {
            client.start();
            client.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
                    .forPath(path,data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
