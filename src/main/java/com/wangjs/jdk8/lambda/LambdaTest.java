package com.wangjs.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式是很多函数式语言的特点,一般被叫做闭包,用来执行匿名方法
 * Java的lambda语法
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
 *
 */
public class LambdaTest {
	public static void main(String[] args) {
		System.out.println("---------original----------");
		originalMethod();
		System.out.println("---------lambda1 ----------");
		lambda1();
		System.out.println("---------lambda2 ----------");
		lambda2();
		System.out.println("---------lambda3 ----------");
		lambda3();
	}

	public static void originalMethod() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});

		System.out.println("names = " + names);
	}

	public static void lambda1() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		// 使用lambda 表达式
		// 前提:对象满足@FunctionalInterface接口，这里Comparator接口已经被标记
		Collections.sort(names, (String a, String b) -> {
			return a.compareTo(b);
		});
		System.out.println("names = " + names);
	}

	public static void lambda2() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		// lambda 表达式只有一句话的时候，大括号可以省略, return 也可以省略
		Collections.sort(names, (String a, String b) -> a.compareTo(b));
		System.out.println("names = " + names);
	}

	public static void lambda3() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		// jdk 自动识别 类型
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println("names = " + names);
	}
}
