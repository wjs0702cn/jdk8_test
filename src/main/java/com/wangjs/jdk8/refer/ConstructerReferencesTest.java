package com.wangjs.jdk8.refer;

/**
 * 构造函数::new  
 * 赋值给一个能创建此对象的@FunctionalInterface
 * 
 * 
 * 问题:
 * ::new 能赋值给哪些对象？
 *  是lambda语法的简写(lambda表达式本身没有什么业务逻辑，只是调用一个已经存在的构造函数)
 * ::new 如何确定参数？
 * 	这种语法用已经存在的够着函数去实现一个@FunctionalInterface(参数列表相同)
 *
 */
public class ConstructerReferencesTest {
	public static void main(String[] args) {
		PersonFactory<Person> factory = Person::new;
		Person angle = factory.create("Angle", "Apple");
		System.out.println("Angle = " + angle);
	}

	interface PersonFactory<P extends Person> {
		P create(String firstName, String lastName);
	}
	
	interface PersonFactoryNoArg<P extends Person>{
		P create();
	}
	
	interface PersonFactoryOneArg<P extends Person>{
		P create(String firstName);
	}

	static class Person {
		private String firstName;
		private String lastName;

		public Person() {
			super();
		}

		public Person(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", lastName=" + lastName
					+ "]";
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	}
}
