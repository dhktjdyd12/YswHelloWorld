package com.board.impi;

import com.board.model.Board;
import com.board.model.BoardService;

public class BoardServiceImpl2 implements BoardService {
	EmpDAO dao = new EmpDAO();
	@Override
	public void writeBoard(Board board, Board[] boards) {

	}

	@Override
	public Board getBoard(int boardNo, Board[] boards) {
		return null;
	}

	@Override
	public Board[] getBoardList(Board[] boards) {
		return null;
	}

}
