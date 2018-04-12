package com.datastruct;

import java.util.Scanner;

/**
 * 编译器版本: Java 1.8.0_66 请使用标准输入输出(System.in, System.out)；
 * 已禁用图形、文件、网络、系统相关的操作，如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；
 * 不要自定义包名称，否则会报错，即不要添加package answer之类的语句；
 * 您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
 时间限制: 30S (C/C++以外的语言为: 32 S)   内存限制: 200M (C/C++以外的语言为: 712 M)
 输入:输入数据包含5行数字: 第一行是每台broker的极限QPS 第二行是broker rt列表,用逗号分割，几个rt表示几个broker 第三行是消息生产请求总数 第四行是最大并发线程数
 输出:按照最大吞吐量执行完所有请求，需要耗时多少毫秒
 输入范例:200 1,1,1,10,10 5000 10
 输出范例:5000
 */
public class BenchTest {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int maxQps= Integer.valueOf(in.nextLine());
        final String[] rtList = in.nextLine().split(",");
        final int requestNum = Integer.valueOf(in.nextLine());
        final int threadNum = Integer.valueOf(in.nextLine());
        System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
    }
    /**
     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
     * @return
     */
    static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {

        //TODO
        int qpsSum = 0;
        for (String rtString : rtList) {
            int singleMaxQps = threadNum * 1000 / Integer.valueOf(rtString);
            if (singleMaxQps > maxQps) {
                qpsSum += maxQps;
            }else {
                qpsSum += singleMaxQps;
            }
        }

        return requestNum / qpsSum * 1000;
    }
}
