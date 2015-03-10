package com.wangjs.jdk8.defaultInf;

/**
 * 不能实现两个含有同样默认方法实现(method2)的接口,
 * jdk8不会出现C++的菱形继承问题
 *
 */
public class DefaultInterfaceTest implements Inf1,Inf2{
	public static void main(String[] args) {
		new DefaultInterfaceTest().method2();
	}

}
