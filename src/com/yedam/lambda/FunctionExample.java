package com.yedam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

class Student {
	String name;
	int engScore;
	int matSecore;

	public Student(String name, int engScore, int matSecore) { // 생성자
		super();
		this.name = name;
		this.engScore = engScore;
		this.matSecore = matSecore;
	}

	public String getName() { // get메소드
		return name;
	}

	public int getEngScore() { // get메소드
		return engScore;
	}

	public int getMatSecore() { // get메소드
		return matSecore;
	}

}

public class FunctionExample {
	private static List<Student> list = Arrays.asList(  // 리스트인 변수list 생성 
			new Student("hong", 80, 96),                // 각각의 값을 대입
			new Student("kang", 85, 93)
	);

	public static void printString(Function<Student, String> func) {      // 제너릭타입인 func
		for (Student student : list) {                          //list에 저장된 항목 수 만큼 루핑
			System.out.println(func.apply(student));            // func 람다식 실행
		}
	}

	public static void printInt(ToIntFunction<Student> fun) {
		for (Student student : list) {
			System.out.println(fun.applyAsInt(student));
		}
	}
	
	public static double avg(ToIntFunction<Student> func) {  // 평균을 구하는 avg 메소드
		int sum=0, cnt=0;                 // sum과 cnt에 초기값을 넣어줌
		for (Student studnet : list) {    // list에 있는 값을 하나씩 student에 루핑
			cnt++;                           // cnt는 1씩 증감
			sum += func.applyAsInt(studnet); // 람다식 실행
		}
		return (double) sum / cnt;    // sum값을 cnt로 나눈값을 리턴
	}	

	public static void main(String[] args) {        // main 메소드
//		Function<Student, String> func = (t) -> {
//			return t.getName();
//		};
		printString((t) -> {         // 람다식 t
			return t.getName() + ":입니다." ;
		});
		ToIntFunction<Student> func = new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student value) {
				return value.getEngScore();
			}
		};
		System.out.println("영어점수");
		printInt(func);
		
		System.out.println("수학점수");
		printInt((s) -> {
			return s.getMatSecore();
		});
		
		
		System.out.println("영어평균점수: ");
		ToIntFunction<Student> func2 = new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student value) {
				return value.getEngScore();
			}
		};
		double result = avg(func2);
		System.out.println("result : " + result);
		
		System.out.println("수학평균점수: ");
		result = avg((t) -> {
			return t.getMatSecore();
		});    // 수학평균.. 람다식.
		System.out.println("result : " + result);
	}
}
