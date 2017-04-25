package com.sizeofobject;

import com.lifesense.base.utils.serializer.SerializeUtils;
import com.sizeofobject.cao.UserEntity;

import java.util.Date;

/**
 * Created by pan on 2017/4/17.
 */
public class TestProgram {


    public static void testLenth(UserEntity user){
        byte[] bytes = SerializeUtils.serialize(user);

        System.out.println("bytes.length = " + bytes.length);

        byte[] bytesJson = JsonUtil.getJsonObj(user).getBytes();
        System.out.println("bytesJson = " + JsonUtil.getJsonObj(user));
        System.out.println("bytesJson.length = " + bytesJson.length);


    }

    public static void testTime(UserEntity user){
        Long start = System.nanoTime();
        System.out.println("start = " + start);

        for(int i=0;i<10000;i++){
            byte[] bytes = SerializeUtils.serialize(user);
        }
        Long end = System.nanoTime();
        System.out.println("end = " + end);
        System.out.println("time = " + (end-start));
    }

    public static UserEntity getUser(){
        UserEntity user = new UserEntity();
        user.setAppVersion("123");
        user.setBirthday(new Date());
        user.setCarrierCode("1adaf");
//        user.setCreated(new Date());
//        user.setEmail("aaaaa@qq.com");
//        user.setHeadImg("http://www.baidu.com/xxxxx/xxxxfsadfd/xxasdf.jpg");
//        user.setHeight(150.00);
//        user.setId(5000000l);
//        user.setIdcard("430522198911104141");
//        user.setInsuranceId("12312312");
//        user.setLifesenseId("6000000");
//        user.setMobile("15877777777");
//        user.setName("张飞猛如虎");
//        user.setSex(1);
//        user.setWaist(11111111.0);
//        user.setWechatUnionId("xafsdfs2e23234312342342424b");
        return user;
    }

    public static void main(String[] args) throws Exception{
        UserEntity userEntity = getUser();
        testLenth(userEntity);

        String a="a";
        System.out.println("a.getBytes().length = " + a.getBytes("UTF-8").length);

    }
}
