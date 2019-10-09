package com.board.impi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.common.DAO;
import com.board.model.Employee;

public class EmpDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

//	public void deleteEmployee(int empNo) {
//		conn = DAO.getConect();
//		String sql = "delete from emp_tamp where employee_id = ?";
//		Employee del1= null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			
//		}
//	}
	
	
	public Employee getEmployee(int empId) {
		conn = DAO.getConect();                                        // DB 연결해주는 것
		String sql = "select * from employees where employee_id = ?";  // sql변수에 이 구문을 담음 
		String sql1 = "{? = call get_dept_name(?)}";
		Employee emp = null;                                           // emp변수가 null이다.
		try {  
			pstmt = conn.prepareStatement(sql);                //DB에 위에서 입력받은 구문은 pstmt에 담는다.
			pstmt.setInt(1, empId);                            //int타입으로  매개변수 첫번째값을 empId를 대입
			rs = pstmt.executeQuery();                         // 위에 매개변수가 들어있는 쿼리문을 rs에  대입해 실행
			
			CallableStatement cstmt = conn.prepareCall(sql1);          // function을 호출
			cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			cstmt.setInt(2, empId);
			cstmt.execute();
			String deptName = cstmt.getString(1);
			
			if(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("Email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("Salary"));
				emp.setDeptName(deptName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;			
	}
	public void insertEmpProc(Employee emp) {
		conn = DAO.getConect();
		String sql = "{call add_new_member(?,?,?,?,?,?)}";
		try {
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, emp.getFirstName());
			cstmt.setString(2, emp.getLastName());
			cstmt.setString(3, emp.getJobId());
			cstmt.setInt(4, emp.getSalary());
			cstmt.setString(5, emp.getHireDate());
			cstmt.setString(6, emp.getEmail());
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);  
			cstmt.getString(7);
			cstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
	}

	
	public void insertEmp(Employee emp) {
		conn = DAO.getConect();
		String sql = "insert into employees(employee_id," + "first_name, last_name, email, job_id,"
				+ "hire_date, salary) values (?,?,?,?,?,?,?)";
		int rCnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++rCnt, emp.getEmployeeId());
			pstmt.setString(++rCnt, emp.getFirstName());
			pstmt.setString(++rCnt, emp.getLastName());
			pstmt.setString(++rCnt, emp.getEmail());
			pstmt.setString(++rCnt, emp.getJobId());
			pstmt.setString(++rCnt, emp.getHireDate());
			pstmt.setInt(++rCnt, emp.getSalary());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Employee> getEmpList() {
		List<Employee> list = new ArrayList<>();
		Connection conn = DAO.getConect();
		String sql = "select * from employees";
		Employee emp = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("hire_date"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;

	}
}
