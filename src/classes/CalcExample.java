package classes;

public class CalcExample {
	public static void main(String[] args) {
//		Calculator cal = new Calculator();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수를 입력하세요");
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		cal.execute(a, b);
		Calculator.plus(23.5,  10.2);        // static이 붙으면 instance를 안만들고 이렇게 쓸 수 있다.
		Calculator.minus(23.5,  10.2);
		Calculator cal = new Calculator();
		cal.execute(0, 0);

		}
	}


