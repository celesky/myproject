package com.datastruct.sort;

public class QuikSort2 {
    /**
     * 将数组的某一段元素进行划分，小的在左边，大的在右边
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int divide(int[] a, int start, int end){
        //每次都以最右边的元素作为基准值
        int base = a[end];
        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
        while(start < end){
            //从左边开始遍历，如果比基准值小，就继续向右走
            while(start < end && a[start] <= base){
                start++;
            }

            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                end--;
            }

            //从右边开始遍历，如果比基准值大，就继续向左走
            while(start < end && a[end] >= base){
                end--;
            }


            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }

        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }
    public static int divideError(int[] array,int low,int high){
        int pivotValue = array[0];
        int pivotIndex=0;
        //开始扫描
        while(low<high){
            //从右边往左边扫描 直到找到一个比pivot小的元素
            //然后和pivot互换位置
            while(array[high]>pivotValue){
                high--;
            }
            if(low<high){
                array[pivotIndex]=array[high];
                pivotIndex = high;
                array[high]=pivotValue;
                low++;
            }

            //从左边往右边扫描 直到扫到一个比pivot大的元素
            //再次和pivot交换位置
            while(array[low]<pivotValue){
                low++;
            }
            if(low<high){
                array[pivotIndex]=array[low];
                array[low]=pivotValue;
                pivotIndex = low;
                high++;
            }
            //high就是这一次分治之后的pivot位置 从这里切割成两个数组，继续递归调用本方法
            //left
//            sort(array,0,high-1);
//            sort(array,high+1,array.length-1);
            //right
        }
        System.out.println(low+" "+high+" "+pivotIndex);
        return high;
    }
    /**
     * 排序
     * @param a
     * @param start
     * @param end
     */
    public static void sort(int[] a, int start, int end){
        if(start > end){
            //如果只有一个元素，就不用再排下去了
            return;
        }
        else{
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(a, start, end);
            sort(a, start, partition-1);
            sort(a, partition+1, end);
        }

    }

    public static void main(String[] args) {
        int[] data = new int[]{5,4,2,3,7,6,9,1,8};
        //{1,4,2,3,7,6,9,5,8};
        //{1,4,2,3,5,6,9,7,8};
        int pivot = 5;
        sort(data,0,data.length-1);
        for(int i=0;i<data.length;i++){
            System.out.print(" "+data[i]);
        }
    }
}
