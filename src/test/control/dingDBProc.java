package test.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.board.model.Board;

import test.impl.dingDBServiceImpl;
import test.model.dingDB;
import test.model.dingDBService;


public class dingDBProc {
	List<dingDB> employeesAry = new ArrayList<>();
	boolean run = true;
	Scanner sc = new Scanner(System.in);
	dingDBService service = new dingDBServiceImpl(); // BoardDBService, BoardDBServiceImpl 두 기능을 쓸 수 있는
													 // 객체 service를 새로 생성

	public void execute() { // 프로그램을 실행하는 execute 메소드
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.사원등록|2.사원이름 조회|3.부서별 조회|4.부서 변경|5.퇴사처리|6.종료");
			System.out.println("---------------------------------------------------------");
			System.out.println("메뉴선택>");
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
				run = false;
			} 
		}
	}

	private void createPerson() {       // 1번 사원등록
		System.out.println("직원등록");
		System.out.println("직원번호입력:");
		int personNumber = sc.nextInt();sc.nextLine();
		
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("부서를 입력하세요");
		String department = sc.nextLine();
		
		System.out.println("급여 입력하세요.");
		int salary = sc.nextInt();
		
		System.out.println("입사일 입력하세요.");
		String hireDate = sc.nextLine();
		
		dingDB creates = new dingDB(personNumber, name, department, salary, hireDate);
		service.createPerson(creates, employeesAry);
		
		
		dingDB emp = new dingDB();               // 객체 emp 생성
		emp.setPersonNumber(personNumber);
		emp.setName(name);
		emp.setDepartment(department);
		emp.setSalary(salary);
		emp.setHireDate(hireDate);
	}
	
	private void checkPersonName() {             // 2번 사원이름 조회
		System.out.println("한건조회.");
		System.out.println("조회할 사원번호를 입력:");
		int emp = sc.nextInt();
		
		dingDB emp1 = service.checkPersonName(emp, boards);
		System.out.println(emp1);
	}

	private void checkDepartment() {            // 3번 부서별 조회
		System.out.println("부서조회");
		String asd = sc.nextLine();
		
		if (asd != null) {        // 부서조회
			dingDB emp1 = service.checkPersonName(emp, boards);
			System.out.println(emp1);
		} else if (asd == null) {  // 부서조회에 값을 입력안했을 때 전체조회
			dingDB emp2 = service.getDepartment(boards);
		}
	}

	private void updateDepartment() {           // 4번 부서 변경
		System.out.println("변경 전 부서를 입력하세요");
		String pastDepartment = sc.nextLine();
		
		System.out.println("변경 할 부서를 입력하세요");
		String NowDepartment = sc.nextLine();
		
		dingDB departs = new dingDB(pastDepartment, NowDepartment);
		service.updateDepartment(board, employeesAry);
		
	}

	private void deletePerson() {            // 5번 퇴사
		System.out.println("퇴사하는 직원을 입력.");
		String mems = sc.nextLine();
		service.deletePerson(mems, employeesAry);
		
		
	}
	
}
