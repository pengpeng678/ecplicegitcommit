package com.atguigu.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
	public void test() {
		List<Integer> list = new ArrayList();
		new Thread(()->{
			for(int i = 0; i< 10 ;i++) {
				list.add(i);
				System.out.println(Thread.currentThread().getName()+"================");
			}
		});
		
		// 主线程获取这10个数
		System.out.println(list.size());
		
	}
	
	
	public static void main(String[] args) throws Exception, Exception {
		
		MyCallable myCallable = new MyCallable();
		FutureTask<String> futureTask = new FutureTask<>(myCallable);
		
		Thread t = new Thread(futureTask);
		t.start();
		
		FutureTask<String> futureTask2 = new FutureTask<>(myCallable);
		Thread t2 = new Thread(futureTask2);
		t2.start();
		
		String s = futureTask.get();
		System.out.println("ft 分线程返回的结果"+s);

		String s2 = futureTask2.get();
		System.out.println("ft 分线程返回的结果"+s2);
		
		String s3 = futureTask2.get();// 执行该方法时会阻塞当前线程
		System.out.println("ft2分线程返回的结果为:" + s3);
		String s4 = futureTask2.get();// 执行该方法时会阻塞当前线程
		System.out.println("ft2分线程返回的结果为:" + s4);
	}
}
//1.创建一个类并实现Callable接口
class MyCallable implements Callable<String>{

	// 2.重写call方法
	@Override
	public String call() throws Exception {
		// 3.在call方法中实现需要在分线程中实现的功能
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"====================");
		}
		return Math.random()+"";
	}
}
