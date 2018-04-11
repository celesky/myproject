package com.rpc.thrift.client;

import com.rpc.dubbo.api.dthrift.SearchMoviePersonResultDto;
import com.rpc.dubbo.api.dthrift.SearchThriftProvider;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Client2 {

    public static void main(String[] args) {
        System.out.println("客户端启动....");
        TTransport transport = null;
        try {
            transport = new TSocket("localhost", 9898, 30000);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            SearchThriftProvider.Client client = new SearchThriftProvider.Client(protocol);
            transport.open();
            String result =client.ping();
            System.out.println(result);
            SearchMoviePersonResultDto dto = client.searchMoviePerson(true,"",1,1);
            System.out.println("dto.toString() = " + dto.toString());
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }
}
