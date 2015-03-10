package com.wangjs.jdk8.defaultInf;

public interface Inf1 extends BaseInf{
	default void method2(){
		System.out.println("from Inf1");
	}
}
