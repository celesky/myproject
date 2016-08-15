package com.lock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LockDemo {
	
	public static  boolean asleep=true;
	
	public static void main(String[] args) throws Exception {
//		AtomicLong a = new AtomicLong(1);
//		Long a1 = a.getAndIncrement();
//		Long a2 = a.incrementAndGet();
//		System.out.println(a);
//		System.out.println(a1);
//		System.out.println(a2);
		
//		Thread mt = new Thread(new ModThread());
//		mt.start();
//		
//		int i=0;
//		while(asleep){
//			System.out.println("数羊中。。。"+i++ +"只羊");
//			Thread.sleep(1000);
//		}
//		System.out.println("睡着了");
//		
//		ConcurrentHashMap a = new ConcurrentHashMap();
		
//		ReentrantLock rl =  new ReentrantLock();
//		rl.lock();
//		int count = Runtime.getRuntime().availableProcessors();
//		System.out.println(count);
		
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		executorService.invokeAll(tasks);
		
		  Pattern pattern = Pattern.compile("(CZ#)(([0-9]+))(.*)|(CZ)([0-9]+)");
		  Matcher matcher1 = pattern.matcher("CZ100");
		  Matcher matcher2 = pattern.matcher("CZ#100#13807717744");
		  boolean b1= matcher1.matches();
		  boolean b2= matcher2.matches();
		  //当条件满足时，将返回true，否则返回false
		  System.out.println(b1);
		  System.out.println(b2);
	}
	
}
