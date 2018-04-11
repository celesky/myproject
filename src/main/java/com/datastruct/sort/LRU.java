package com.datastruct.sort;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K,V> {

    private LinkedHashMap<K,V> map;
    private int cacheSize;

    public LRU(){
        map =new LinkedHashMap<K,V>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LRU.this.cacheSize;
            }
        };
    }


}
