package com.dubbo.provider;

import com.dubbo.ServiceExporter;
import com.dubbo.api.HelloServiceProvider;
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
