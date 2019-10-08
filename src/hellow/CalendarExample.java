package hellow;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력하세요");
		int year = sc.nextInt();
		System.out.println("년도를 입력하세요");
		int month = sc.nextInt();
	}

	public static void getCal(int year, int month) {
		Calendar cal = Calendar.getInstance();
		Object translateMonth;
		cal.set(year, translateMonth, 1);
		String[] week = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		int monthDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int sDay = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("           <<" + month + "월달   >>");
		for (String str : week) {
			System.out.printf("%4s", str);         //문자열 형식으로 출력
		}
		for (int i = 1; i < sDay; i++) {
			System.out.printf("%4s", "");
		}
		for (int i = 1; i <= monthDay; i++) {
			System.out.printf("%4d", i);           //출력할 자릿수가 4인 정수 
			if ((sDay + i - 1) % 7 == 0);
		}

		}
}	

