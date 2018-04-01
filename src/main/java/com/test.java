package com;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Arrays;

public class test {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM??????-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	  */
	public static void testAllocation() throws Exception{
	 	byte[] allocation1, allocation2, allocation3, allocation4,allocation5,allocation6;
	 	while(true){
	 		allocation1 = new byte[2 * _1MB];
		 	allocation2 = new byte[2 * _1MB];
		 	allocation3 = new byte[6 * _1MB];
		 	//allocation4 = new byte[2 * _1MB];
			//allocation4 = new byte[4 * _1MB];  // ???????Minor GC
			//allocation5 = new byte[2 * _1MB];  // ???????Minor GC
			//allocation5 = new byte[4 * _1MB];  // ???????Minor GC
		 	Thread.sleep(10000);
			System.out.println("111 = " + 111);
			System.out.println("111 = " + 222);
            System.out.println("111 = " + 333);


        }
	 }

	public static void main(String[] args)throws Exception {
//		while(true){
//			System.out.println(Thread.currentThread().getId());
//			Thread.sleep(200);
//		}
//		System.out.println(SunMyTet.fuck());
//
//		MessageSource messageSource = new ResourceBundleMessageSource();
//		System.out.println(SunMyTet.fuck());

		Integer[] first = new Integer[]{1,2,3,4};
		Integer[] second = new Integer[]{5,6,7,8};
		Integer[] result = concat(first,second);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
}
