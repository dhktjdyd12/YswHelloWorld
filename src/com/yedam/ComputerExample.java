package com.yedam;
class Calculator {
	double areaCircle(double r) {
		return 3.14 * r * r;
	}
}
class Computer extends Calculator {
	@Override                      // 부모클래스가 가지고 있는 메소드를 내가 재정의 해서 쓰겠다는 것을 의미 
	                               // 이것을 안적으면 자식클래스를double을 int으로 쓰는 등 다르게 써도 상관이 없다. 
	double areaCircle(double r) {
		return Math.PI * r * r;
	}
	double areaCircle1(double r) {
		return super.areaCircle(r);
	}
}
public class ComputerExample {
	public static void main(String[] args) {
		Computer com = new Computer();
		System.out.println("결과값:" + com.areaCircle(10) );
	}
}
