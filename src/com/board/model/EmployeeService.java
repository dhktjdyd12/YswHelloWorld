package com.board.model;

import java.util.List;

public interface EmployeeService {
	// ��ü ����Ʈ
		public List<Employee> getEmpList();
		// �Ѱ� ��ȸ
		public Employee getEmployee(int empNo);
		// �Ѱ� �Է�
		public void insertEmployee(Employee emp);
		// ���� ó��
		public void updateEmployee(Employee emp);
		// ����ó��
		public void deleteEmployee(int empNo);
	}


