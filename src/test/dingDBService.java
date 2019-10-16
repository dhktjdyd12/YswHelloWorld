package test;

public interface dingDBService {

	public String createPerson(String id, String passwd); // 사원등록
	
	public void checkPersonName();    // 사원이름 조회
	
	public void getDepartment(int boardNo);    // 부서별 조회

	public void updateDepartment(dingDB board);     // 부서 변경
	
	public void deletePerson(dingDB board);         // 퇴사처리
}
