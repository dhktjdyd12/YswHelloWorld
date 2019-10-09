package com.board.control;

import java.util.List;
import java.util.Scanner;

import com.board.impi.EmployeeServiceImpl;
import com.board.model.Board;
import com.board.model.Employee;
import com.board.model.EmployeeService;

public class EmpProc {

	Scanner sc = new Scanner(System.in);
	EmployeeService service = new EmployeeServiceImpl();

	public void execute() {
		while (true) {
			System.out.println("메뉴선택하세요.");
			System.out.println("1.작성 2.단건조회 3.전체조회 4.삭제 5.종료");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				writeBoard();
			} else if (menu == 2) {
				getBoard();
			} else if (menu == 3) {
				getBoardList();
			} else if (menu == 4) {
				deleteBoardList();	
			} else if (menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		System.out.println("프로그램 종료.");
	}

	public void writeBoard() {
		System.out.println("직원등록");
		System.out.println("직원번호입력:");
		int empId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("이름을 입력하세요.");
		String firstName = sc.nextLine();
		
		System.out.println("성을 입력하세요.");
		String lastName = sc.nextLine();
		
		System.out.println("email 입력하세요.");
		String email = sc.nextLine();
		
		System.out.println("입사일 입력하세요.");
		String hireDate = sc.nextLine();
		
		System.out.println("급여 입력하세요.");
		int salary = sc.nextInt();sc.nextLine();
		
		System.out.println("JobId 입력하세요.");
		String jobId = sc.nextLine();
		
		Employee emp = new Employee();
		emp.setEmployeeId(empId);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setHireDate(hireDate);      // 2010-10-05
		emp.setSalary(salary);
		emp.setEmail(email);
		emp.setJobId(jobId);
//		service.writeBoard(board, boardAry);
//		service.insertEmployee(emp);
	}

	public void getBoard() {
		System.out.println("한건조회.");
		System.out.println("조회할 번호를 입력:");
		int boardNo = sc.nextInt();
		Employee emp = service.getEmployee(boardNo);
		System.out.println(emp);
		
		
//		Board board = service.getBoard(boardNo, boardAry);
//		System.out.println(board);

	}

	public void getBoardList() {
		System.out.println("전체글조회.");
		List<Employee> employees = service.getEmpList();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}
	
	private void deleteBoardList() {
		System.out.println("삭제할 직원을 입력해주세요");
		String delEmployee = sc.nextLine();
		
		
	}
}
