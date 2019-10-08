package com.yedam;

public class CellPhone {           // 자바에서 최상위 클래스가 Object클래스인데 이 Object클래스가 모든 클래스의 부모 클래스이다. 
	String model;
	String color;
	
	
	
	public CellPhone() {
		super();
	}

	public CellPhone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}
	
	void powerOn() {
		System.out.println("전원을 켭니다");
	}
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	void bell() {
		System.out.println("벨을 울립니다.");
	}
	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
