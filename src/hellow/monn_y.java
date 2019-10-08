package hellow;

import java.util.Scanner;

public class monn_y {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int Bcd = sc.nextInt();
		Bcd(Bcd);
	}
	public static void Bcd(int Bcd) {
		int mosy = 567580;
		int[] Abc = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for (int i=0; i<Abc.length; i++) {
			int das1 = mosy / Abc[i];
			int das2 = mosy % Abc[i];
			mosy = das2;
			System.out.println(Abc[i] +"원으로 나누면 "+das1+ "장" + " 이를 나눈 나머지 값은" + das2 + "입니다.");
		}
	}
}
