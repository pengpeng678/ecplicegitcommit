package com.atguigu.demo3;

public class Computer {
	
	
	
	public static synchronized void s1() {
		/**
		 * 锁 ：Computer.class
		 */
		for(int i=0;i<50;i++) {
			System.out.println(Thread.currentThread().getName()+"=============");
		}

		// Computer c = new Computer();
		// Computer c2 = new Computer();
		// c.getClass();
		// c2.getClass();
		// Computer.class();

		// Computer computer = new Computer();

		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// new Computer().s1();
		// }
		// },"AAA").start();
		//
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// new Computer().s2();
		// }
		// },"CCC").start();

		// ------------------------------------------------------------------------------------

//		Computer c = new Computer();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				c.s2();
//			}
//		}, "AAA").start();
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				c.run();
//			}
//		}, "CCC").start();
		

		// ------------------------------------------------------------------------------------
		
		Computer c = new Computer();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				new Computer().show();
			}
		}, "AAA").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				new Computer().show2();
			}
		}, "CCC").start();
		
		
	}
	
	

	/**
	 * 
	 * 锁 ： Class clazz = Computer.class
	 */
	public static synchronized void s2() {
		for(int i=0;i<50;i++) {
			System.out.println(Thread.currentThread().getName()+ "********" + i);
		}
	}
	
	
	/**
	 * 锁 ： this
	 */
	public synchronized void run() {
		for(int i = 0;i < 50;i++) {
			System.out.println(Thread.currentThread().getName()+"================");
			
		}
	}
	
	
	/**
	 * 锁 : this
	 */
	public synchronized void run2() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "********" + i);
		}
	}
	
	
	public  void show() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "=======" + i);
		}
	}

	
	public  void show2() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "********" + i);
		}
	}
	
}
