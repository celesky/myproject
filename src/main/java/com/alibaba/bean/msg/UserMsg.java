package com.alibaba.bean.msg;

import com.alibaba.bean.event.MsgEvent;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;

public class UserMsg implements Serializable{
    private Header header;
    private User user;
    private MsgEvent event;

    private HashMap eventMap;//只是用来接收用户的消息事件部分,接收后转换成对应的msgEvent

    public Header getHeader() {
        return header;
    }

    public UserMsg setHeader(Header header) {
        this.header = header;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserMsg setUser(User user) {
        this.user = user;
        return this;
    }

    public HashMap getEventMap() {
        return eventMap;
    }

    public UserMsg setEventMap(HashMap eventMap) {
        this.eventMap = eventMap;
        return this;
    }

    public MsgEvent getEvent() {
        return event;
    }

    public UserMsg setEvent(MsgEvent event) {
        this.event = event;
        return this;
    }
//
    @Override
    public String toString() {
        return "UserMsg{" +
                "header=" + header==null?null:user.toString() +
                ", user=" + user==null?null:user.toString() +
                ", event=" + event!=null?null:event.toString()+
                ", eventMap=" + eventMap==null?null:eventMap.toString() +
                '}';
    }


}

