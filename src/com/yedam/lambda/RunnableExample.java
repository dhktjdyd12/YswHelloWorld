package com.yedam.lambda;

public class RunnableExample {
	public static void main(String[] args) {  // main 메소드
		Runnable runnable = new Runnable() {  // runnable 객체 생성
			@Override
			public void run() {               // main메소드안에서 실행되는 run메소드
				for (int i=0; i<5; i++) {
					System.out.println("a=>" + i);  // a=> 0부터 5까지 출력
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rnnable run");
			}
		};
		
		Thread thread = new Thread(runnable); // runnable 객체를 받는 thread 객체 생성
		thread.start();                       // Thread API안에 실행을 의미하는 start메소드
		
		Thread thread2 = new Thread( () -> {
			for (int i=0; i<5; i++) {
				System.out.println("b=>" + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} );
		thread2.start();
		
	}
}
