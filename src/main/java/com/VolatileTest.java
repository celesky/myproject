package com;

import java.util.HashMap;

/**
 * @desc:
 * @author: panqiong
 * @date: 2019-09-28
 */
public class VolatileTest {
    public static HashMap hashMap = new HashMap();

    public void func1(){
        HashMap h = new HashMap(8);
        h.put("1",1);
        h.put("2",2);
        hashMap = h;
    }

    public void func2(){
        HashMap h = new HashMap(8);
        h.put("3",3);
        hashMap = h;
    }

    public void justDoIt(){
        func1();
        func2();
        if(hashMap.size()>1){
            System.out.println(hashMap.size());
        }

    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        for(int i=0;i<10000000;i++){
            test.justDoIt();
        }
    }


}
