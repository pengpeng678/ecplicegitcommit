package com.atguigu.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		
		newFixedThreadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"===========");
				}
			}
		});
		
		
		
		
		for(int i=0;i<10;i++) {

			newFixedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10;i++) {
						System.out.println(Thread.currentThread().getName()+"===========");
					}
				}
			});
					
		
		}
	}

}
