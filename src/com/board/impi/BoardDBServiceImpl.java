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
		return null;
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
		
	}

	@Override
	public void updateBoard(BoardDB board) {
		
	}

	@Override
	public void deleteBoard(int boardNo) {
		
	}

}
