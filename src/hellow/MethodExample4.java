package hellow;

public class MethodExample4 {
	public static void main(String[] args) {
		showCal(9);
	}

	public static void showCal(int mon) {
		String[] week = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		int month = 8;
		int monthDay = getMonthday(month);
		int sDay = getStartday(month);
		System.out.println("           <<" + month + "월달   >>");
		for (String str : week) {
			System.out.printf("%4s", str);         //문자열 형식으로 출력
		}
		System.out.println();
		for (int i = 1; i < sDay; i++) {
			System.out.printf("%4s", "");
		}
		for (int i = 1; i <= monthDay; i++) {
			System.out.printf("%4d", i);           //출력할 자릿수가 4인 정수 
			if ((sDay + i - 1) % 7 == 0)
				System.out.println();
		}
	}

	public static int getStartday(int month) {
		int startDay = 0;
		if (month == 9) {
			startDay = 1;
		} else if (month == 10) {
			startDay = 3;
		} else if (month == 11) {
			startDay = 6;
		} else if (month == 8) {
			startDay = 5;
		}
		return startDay;
	}

	public static int getMonthday(int month) {
		int day = 0;
		if (month == 2) {
			day = 28;
		} else if (month <= 7 && month % 2 == 1) {
			day = 31;
		} else if (month >= 8 && month % 2 == 1) {
			day = 31;
		} else {
			day = 30;
		}
		return day;
	}

}
