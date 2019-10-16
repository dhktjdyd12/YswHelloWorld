package test;

import java.util.Scanner;



public class dingDBProc {
	Scanner sc = new Scanner(System.in);
	dingDBService service = new dingDBServiceImpl(); // BoardDBService, BoardDBServiceImpl 두 기능을 쓸 수 있는
													   // 객체 service를 새로 생성
	String loginId = null;

	
	public void execute() { // 프로그램을 실행하는 execute 메소드
		while (true) {
			System.out.println("1.사원등록|2.사원이름 조회|3.부서별 조회|4.부서 변경|5.퇴사처리|6.종료");
			int menu = sc.nextInt();sc.nextLine();
			
			if (menu == 1) {
				createPerson();
			} else if (menu == 2) {
				checkPersonName();
			} else if (menu == 3) {
				checkDepartment();
			} else if (menu == 4) {
				updateDepartment();
			} else if (menu == 5) {
				deletePerson();
			} else if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
		}
	}

	private void createPerson() {       // 1번 사원등록
		System.out.println("직원등록");
		System.out.println("직원번호입력:");
		int empId = sc.nextInt();sc.nextLine();
		
		System.out.println("이름을 입력하세요.");
		String firstName = sc.nextLine();
		
		dingDB oms = new  dingDB();
		oms.setPersonNumber(10);
		oms.setDepartment(department);
	}
	
	private void checkPersonName() {    // 2번 사원이름 조회
		
	}

	private void checkDepartment() {    // 3번 부서별 조회
		
	}

	private void updateDepartment() {   // 4번 부서 변경
		
	}

	private void deletePerson() {       // 5번 퇴사
		
	}
	
}
