package com.yedam;

public class DmbcellPhone extends CellPhone {
	int channel;

	public DmbcellPhone(int channel) {
		super();                            // 부모 클래스를 가르키는게 super메소드임
		this.channel = channel;
	}

	public DmbcellPhone() {
		super();
	}

	public DmbcellPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
	} 
	
	void turnOnDmb( ) {
		System.out.println("채널"+ channel + "번 방송수신을 시작합니다.");
	}
	
	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel +"번으로 변경합니다.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB 방송을 종료합니다.");
	}
}
