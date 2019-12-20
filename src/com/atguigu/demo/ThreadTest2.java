package com.atguigu.demo;

public class ThreadTest2 {
/*
 * 
 * 
 * 
 * 
 * 
 * 
      继承Thread和实现Runnable的区别是什么？
	1.开启多线程的方式上有区别。
		继承Thread如果要开启多个线程，创建多个Thread子类的对象
		实现Runnable接口，那么Runnable接口实现类的对象只需要创建一个。
	2.同步资源： 共享变量
		继承Thread的方式，在Thread子类中声明的同步资源需要加static
		实现Runnable的方式，在Runnable实现类中声明的同步资源需不要加static
	3.同步监视器（多个线程的锁应该是同一把）： 同步代码块
		继承Thread的方式，同步监视器不能使用this
		实现Runnable的方式，同步监视器可以使用this
	4.同步方法：
		继承Thread的方式，同步方法必须加static (同步方法的隐式锁是 : 当前类.class 。如果不加static锁还是this)
		实现Runnable的方式，同步监视器可以使用this(同步方法的隐式锁是 : this)
		
		public static synchronized void test() {
		
		}
 * 
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
