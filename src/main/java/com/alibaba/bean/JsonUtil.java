package com.alibaba.bean;

import com.alibaba.bean.enums.EventType;
import com.alibaba.bean.msg.Header;
import com.alibaba.bean.msg.User;
import com.alibaba.bean.msg.UserMsg;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.util.HashMap;

public class JsonUtil {


    public static void main(String[] args) {
        Header header = new Header();
        header.setUuid("adfafafsdfsfaa123132")
                .setEventType(EventType.LOGIN);

        User user = new User();
        user.setHeadImg("asdfas")
                .setName("xdsfa")
                .setUserId(111);

        HashMap eventMap = new HashMap();
        eventMap.put("userId",111);
        eventMap.put("sessionId","sdfafew121fdas");


//        LoginEvent event =new LoginEvent();
//        event.setSessionId("12313fafa");


        UserMsg userMsg = new UserMsg();
        userMsg.setHeader(header);
        userMsg.setUser(user);
        userMsg.setEventMap(eventMap) ;
        //userMsg.event=event;
        String jsonMsg = JSONObject.toJSONString(userMsg);
        System.out.println("jsonMsg = " + jsonMsg);
        //String jsonMsg="{\"event\":{\"sessionId\":\"222222\",\"userId\":111},\"header\":{\"eventType\":1,\"uuid\":\"12312312\"},\"user\":{\"headImg\":\"asdfas\",\"name\":\"xdsfa\",\"userId\":111}}";
        UserMsg um = JSONObject.parseObject(jsonMsg, UserMsg.class);
        //UserMsg um = new Gson().fromJson(jsonMsg,UserMsg.class);
        System.out.println("um = " + um.getHeader().toString());

        //userMsg.event=null;
        //System.out.println("xxxxxxxxx 111111" + (userMsg.getEvent()==null));
        System.out.println("1123131231 = " + 1123131231);

        //int i = userMsg.getEvent()==null?0:1;
        //System.out.println("i = " + i);
    }
}
