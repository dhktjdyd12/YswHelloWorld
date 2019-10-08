package com.yedam;

public class DmbCellPhoneExample {
	public static void main(String[] args) {
		DmbcellPhone dmbCell = new DmbcellPhone("S10", "white" , 10);
		System.out.println("model: " + dmbCell.model);
		System.out.println("color: " + dmbCell.color);
		System.out.println("channel: " + dmbCell.channel);
		dmbCell.powerOn(); // 부모 메소드
		dmbCell.turnOffDmb(); // 자식 메소드
		dmbCell.turnOffDmb();
		dmbCell.powerOff();
	}
}
