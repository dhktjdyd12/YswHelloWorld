package test.model;

public class dingDB {
	private int personNumber;   // 사원번호
	private String name;        // 사원명
	private String department;  // 부서
	private int salary;         // 급여
	private String hireDate;    // 입사일

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "dingDB [personNumber=" + personNumber + ", name=" + name + ", department=" + department + ", salary="
				+ salary + ", hireDate=" + hireDate + "]";
	}

}
