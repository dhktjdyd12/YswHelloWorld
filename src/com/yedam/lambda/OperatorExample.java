package com.yedam.lambda;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	static int[] scores = { 92, 95, 87 };

	static int minOrMax(IntBinaryOperator oper) {             // minOrMax 메소드
		int result = scores[0];
		for (int score : scores) {
			result = oper.applyAsInt(result, score); // 두개중에 큰값을 리턴해주는 applyAsInt 메소드
		}
		return result;
	}


	public static void main(String[] args) {
		IntBinaryOperator oper = (a,b) -> {       // 람다식에서는 바깥 클래스의 필드나 메소드는 사용가능, 
			                                      // 메소드의 매개변수 또는 로컬변수를 사용하면 이 변수들은 final특성을 가져야한다.
				int result = (a >= b ? a : b);
				return result;
		};

		int result = minOrMax(oper);
		System.out.println("max: " + result);

		result = minOrMax((a, b) -> {
			return (a >= b ? b : a);
		} );
		System.out.println("결과값: " + result );
	}
}
