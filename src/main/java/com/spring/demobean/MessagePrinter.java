package com.spring.demobean;

import com.spring.demobean.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessagePrinter {
    @Autowired(required = false)
	private IMessageService service;


    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
