package hellow;

public class Bingo {
	public static void main(String[] args) {
		int[][] bisable = new int[2][];
		bisable[0] = new int[3];
		bisable[1] = new int[4];
		int a =8;
		for(int i=0; i<bisable.length; i++) {
			for(int j=0; j<bisable[i].length; j++) {
				bisable[i][j] = a++;
			}
		}
		for(int i=0; i<bisable.length; i++) {
			int sum = 0;
			for(int j=0; j<bisable[i].length; j++) {
				sum += bisable[i][j];
			}
		System.out.println("=> intAry[" + i + "] => 합:" +sum );
		}
//		System.out.println("=> intAry[0] => 합:27");
//		System.out.println("=> intAry[1] => 합:50");
	}
}