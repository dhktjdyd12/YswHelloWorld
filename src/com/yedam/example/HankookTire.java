package com.yedam.example;

public class HankookTire extends Tire {
	HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	boolean roll() {
		this.accumulatedRotation++;
		if(maxRotation>accumulatedRotation) {
			int accumulateRotation = 0;
			System.out.println(location + " Hankook 타이어 수명:" + (maxRotation-accumulateRotation) + " 회");
			return true;
		} else {
			System.out.println("***" + location + " Hankook 타이어 펑크 **");
			return false;
		}
	}
	

}
