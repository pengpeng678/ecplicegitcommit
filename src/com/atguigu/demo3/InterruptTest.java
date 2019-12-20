package com.atguigu.demo3;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

/**
 * 终止线程 ：
 * 
 * interrupt : 打断线程（设置标记） 注意 ：标记有时会设置失败。比如当前前线程被IO阻塞，或者分线程调用sleep等操作。 描述
 * ：如果线程在wait()，wait(long)调用阻塞，或wait(long, int)
 * Object类的方法，或者对join()，join(long)，join(long, int)，sleep(long)，或sleep(long,
 * int)， 这类方法，那么它的中断状态将被清除，它会收到一InterruptedException。
 * 
 * isInterrupted : 当前线程是否已经被杀死（根据标记来判断）
 */

public class InterruptTest {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"========="+Thread.currentThread().isInterrupted()+"=========="+i);
					try {
						
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*
					 * try { this.wait(); } catch (InterruptedException e) { // TODO Auto-generated
					 * catch block e.printStackTrace(); }
					 */
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("数据保存中。。。。。。。。。。");
						return;
					}
				}
			}
		}, "线程1");

		t.start();
		for (int i = 0; i < 10; i++) {
			if(i == 3) {
				t.interrupt();
			}
		}
	}
}
