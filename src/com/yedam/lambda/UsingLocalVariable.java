package com.yedam.lambda;

interface MyLocalInterface {
	public void method();
}

public class UsingLocalVariable {
	void method(int arg) {  // arg는 final 변경불가
		int localVal =0;    // localVar는 final 변경불가
		arg = 20;
		localVal = 20;
		
		//람다식
		/* 람다표현식을 쓰면 외부 표현에 대해서 선언만할때는 참조가 되는데
		값이 바뀌면 참조가 안된다. */
		MyLocalInterface lif = () -> {
			// 로컬변수 사용
//			arg = 10;
//			localVal = 20;
//			System.out.println(arg);
//			System.out.println(localVal);
		};
	}
}
