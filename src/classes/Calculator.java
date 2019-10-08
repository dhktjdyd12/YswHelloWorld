package classes;

public class Calculator {
	static double pi = 3.14;
	static double minus(double x, double y) {
		return x - y;
	}
	static double plus(double x, double y) {
		return x + y;
	}
	int plus(int x, int y) { // main메소드가 아니면 public static이 없어도 됨
		int result = x + y;
		return result;
	}

	double avg(int a, int b) {
		int sum = plus(a, b);
		double result = sum / 2;
		return result;

	}

	void execute(int a,int b) { // 메소드
		double result = avg(a, b);
		println("result" + result);

	}

	void println(String str) {
		System.out.println(str);
	}
}
