package com.yedam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class HighStudent {
	String name;
	String sex;
	int score;

	public HighStudent(String name, String sex, int score) {
		super();
		this.name = name;
		this.sex = sex;
		this.score = score;
	}

	public String getName() {          // get메소드
		return name;
	}

	public String getSex() {           // get메소드
		return sex;
	}

	public int getScore() {            // get메소드
		return score;
	}
}

public class PredicateExample {
	static List<HighStudent> list = Arrays.asList(      // list 생성
			new HighStudent("홍길동", "남자", 90),        //  리스트에 대입
			new HighStudent("김순희", "여자",90),
			new HighStudent("박길동", "남자", 85),
			new HighStudent("박순희", "여자", 92)
			);
	
	// 참이나 거짓을 리턴하는 자바API Predicate에  인수pred를 담는 메소드avg
	static double avg(Predicate<HighStudent> pred) {  
		boolean bool = false;
		int cnt = 0, sum = 0;
		
		for(HighStudent student : list) {
			bool = pred.test(student);     // getSex()="남자"인 경우만 bool에 담음 
			if(bool) {
				cnt++;
				sum += student.getScore();
			}
		}
		return (double) sum / cnt;
	}
	
	// main 메소드
	public static void main(String[] args) {
		Predicate<HighStudent> pred = new Predicate<HighStudent>() {   // 객체 pred 선언
			@Override
			public boolean test(HighStudent t) {   // test메소드 오버라이딩
				return t.getSex().equals("남자");   // 성별을 가져와서 남자인 경우에만 해당 값을 리턴
			}
		};
		double avg = avg(pred);
		System.out.println("남자평균" + avg);
	
		avg = avg((t) -> {
			return t.getSex().equals("여자");       // 성별을 가져와서 여자인 경우메만 해당 값을 리턴
		});
		System.out.println("여자평균" + avg);
	}
}
