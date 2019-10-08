package hellow;

import java.util.Scanner;

public class ArrayTest {
	 public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in); 
		 * System.out.println("input int type");
		 * int a = sc.nextInt(); 
		 * System.out.println("next input"); 
		 * int b = sc.nextInt();
		 * System.out.println("next input");
		 * int c = sc.nextInt(); 
		 * int sum = a + b + c;
		 * System.out.println("합은: " + sum);
		 */
		 int a , b, result =0;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("첫번째 값을 입력");
		 a = sc.nextInt();
		 System.out.println("두번째 값을 입력");
		 b = sc.nextInt();
		 result = (a > b ? a : b);
		 System.out.println("두수중에 큰 수는");
	}
}
