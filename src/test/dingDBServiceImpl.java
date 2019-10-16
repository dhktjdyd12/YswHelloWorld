package test;

public class dingDBServiceImpl implements dingDBService {
	dingDBDAO das = new dingDBDAO();

	@Override
	public String createPerson(String id, String passwd) {
		String name = das.createPerson(id , passwd);
		return name;
	}

	@Override
	public void checkPersonName() {
		
	}

	@Override
	public void getDepartment(int boardNo) {
		
	}

	@Override
	public void updateDepartment(dingDB board) {
		
	}

	@Override
	public void deletePerson(dingDB board) {
		
	}

	

	
	
	
}
