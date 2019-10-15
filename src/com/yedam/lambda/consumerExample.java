package com.yedam.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;


public class consumerExample {
	public static void main(String[] args) {    // main 메소드
		Consumer<String> consumer = (t) -> {    // 제너릭타입이 String인 변수 consumer에 람다식 
			System.out.println(t + "8");
		};
		consumer.accept("java");             //자바 API bitConsumver안에 들어있는 accept메소드
		
		BiConsumer<String, String> biConsumer = (t, u) -> { //중복제너릭타입, 람다식 t,u
			System.out.println(t + u);       
		};
		biConsumer.accept("java", "8");       //자바 API bitConsumver안에 들어있는 accept메소드
		
		DoubleConsumer doubleConsumer = (d) -> {
			System.out.println("java" + d);
		};
		doubleConsumer.accept(8.0);
		
		ObjIntConsumer<String> objConsumer = (s,i) -> { // ObjIntConsumer
			System.out.println(s + i);
		};
		objConsumer.accept("java", 8);        //자바 API bitConsumver안에 들어있는 accept메소드
	}
}
