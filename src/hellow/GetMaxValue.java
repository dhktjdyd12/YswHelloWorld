package hellow;

import java.util.Scanner;

public class GetMaxValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ied = new int[5];
				
		for (int j=0; j<ied.length; j++) {
			System.out.println("값을 입력하시오");
			ied[j] = sc.nextInt();
		}
		int ied2 = 0;
		for(int j=0; j<ied.length; j++) {
			if(ied2 < ied[j] );
			   ied2 = ied[j];
			   // ied2 = ( (ide2 < ied[j]) ? ied2 : ide[j])
		
		}
	System.out.println("제일 큰 값은"+ied2);

	}
	
}
	
	

