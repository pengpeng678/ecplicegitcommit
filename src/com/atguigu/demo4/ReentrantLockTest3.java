package com.atguigu.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest3 {
	public static void main(String[] args) {
		
		
		
		
		FD fd = new FD();
		
		
	new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i <5; i++) {
				fd.chuancai();
				}
			}
		},"王五").start();
	
	
	
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i <5; i++) {
				fd.peicai();
				}
			}
		},"张三").start();
		
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i <5; i++) {
				fd.caocai();
				}
			}
		},"李四").start();
		
	
	}
}

/**
	案例 ： 饭店的配菜，炒菜，传菜进行交替执行
	
*/
class FD{
	private int state;//0表示配菜，1表示炒菜，2表示传菜
	private ReentrantLock lock = new ReentrantLock();
	private Condition peicai = lock.newCondition();
	private Condition chaocai = lock.newCondition();
	private Condition chuancai = lock.newCondition();
	
	public void peicai() {
		try {
			lock.lock();
			
			
			
			if(state!=0) {
				try {
					peicai.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "====开始配菜====");			
			state = 1;
			
			chaocai.signal();
			
			
		}finally {
			lock.unlock();
		}
		
	}
	
	
	public void caocai() {
		try {
			lock.lock();
			
			
			if(state != 1) {
				try {
					chaocai.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName() + "====开始炒菜====");
			//修改状态 - 让传菜的哥们传菜
			state = 2;
			
			chuancai.signal();
			
		}finally {
			lock.unlock();
		}
		
	}
	
	
	
	public void chuancai() {
		try {
			lock.lock();
			
			
			if(state != 2) {
				try {
					chuancai.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName() + "====开始炒菜====");
			//修改状态 - 让传菜的哥们传菜
			state = 0;
			
			peicai.signal();
			
		}finally {
			lock.unlock();
		}
		
	}
	
	
	
	
	
}