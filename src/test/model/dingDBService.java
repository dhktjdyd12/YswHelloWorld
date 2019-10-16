package test.model;

import java.util.List;

public interface dingDBService {     // 정의만 함

	public void createPerson(dingDB creates, List<dingDB> employeesAry); // 사원등록
	
	public dingDB checkPersonName(int boardNo, dingDB[] boards);  // 사원이름 조회
	
	public dingDB[] getDepartment(dingDB[] boards);               // 부서 전체 조회

	public void updateDepartment(dingDB board, dingDB[] boards);     // 부서 변경
	
	public void deletePerson(dingDB boardNo, dingDB[] boards);         // 퇴사처리
}
