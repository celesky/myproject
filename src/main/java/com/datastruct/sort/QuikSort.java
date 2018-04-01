
package com.datastruct.sort;


public class QuikSort {

    public static int[] quiksort(int[] data){
        //基线条件
        if(data.length<2){
            return data;
        }else {
            //基准数据
            int pivot = data[0];
            //分割数组

            int[] left = new int[data.length];
            int[] right = new int[data.length];;
            for(int i=0;i<data.length-1;i++){
                if(data[i+1]==0){
                    continue;
                }
                //小于pivot的放到left数组
                if(data[i+1]<pivot) {
                    left[i] = data[i + 1];
                }
            }
            for(int i=0;i<data.length-1;i++){
                if(data[i+1]==0){
                    continue;
                }
                //大于pivot的放到right数组
                if(data[i+1]>pivot){
                    right[i] = data[i+1];
                }

            }

            //分割后继续递归
            return merge(quiksort(left),pivot,quiksort(right));
        }

    }
    public static int[] merge(int[] left,int pivot,int[] right){
        int[] result = new int[left.length+right.length+1];
        for(int i=0;i<left.length;i++){
            if(left[i]!=0){
                result[i]=left[i];
            }
        }
        for(int i=0;i<right.length;i++){
            if(result[i]!=0){
                result[left.length+i]=right[i];
            }
        }
        result[left.length]=pivot;
        return result;
    }
    /**
     * 快速排序
     * 基准条件 数组长度<=1
     * 递归条件
     * @param args
     */
    public static void main(String[] args) {
        int[] data = new int[]{2,4,5,3,7,6,9,1,8};
        System.out.println(quiksort(data));
    }
}
