package com.atguigu.demo5;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo2 {
	//volatile不保证原子性。
	//可以使用AtomicInteger解决++不是原子性操作的问题
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
					
					new Thread2().start();
					
					System.out.println(Thread2.count);
			}
			
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println(Thread2.count);
	
	System.out.println("cuntall"+Thread2.count);
}
}


class Thread2 extends Thread{
	
	public static AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			
			count.incrementAndGet();
		}
		//System.out.println(Thread2.count);
		
	
	}
}