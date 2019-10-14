package com.board.impi;

import java.util.List;

import com.board.model.BoardDB;
import com.board.model.BoardDBService;

public class BoardDBServiceImpl implements BoardDBService {  // BoardDBServiceImpl  BoardDBService 안에 있는 게 같아야한다.
	BoardDBDAO dao = new BoardDBDAO();
	
	@Override
	public String loginCheck(String id, String passwd) {
		String name = dao.getUserName(id, passwd);
		return name;
	}

	@Override
	public void insertBoard(BoardDB board) {
		dao.insertBoard(board);
	}

	@Override
	public List<BoardDB> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardDB getBoard(int boardNo) {
		return null;
	}

	@Override
	public List<BoardDB> getReply(int boardNO) {
		return null;
	}

	@Override
	public void insertReply(BoardDB board) {
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
