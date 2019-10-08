package com.board.impi;

import com.board.model.Board;
import com.board.model.BoardService;

public class BoardServiceImpl implements BoardService {

	@Override
	public void writeBoard(Board board, Board[] boards) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				break;
			}
		}
	}

	@Override
	public Board getBoard(int boardNo, Board[] boards) {
		Board board = null;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == boardNo) {
				board = boards[i];
			}
		}
		return board;
	}

	@Override
	public Board[] getBoardList(Board[] boards) {
		Board[] resultAry = new Board[10];
		int cnt = 0;
		for (Board b : boards) {
			if (b != null) {
				resultAry[cnt++] = b;
			}
		}
//		System.arraycopy(boards, 0, resultAry, 0, cnt);
		return resultAry;
	}
}
