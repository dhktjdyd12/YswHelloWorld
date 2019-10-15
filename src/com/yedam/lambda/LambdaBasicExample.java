package com.yedam.lambda;


@FunctionalInterface    // 이런식으로 함수형인터페이스를 선언하면 컴파일러가 문법적인 오류를 체크해줌
interface MyInterface { // 공통의 기능을 정의하는 인터페이스
	                    // 인터페이스중에 구현해야될 메소드가 1개인 것은 람다식으로 표현가능한 문장
	int print(int a, int b);
}

class MyInterfaceClass implements MyInterface { // 인터페이스를 상속받는 MyinterfaceClass

	@Override
	public int print(int a, int b) {
		return a+b;
	}

}

public class LambdaBasicExample {
	public static void main(String[] args) {
//		MyInterface mi = new MyInterfaceClass();  // 인터페이스 객체 mi 선언
//		int result = mi.print(4,9);
//		System.out.println("결과값은" + result );
	
		// 곱하기 해주는 객체
//		mi = new MyInterface() {
//
//			@Override
//			public int print(int a, int b) {
//				return a*b;
//			}
//			
//		};
		
		// 곱하기 객체를 람다식으로 표현하는 법
		MyInterface mi = (a, b) -> {
				return a*b;
		};
		
		int result = mi.print(3, 5);
		System.out.println("결과값은" + result );
		
		
		// 빼기 해주는 객체
		mi = new MyInterface() {

			@Override
			public int print(int a, int b) {
				return a-b;
			}
			
		};
		result = mi.print(7, 4);
		System.out.println("결과값은" + result );
		
		// 나누기 해주는 객체
		// 문제1. mi.print(8,4) --> 이거의 나누기 결과를 출력
		mi = (a,b) -> {
			return a/b;
		};
		result = mi.print(8, 4);
		System.out.println("결과값은" + result);
		
		
	}

}
