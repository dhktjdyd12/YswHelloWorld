package com.yedam.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;

class Fruit {
	// 전역변수(= 필드)
	String name;
	int price;
	
	// 생성자
	public Fruit(String name, int price) {        
		this.name = name;
		this.price = price;
	}
}

public class OperatorMinByMaxByExample {
	public static void main(String[] args) {     // main 메소드
		BinaryOperator<Fruit> bo;                // 제너릭타입 bo 선언
		Fruit fruit;                             // 제너릭타입 fruit 초기값 선언
		 
		
		Comparator<Fruit> com = new Comparator<Fruit>() {       // 객체 com 생성
			@Override
			public int compare(Fruit arg0, Fruit arg1) {  //두 값을 비교하는데 안에 어떻게 정의하느냐에 따라 처리하는 compare메소드
				int result = 0;
				if (arg0.price > arg1.price)          // 첫 번째 매개변수값이 두번째 매개변수 값보다 클 때 result값이 1
					result = 1;
				else if (arg0.price == arg1.price)    // 첫 번째 매개변수값이 두번째 매개변수 값보다 작을 때 result값이 0
					result = 0;
				else                                  // 위의 두 경우 다 아니면 result 값이 -1
					result = -1;
				return result;
			}
		};
//		bo = BinaryOperator.maxBy(com);            // 이거는 최대값을 리턴하는 maxby 메소드
//		bo = BinaryOperator.minBy(com);            // 최소값을 리턴하는 minBy 메소드에 객체 com을 bo에 대입
		
		bo = BinaryOperator.maxBy((a, b) -> {      // 람다식으로 최대값을 리턴하는 메소드 max를 bo에 대입
			return Integer.compare(a.price, b.price); // rapper클래스안에 compare 메소드를 첫번째 값과 두번째 값을  비교해 리턴
		});
		
		// BinaryOperator API 안에 apply메소드로 값을 fruit에 대입
		fruit = bo.apply(new Fruit("apple", 1000), new Fruit("banana", 2000)); 
		System.out.println(fruit.name + ", " + fruit.price);         // fruit에 값들을 출력
	}
}
