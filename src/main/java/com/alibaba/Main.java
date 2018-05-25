package com.alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 阿里巴巴零售通目前正在负责给线下零售小店供给商品，
 已知有商品N个，零售小店M个，
 每个小店订购某一个商品K份，
 商品单价p，求销量top+n的商品和销售额top+n的商品。
 */
public class Main {

    //调整堆顶数据
    public void head(int[] arr, int idx){
        int left = (idx << 1)+1;
        int right = (idx << 1)+2;
        int min,temp;
        if (left>=arr.length){
            return;
        }
        if ((right<arr.length)&&arr[right]<arr[left]){
            min = right;
        }else{
            min = left;
        }
        if (arr[idx]>arr[min]){
            temp = arr[idx];
            arr[idx] = arr[min];
            arr[min] = temp;
            head(arr,min);
        }
    }

    public void getTopN(int n,List<Integer> dataList){
        int[] topN = new int[n];
        //取出前n个
        List<Integer> topList = dataList.subList(0,n);

        int idx = topList.size()/2 - 1;
        //生成小顶堆
        int[] arr = new  int[topList.size()];
        for (int i =0;i<topList.size();i++){
            arr[i] = topList.get(i);
        }
        for (int i = idx;i>=0;i--){
            head(arr,i);
        }
        //遍历剩下的
        for (int i = arr.length;i<dataList.size();i++){
            //每遍历一个则跟堆顶元素进行比较大小
            if (dataList.get(i)>arr[0]){
                arr[0] = dataList.get(i);
                head(arr,0);
            }
        }

        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
    static int arr[] = new int[10];
    public static void main(String[] args) {
//        List arrayList = new ArrayList<Integer>();
//        for (Integer i = 0;i<5000;i++){
//            arrayList.add(i);
//        }
//        //打乱顺序
//        Collections.shuffle(arrayList);
//        //取前n个最大的
//        new Main().getTopN(10,arrayList);




        //public static void main(String a[]){

            System.out.println(arr[1]);

//        }
    }
}
