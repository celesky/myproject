package com.jvm.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionDemo {


	public static void main(String[] args) {
		ErrHandler handle = null;
		ThreadA a = null;

		a = new UncaughtExceptionDemo.ThreadA();
		handle = new ErrHandler();
		a.setUncaughtExceptionHandler(handle);// 加入定义的ErrHandler
		a.start();


	}
	static class ErrHandler  implements UncaughtExceptionHandler{

		/**
		 * 这里可以做任何针对异常的处理,比如记录日志等等
		 */
		@Override
		public void uncaughtException(Thread a, Throwable e) {
			System.out.println("This is:" + a.getName() + ",Message:"+ e.getMessage());
			e.printStackTrace();
		}

	}
	/**
	 * 拥有UncaughtExceptionHandler的线程
	 */
	static class ThreadA extends Thread {

		public ThreadA() {
		}

		@Override
		public void run() {
			System.out.println("线程run了 " );
			double i = 12 / 0;// 抛出异常的地方
			System.out.println("i = " + i);
		}

	}



}
