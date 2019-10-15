package com.yedam.lambda;

interface MyInterfaceNoArgs {         // 인터페이스
	public void method1();
}

interface MyinterfaceWithArgs {       // 인터페이스
	public void method2(int a);
}

interface MyinterfaceWithReturn {     // 인터페이스
	public int method3(int a, int b);
}

public class LambdaBasicExample2 {
	public static void main(String[] args) {  // main 메소드
		
		// MyInterfaceNoArgs의 람다식 표현, 문자열 출력 
		MyInterfaceNoArgs fina = () -> {
			System.out.println("no arguments expression.");
		};
		fina.method1();
		
		// MyinterfaceWithArgs의  람다식 표현,  곱하기 값 출력
		MyinterfaceWithArgs fiwa = (num) -> {
			System.out.println("result is" + (num * 3) );
		};
		fiwa.method2(5);
		
		// MyinterfaceWithReturn의 람다식 표현, 더하기 값을 리턴
		MyinterfaceWithReturn fiwr = (a,b) -> {
			return a + b;
		};
		int result = fiwr.method3(5,10);
		System.out.println("결과값은" + result);
	}
}
