package test.impl;

import com.board.model.Board;

import test.model.dingDB;
import test.model.dingDBService;

public class dingDBServiceImpl implements dingDBService {   // dingDBService의 기능을 작
	dingDBDAO das = new dingDBDAO();

	@Override
	public void createPerson(dingDB id, dingDB passwd) {   // 사원등록
		for (int i = 0; i < dingDB.length; i++) {
			if (boards[i] == null) {
				boards[i] = dingDB;
				break;
			}
		}
	}

	@Override
	public dingDB checkPersonName(int boardNo, dingDB[] boards) { // 사원이름 조회
		dingDB board = null;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == boardNo) {
				board = boards[i];
			}
		}
		return board;
	}

	@Override
	public dingDB[] getDepartment(dingDB[] boards) {  // 부서별 조회
		Board[] resultAry = new Board[10];
		int cnt = 0;
		for (Board b : boards) {
			if (b != null) {
				resultAry[cnt++] = b;
			}
		}
		return resultAry;
	}

	@Override
	public void updateDepartment(dingDB board) {    // 부서 변경
		
	}

	@Override
	public void deletePerson(dingDB board) {        // 퇴사처리
		
	}

	
	
}
