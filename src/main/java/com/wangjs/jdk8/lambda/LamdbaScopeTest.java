package com.wangjs.jdk8.lambda;

public class LamdbaScopeTest {
	
	static int staticValue = 2;
	
	int fieldValue = 3;
	
	public static void main(String[] args) {
		new LamdbaScopeTest().lambdaTest();
	}
	
	public void lambdaTest(){
		// 不用 final 修饰符
		int localValue = 4;
		TempFI tempFI = ()->{
//			localValue = 24;
			// 可以修改，行为类似匿名类
			fieldValue = 23;
			staticValue = 22;			
			System.out.println("localValua = "+ localValue);
			System.out.println("fieldValue = "+ fieldValue);
			System.out.println("staticValue = "+ staticValue);
		};
		
		tempFI.tempMethod();
		// 不能修改
//		localValue = 14;
		// 可以修改，行为类似匿名类
		fieldValue = 13;
		staticValue = 12;
		System.out.println("[outter]fieldValue = "+ fieldValue);
		System.out.println("[outter]staticValue = "+ staticValue);
		
	}
	
	@FunctionalInterface
	static interface TempFI{
		void tempMethod();
	}
}