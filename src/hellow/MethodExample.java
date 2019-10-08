package hellow;

public class MethodExample {
	public static void main(String[] args) {
		/* 배열 */
		int[] intAry sum2 = { 2, 3, 4, 5,6};
		int sum = 0;
		sum = sum2(intAry);
		for (int i=0; i<sum2.length; i++) {
			sum += sum2[i];
		}
		return sum
		}
