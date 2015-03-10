package com.wangjs.jdk8.defaultInf;

public interface BaseInf {
	void method1();
	
	default void method2(){
		System.out.println("from BaseInf.method2");
	}
}
