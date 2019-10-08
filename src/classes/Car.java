package classes;

public class Car {
	/////////// 필드
	String model;
	String color;
	int price;
	int maxSpeeed;
	public int maxSpeed;
	/////////// 메소드
	void dirve() {                                               
		System.out.println(model + "의 최고속도는" + maxSpeed);
	}

	void stop() {
		System.out.println("멈춥니다.");
	}
}
