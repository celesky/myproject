package com.rpc.dubbo.consumer;

import com.rpc.dubbo.ServiceExporter;
import com.rpc.dubbo.api.HelloServiceProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.provider.user.UserService;

public class DemoConsumer {
	public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/spring.xml" });
        context.start();
        HelloServiceProvider helloService = (HelloServiceProvider) context.getBean(HelloServiceProvider.class);
        String hello = helloService.hello();
        System.out.println(hello);


        //动态传入ConsumerClient.class这个类，让spring去生产这个类的对象
//        AutowireCapableBeanFactory defaultBeanFactory = context.getAutowireCapableBeanFactory();
//        ConsumerClient client = ServiceExporter.createSpringBean((DefaultListableBeanFactory)defaultBeanFactory,ConsumerClient.class);
//        client.test();

    }



}
