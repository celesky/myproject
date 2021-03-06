package com.alibaba.bean.event;


import com.alibaba.bean.enums.EventType;

//登录事件
public class LoginEvent extends MsgEvent{
    private Integer userId;
    private String sessionId;

    public Integer getUserId() {
        return userId;
    }

    public LoginEvent setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public LoginEvent setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    @Override
    public int getEventType() {
        return EventType.LOGIN.getValue();
    }

    @Override
    public String toString() {
        return "LoginEvent{" +
                "userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
