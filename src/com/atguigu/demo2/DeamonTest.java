package com.atguigu.demo2;

public class DeamonTest {
	/**
	守护线程：用来守护用户线程，一旦用户线程死亡，那么守护线程也将死亡
	
 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					System.out.println(Thread.currentThread().getName()+"========");
				}
			}
		});
		//将线程设置为守护线程
		t.setDaemon(true);
		t.start();
		Thread.sleep(3000);
		
		
		System.out.println(Thread.currentThread().getName()+"========");
		
	}

}
