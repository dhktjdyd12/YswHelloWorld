package com.board.model;

import java.util.List;

public interface BoardDBService {       // 어떤 기능이 있는지만 정의하고 실제 기능을 하는 곳은 BoardDBServiceImpl
	
	public String loginCheck(String id, String passwd); // 로그인 체크

	public void insertBoard(BoardDB board);             // 게시글 작성

	public List<BoardDB> getBoardList();               // 게시글 리스트

	public BoardDB getBoard(int boardNo);               // 한건 조회

	public List<BoardDB> getReply(int boardNO);         // 댓글조회

	public void insertReply(BoardDB board);             // 댓글추가

	public void updateBoard(BoardDB board);             // 수정

	public void deleteBoard(BoardDB board);             // 삭제

}
