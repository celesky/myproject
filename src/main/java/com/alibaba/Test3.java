package com.alibaba;

public class Test3 {
    /**
     * 001234
     * 567892
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("args = " + bigNumAdd("1234","567892"));
        //Test3.bigNumAdd("1234","56789");
        //[0] [1][2][3][4]
        //[5][6][7][8][9]
    }


    public static String bigNumAdd(String num1,String num2){
        String str="";
        int len1=num1.length();
        int len2=num2.length();
        int maxLen=len1>len2?len1:len2;
        int minLen=len1<len2?len1:len2;

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<maxLen-minLen;i++){
            sb.append("0");
        }
        //短的数字 在前面补0
        if(len1==minLen){
            num1=sb.append(num1).toString();
        }else{
            num2=sb.append(num2).toString();
        }

        sb=new StringBuilder();
        int tempA;
        int tempB;
        int result;
        //保存进位数
        int sc=0;
        for(int i=maxLen-1;i>=0;i--){
            tempA=Integer.valueOf(num1.charAt(i)+"");
            tempB=Integer.valueOf(num2.charAt(i)+"");
            //并累加上一次的进位数字
            result=tempA+tempB+sc;
            sc=result/10;
            result=result%10;
            sb.append(result);
        }

        if(sc==1){
            sb.append(sb);
        }
        str=sb.reverse().toString();
        return str;
    }
    public void test(){
        System.out.println("true = " + true);
        System.out.println("true = " + true);
    }
    public void tes3(){

    }
}
