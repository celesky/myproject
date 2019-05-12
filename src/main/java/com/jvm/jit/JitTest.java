package com.jvm.jit;

/**
 * @desc: 输出被即使编译的代码 %说明是由回边计数器触发OSR编译
 * @author: panqiong
 * @date: 2019-01-13
 */
public class JitTest {

    public static int doubleValue(int i){
        for (int j = 0;j<10000 ;j++){

        }
        return i*2;
    }
    public static long calculate(){
        long sum = 0;
        for(int i = 0; i <1000;i++){
            sum+=doubleValue(1);
        }
        return sum;
    }

    public static void main(String[] args) {
        for(int i=0 ;i<15000;i++){
            calculate();
        }
    }
}
