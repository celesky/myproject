package com.dubbo.consumer;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.provider.user.UserService;

public class DemoConsumer {
	public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/spring.xml" });
        context.start();
  
        UserService userService = (UserService) context.getBean("userService"); 
        String hello = userService.sayHello("tom");
        System.out.println(hello);  
        
        List list = userService.getUsers();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
       
        System.in.read();  
    }
}
