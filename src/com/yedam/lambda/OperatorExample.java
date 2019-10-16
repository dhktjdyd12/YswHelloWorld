package com.yedam.lambda;

import java.util.function.IntBinaryOperator;
class IBOSample implements IntBinaryOperator {
	int results = 0;
	@Override
	public int applyAsInt(int left, int right) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
public class OperatorExample {
	static int[] scores = { 92, 95, 87, 90 };

	static int minOrMax(IntBinaryOperator oper) {
		int result = scores[0];
		for (int score : scores) {
			result = oper.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		int results = 0;
		IntBinaryOperator oper = new IntBinaryOperator() {
			int results = 10;
			@Override
			public int applyAsInt(int a, int b) {
				System.out.println("in Method: " + ++results);
				return results;
			}
		};
//		results = 10;
//		results = minOrMax(oper);
		System.out.println(results + " max: " + minOrMax(oper));
		oper = (a, b) -> {
			return results;
//			return (a >= b ? b : a);
		};
//		results = minOrMax(oper);
//		System.out.println("min: " + minOrMax((a, b) -> {
//			return (a >= b ? b : a);
//		}));
	}
}