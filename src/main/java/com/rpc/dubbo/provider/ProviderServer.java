package com.rpc.dubbo.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderServer {

    static final Logger logger = LoggerFactory.getLogger(ProviderServer.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/spring_provider.xml" });

        //动态暴露一个dubbo provider service
        //ServiceExporter.exportDubboService(context,HelloServiceImpl$.class);
        logger.info("xxxxxxxxxxxxxx");
        System.in.read();

    }
}
