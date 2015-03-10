package com.wangjs.jdk8.funInt;

/**
 * FunctionalInterface要求:
 * 1. 只有一个抽象方法。default方法可以随便加
 *
 */
public class FunctionalInterfaceTest {
	public static void main(String[] args) {
		Converter<String, Integer> converter = a -> Integer.valueOf(a);
		Integer result = converter.convert("123");
		System.out.println("result = "+result);
	}
	
	//不加 FunctionalInteface也能使用
	@FunctionalInterface
	public interface Converter<F,T>{
		T convert(F a);
	}
	
	//这里不能使用FunctionalInterface,有两个抽象方法,除非实现一个
//	@FunctionalInterface
	public interface BadFunctionalInterface<S, F, T> extends Converter<F, T>{
		void log(S s);
		
//		default T convert(F a){
//			return (T)a;
//		}
	}
}
