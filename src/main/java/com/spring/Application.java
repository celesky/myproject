package com.spring;

import com.spring.demobean.IMessageService;
import com.spring.demobean.MessagePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@ComponentScan
public class Application {


//    @Bean
//    IMessageService mockMessageService() {
//        return new IMessageService() {
//            public String getMessage() {
//                return "Hello World!";
//            }
//        };
//    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();


        context =
                new FileSystemXmlApplicationContext("");
    }
}
