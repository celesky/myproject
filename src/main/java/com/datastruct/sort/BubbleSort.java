package com.datastruct.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = new int[]{5,4,2,3,7,6,9,1,8};
        int end=data.length-1;

        while(end!=0){
            for(int i=0;i<end;i++){
                if(data[i]>data[i+1]){
                    swap(data,i,i+1);
                }
            }
            end--;
        }
        for(int i=0;i<data.length;i++){
            System.out.print(" "+data[i]);
        }

    }
    public static void swap(int[] data,int x,int y){
        int temp = data[x];
        data[x]=data[y];
        data[y]=temp;
    }
}
