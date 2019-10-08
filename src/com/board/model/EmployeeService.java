package com.board.model;

import java.util.List;

public interface EmployeeService {
	// 전체 리스트
		public List<Employee> getEmpList();
		// 한건 조회
		public Employee getEmployee(int empNo);
		// 한건 입력
		public void insertEmployee(Employee emp);
		// 변경 처리
		public void updateEmployee(Employee emp);
		// 삭제처리
		public void deleteEmployee(int empNo);
	}


