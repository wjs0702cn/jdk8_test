package com.wangjs.jdk8.defaultInf;

public interface Inf2 extends BaseInf {

	@Override
	default void method1() {
		System.out.println("from Inf2.method1");
	}
	
	
//	@Override
//	public default void method2() {
//		System.out.println("from inf2");
//	}

}
