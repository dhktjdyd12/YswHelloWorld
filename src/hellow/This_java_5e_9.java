package hellow;

import java.util.Scanner;

public class This_java_5e_9 {
	public static void main(String[] args) {
		boolean run = true;  
		  
		  int studentNum = 0;
		  int[] scores = null;
		  
		  Scanner scanner = new Scanner(System.in);  // sc는 scanner의 약자, 여기서 scanner를 sc로 적으면 밑에도 sc 적어야함
		  											 // sc나 scanner나 변수 이름임
		  while(run) {
		   System.out.println("---------------------------------------------");
		   System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		   System.out.println("---------------------------------------------");
		   System.out.print("선택> ");
		   
		   int selectNo = scanner.nextInt();            
		   
		   if(selectNo == 1) {
		// 학생수만큼 배열생성 
		    System.out.print("학생수> ");
		    studentNum = scanner.nextInt();         // studentNum = sc.nextInt 로도 작성가능 sc는 scanner를 따라감
		    scores = new int[studentNum];
		
		   } else if(selectNo == 2) {
		// 생선된 배열 점수 입력
		    for(int i=0; i<scores.length; i++) {
		     System.out.print("scores[" + i + "]> ");
		     scores[i] = scanner.nextInt();
		
		    }
		   } else if(selectNo == 3) {
		// 배열입력된 전체 조회 
		    for(int i=0; i<scores.length; i++) {
		     System.out.println("scores[" + i + "]: " + scores[i]);
		
		    }
		   } else if(selectNo == 4) {
		//큰값, 평균 
		    int max = 0;
		    int sum = 0;
		    double avg = 0;
		    for(int i=0; i<scores.length; i++) {
		     max = ( max<scores[i] ) ? scores[i] : max;
		     sum += scores[i];
		    }
		    avg = (double) sum / studentNum;
		    System.out.println("최고 점수: " + max);
		    System.out.println("평균 점수: " + avg);
		// 종료 
		   } else if(selectNo == 5) {
		    run = false;

		   }
		  } 
		  
		  System.out.println("프로그램 종료");
		 }
		}

