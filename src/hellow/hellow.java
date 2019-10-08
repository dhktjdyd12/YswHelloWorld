package hellow;

public class hellow {
	public static void main(String[] args) {
		int num1 = 10;
		int a = 5, b = 7;
		num1 = a++ + ++b;             // 각각 6, 8 이 나옴 계산하면 ++가 앞에있는 b를 먼저 계산해 8로 나오고 a를 더하면 12가 나오고 
		                              // 마지막으로 a의 ++를 계산하면 12에서 13이 됨
		System.out.println(a + ", "+ b); //13이 나옴
		System.out.println("num1 : " + num1);
		
		System.out.println(3 >5 );
		
		if (3<5)
			System.out.println("OK");
		//else
		// Sysytem.out.println("No");
		
		num1 += 3;   //num1 = num1 + 3
	}
}
