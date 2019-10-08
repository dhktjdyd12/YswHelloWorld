package hellow;

public class ForExample2 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=10; i++) {
			if( i/2 == 1) {
			sum = sum +  i;
			}
		System.out.println("sum의 값은 " + sum);
		}
	}
}