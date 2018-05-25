package com.sede.fst;

import com.netty.websocket.T;
import org.nustaq.serialization.FSTConfiguration;

public class Util {
    static FSTConfiguration configuration = FSTConfiguration
            // .createDefaultConfiguration();
            .createStructConfiguration();

    public static byte[] serialize(Object obj) {
        return configuration.asByteArray(obj);
    }

    public static <T> T  unserialize(byte[] sec) {
        return (T) configuration.asObject(sec);
    }


}
