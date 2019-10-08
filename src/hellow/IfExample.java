package hellow;

public class IfExample {
	public static void main(String[] args) {
		int a = 90;
		if (a > 50 || a > 100) {
			System.out.println("50 이상");
			System.out.println("좋은 점수네요");
		} else {
			System.out.println("만점입니다");

			if (a > 90) {
				if (a >= 95) {
					System.out.println("A+");
				} else {
					System.out.println("A");
				}
			} else if (a > 80) {
				System.out.println("B");
			} else if (a > 70) {
				System.out.println("C");
			} else {
				System.out.println("F");
			}

		}
	}
}
