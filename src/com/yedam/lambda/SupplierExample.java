package com.yedam.lambda;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {
		//int 값을 리턴하는 Supplier 함수적 인터페이스 IntSupplier
		IntSupplier intSup = () -> {         
			int num = (int) (Math.random()* 6 + 1);
			return num;
		};
		
		int result = intSup.getAsInt();
		System.out.println("결과값은: " + result);
	}
}
