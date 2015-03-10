package com.wangjs.jdk8.funInt;

/**
 * FunctionalInterface要求:
 * 1. 只有一个抽象方法。default方法可以随便加
 * @ FunctionInterface 会检查语法正确性，但不要求强制加
 *
 * jdk8 内置了一些有用的FunctionalInterface 在 java.util.function包中
 * a) Predicate test(T) 返回一个boolean值
 * b) Function apply(T) 利用 andThen/compose 可以执行一个链式函数(类似jQuery)
 * c) Supplier get() 工厂模式的简单实现/无法定制参数 
 * d) Consumer accept(T) ？ 用途不明 这个接口有的功能在Function中都有
 * 
 * 一些老的接口已经被改造
 * Comparator/Runnable/Callable.....
 */
public class FunctionalInterfaceTest {
	public static void main(String[] args) {
		//实际上是实现了convert(F)方法
//		Converter<String, Integer> converter = a -> Integer.valueOf(a);
		
		//method references 
		//这种写法的是代替lambda写法的,语法的前提通lambda
		// 如果lambda语法本身没有业务逻辑，只是调用一个已经存在的方法，就可以使用这个
		Converter<String, Integer> converter = Integer::valueOf;
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
