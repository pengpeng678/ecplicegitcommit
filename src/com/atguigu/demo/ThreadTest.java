package com.atguigu.demo;

public class ThreadTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
		new Thread(()->{}).start();;
	}
}
