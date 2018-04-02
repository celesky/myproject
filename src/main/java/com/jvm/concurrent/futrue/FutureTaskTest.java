package com.jvm.concurrent.futrue;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * Created by pan on 16/9/7.
 */
public class FutureTaskTest {
    private static int cnn=0;
    private ConcurrentHashMap<String, FutureTask<Connection>> connectionPool = new ConcurrentHashMap<String, FutureTask<Connection>>();

    public Connection getConnection(String key) throws Exception {
        FutureTask<Connection> connectionTask = connectionPool.get(key);
        if (connectionTask != null) {
            return connectionTask.get();
        } else {
            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    // TODO Auto-generated method stub
                    return createConnection();
                }
            }
                    ;
            FutureTask<Connection> newTask = new FutureTask<Connection>(callable);
            connectionTask = connectionPool.putIfAbsent(key, newTask);
            if (connectionTask == null) {
                connectionTask = newTask;
                connectionTask.run();
            }
            return connectionTask.get();
        }
    }

    //创建Connection
    private Connection createConnection() {
        System.out.println("开始创建新连接 .... "+cnn++);
        Connection conn = new Connection();
        conn.connId=String.valueOf(cnn);
        return conn;
    }

    public static void main(String[] args) throws Exception{
        FutureTaskTest pool = new FutureTaskTest();
        Connection conn1 = pool.getConnection("conn1");
        System.out.println("conn1:"+conn1.connId);
        Connection conn2 = pool.getConnection("conn2");
        System.out.println("conn2:"+conn2.connId);
        Connection conn3 = pool.getConnection("conn3");
        System.out.println("conn3:"+conn3.connId);
        Connection conn11 = pool.getConnection("conn1");
        System.out.println("conn11:"+conn11.connId);
    }
}
class Connection{
    String connId;
}