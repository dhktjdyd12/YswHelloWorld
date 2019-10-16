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
		int results; // final
		IntBinaryOperator oper = new IntBinaryOperator;
			int results = 10;
			@Override
			public int applyAsInt(int a, int b ) {
				System.out.println("in Method" + ++results);
			}
		};
	results = 10;
	System.out.println(results + " max: " + minOrMax(oper));
			
		oper = (a,b) -> {
				System.out.println(results);              // results가 참조하고있는 값은 final이라 참조하는 값에 다른 값이 들어가면
				                                          // results가 참조를 제대로 못해 에러가 발생한다.
				return result = (a >= b ? a : b);
		};

	}
}
