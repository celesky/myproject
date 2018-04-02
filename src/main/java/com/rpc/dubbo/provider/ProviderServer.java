package com.rpc.dubbo.provider;

import com.rpc.dubbo.ServiceExporter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderServer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/spring_provider.xml" });

        //动态暴露一个dubbo provider service
        ServiceExporter.exportDubboService(context,HelloServiceImpl.class);

        System.in.read();

    }
}
