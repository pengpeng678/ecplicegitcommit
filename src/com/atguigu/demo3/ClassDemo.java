package com.atguigu.demo3;

class A{
	
}

public class ClassDemo {
	public static void main(String[] args) {
		
		Class clazz = A.class;
		A a  = new A();
		Class<? extends A> clazz2 = a.getClass();
		A b = new A();
		Class<? extends A> clazz3 = b.getClass();
		System.out.println(clazz2 == clazz3);
		
		
	}
}
