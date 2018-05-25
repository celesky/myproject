package com.alibaba.bean.event;


import com.alibaba.bean.enums.EventType;

public class LogoutEvent extends MsgEvent{
    @Override
    public int getEventType() {
        return EventType.LOGOUT.getValue();
    }
}
