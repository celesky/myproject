package com.jvm.sizeofobject;

import com.jvm.sizeofobject.cao.UserEntity;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONValue;

/**
 * Created by pan on 2017/4/17.
 */
public class JsonUtil {
    public static String getJsonObj(UserEntity userEntity){
        return JSONValue.toJSONString(userEntity, JSONStyle.MAX_COMPRESS);
    }
    public static void main(String[] args) {

        //JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS);
    }
}
