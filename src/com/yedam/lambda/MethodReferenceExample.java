package com.yedam.lambda;

import java.util.function.IntBinaryOperator;

class Calculator {
	static int staticSum(int x, int y) {
		return x + y;
	}

	int instanceSum(int x, int y) {
		return x + y;
	}
}

public class MethodReferenceExample {
	public static void main(String[] args) {
		int a = 10, b = 20, result = 0;
		Calculator.staticSum(a, b);

		Calculator cal = new Calculator();
		cal.instanceSum(a, b);

		IntBinaryOperator oper;
		
		
		oper = Calculator::staticSum; // Calculator 안에 속한 static메소드명
		result = oper.applyAsInt(a, b);
		System.out.println("정적메소드참조: " + result);

		
		oper = (x, y) -> {
			return cal.instanceSum(x, y);
		}; 
		result = oper.applyAsInt(b, a);
		oper = cal::instanceSum;      // cal 안에 속한 instance메소드명
		result = oper.applyAsInt(b, a);
		System.out.println("인스턴스메소드참조: " + result);
	}
}
