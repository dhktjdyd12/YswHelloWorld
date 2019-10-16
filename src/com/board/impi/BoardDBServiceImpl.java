package com.board.impi;

import java.util.List;

import com.board.model.BoardDB;
import com.board.model.BoardDBService;

public class BoardDBServiceImpl implements BoardDBService {  // BoardDBDAO로 가는 중간역할을 하는 클래스 BoardDBServiceImpl
	BoardDBDAO dao = new BoardDBDAO();
	
	@Override
	public String loginCheck(String id, String passwd) {
		String name = dao.getUserName(id, passwd);
		return name;
	}

	@Override
	public void insertBoard(BoardDB board) {      // BoardDBProc 에서 게시글 작성할 떄 실행한 메소드
		dao.insertBoard(board);                   // boardDBDAO(sql있는 곳)에  insertBoard메소드에 매개변수를 넣음
	}

	@Override
	public List<BoardDB> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardDB getBoard(int boardNo) {          // 게시글 한개 조회하는 역할
		return null;
	}

	@Override
	public List<BoardDB> getReply(int boardNO) {
		return null;
	}

	@Override
	public void insertReply(BoardDB board) {        // 댓글 작성하는 역할
		dao.replayBoard(board);
	}

	@Override
	public void updateBoard(BoardDB board) {             // 게시글 수정하는 메소드 재정의
		// 해당글에 대한 권한 학인
		if (dao.checkResponsibility(board)) {
			dao.updateBoard(board);
			System.out.println("변경되었씁니다.");
		} else {
			System.out.println("해당글에 대한 권한이 없습니다.");
			
		}
	}

	@Override
	public void deleteBoard(BoardDB board) {              // 삭제하는 메소드 재정의
		if(dao.checkResponsibility(board)) {                // 권한 체크
			if(!dao.checkForReply(board.getBoardNo())) {    // 댓글 유뮤 체크
				dao.deleteBoard2(board);
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("댓글이 존재합니다.");
			}
		} else {
			System.out.println("해당글에 대한 권한이 없습니다.");
		}
	}

}
