package TestSocre;

import java.util.Scanner;

import hellow.Member;

public static void main(String[] args) {
	int[] arraystudent = new int[100];
	String[] arraystdentname = new int[100];
	Scanner sc = new Scanner (System.in);
	
	boolean ma = true;
	while(ma) {
		System.out.println("1.학생번호|2.이름 |3.국어|4.영어|5.수학|6.전체통계|7.총점|8.평균|9.종료");
		int suntec = sc.nextInt();
			
		if (suntec == 1) {
			viewstnum();
		} else if(suntec == 2) {
			viwwstudentname();
		} else if(suntec == 3) {
			viewguk();
		} else if(suntec == 4) {
			viewengsh();
		} else if (suntec == 5) {
			viewmath();
		} else if (suntec == 6) {
			allview();
		} else if (suntec == 7) {
			allsumview();
		} else if (suntec == 8) {
			allavgview();
		} else if (suntec == 9) {
			ma = false;
		}
	}
}

public static void viewstnum() {
	System.out.println("학생 번호를 입력해주세요");
	int suntec2 = sc.nextInt();

	for (int a : arraystudent) {
		if (a != null) {
			System.out.println("학생 번호는" + get.stnum);
		}
	}
}

public static void viwwstudentname() {
	System.out.println("학생이름을 입력해주세요");
	int suntec3 = sc.nextInt();

	for (int b : arraystdentname) {
		if (b != null) {
			System.out.println("학생 이름은" + get.Stname);
		}
	}
}

public static void viewguk() {
	System.out.println();
}

public static void viewengsh() {
	
}

public static void viewmath() {
	
}

public static void allview() {
	
}

public static void allsumview() {
	
}

public static void allavgview(); {
	
}
}
