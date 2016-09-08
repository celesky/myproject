package com.netty.bean;

/**
 * Created by pan on 16/8/31.
 */
public class ChatMessage {
    private Long fromClientId;
    private Long destClientId;
    private String msg;

    public Long getFromClientId() {
        return fromClientId;
    }

    public void setFromClientId(Long fromClientId) {
        this.fromClientId = fromClientId;
    }

    public Long getDestClientId() {
        return destClientId;
    }

    public void setDestClientId(Long destClientId) {
        this.destClientId = destClientId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
