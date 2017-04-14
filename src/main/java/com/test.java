package com;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

		}
	 }

	public static void main(String[] args)throws Exception {
		//testAllocation();
		int i=0;
		while(i<10){
			int x = new Random().nextInt(2);
			System.out.println("x = " + x);
			i++;
		}

	}
}
