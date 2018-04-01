package com.spring.demobean;

import org.springframework.stereotype.Component;

@Component
public class MockMessageService implements IMessageService{

    public String getMessage() {
        return "hello ! this message is from mock service";
    }
}
