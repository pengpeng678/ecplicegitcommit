package com.atguigu.demo3;

import java.util.concurrent.locks.ReentrantLock;

public class TicketTest {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		 new Thread(mr,"窗口1").start();
		 new Thread(mr,"窗口2").start();
	}
}


class MyRunnable implements Runnable{

	private int ticket = 100;

	//创建ReenTrantLock的对象
	//构造器 : ReentrantLock(boolean ); //值为true时创建一个公平锁   消耗性能为代价
	private ReentrantLock lock = new ReentrantLock();
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				lock.lock();
				if(ticket>0) {
					System.out.println(Thread.currentThread().getName()+"==================");
					ticket--;
				}else {
					return;
				}
			} finally {
				lock.unlock();
			}
			
			
		}
	}
	
	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized (this) {
				if(ticket>0) {
					ticket--;
				}else {
					return;
				}
			}
		}
	}
	*/
}
