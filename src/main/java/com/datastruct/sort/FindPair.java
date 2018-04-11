package com.datastruct.sort;


/**
 * 找到一组与给定值sum最近的数字组合
 */
public class FindPair {

    public  void find(int[] array, int sum) {
        int right = array.length - 1;
        int left = 0;
        int diff = Integer.MAX_VALUE;//初始化差值

        int rLeft = 0;
        int rright = array.length - 1;

        while (left < right) {
            int absDiff = Math.abs(array[right] + array[left] - sum);
            //绝对值小,更近
            if (absDiff < diff) {
                rLeft = left;
                rright = right;
                //大于sum,需要右边减小
                if (array[right] + array[left] > sum) {
                    right--;
                    //小于sum,需要左边++
                } else if (array[right] + array[left] < sum) {
                    left++;
                } else {
                    //相等 就说明已经找到了
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("result:" + array[rLeft] + " " + array[rright]);
    }


    public static void main(String[] args) {
        int[] array = new int[]{-3,0,3,4,5,9,12,30,31,33};
        new FindPair().find(array,-1);
    }

//如果差值比上一个差值大
    //sum(left+right)> sumNumber
        //右边--
    //sum(left+right)> sumNumber
        //左边++
//如果差值比上一个差值小
    //直接结束查找
}
