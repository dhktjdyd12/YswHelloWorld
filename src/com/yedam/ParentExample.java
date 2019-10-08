package com.yedam;
class Parent {
	void method1() {
		System.out.println("부모클래스의 메소드1.");
	}
	void method2() {
		System.out.println("부모클래스의 메소드2.");
	}
}
class Child extends Parent {
	@Override
	void method1( ) {
		System.out.println("자식클래스의 메소드1.");
	}
	@Override
	void method2() {
		System.out.println("자식클래스의 메소드2.");
	}
	void method3() {
		System.out.println("자식클래스의 메소드3.");
	}
}
public class ParentExample {
	public static void main(String[] args) {
		Child c1 = new Child();
		c1.method1();
		c1.method2();
		c1.method3();
		Parent p1 = c1; //자동 형변환.
		p1.method1();
		p1.method2();
//		p1.method3();      // error
		if(p1 instanceof Child) {   // instanceof는 Child가 p1의 객체타입을 확인하는데 사용한다. 부모객체인지 자식객체인지 확인하는 데 쓰임
			                        // 사용법: 객체 instanceof 클래스
			c1 = (Child) p1;
			c1.method1();
			c1.method2();
			c1.method3();
		}
		Parent p2 = new Parent();
		p2.method1();
		p2.method2();
		if( p2 instanceof Child) {
			p1 = (Child) c1;
			c1.method1();        //불가능
			c1.method2();        //불가능
			c1.method3();        //불가능
		}
	}
}
