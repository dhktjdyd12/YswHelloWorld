package com.board.control;

public class BoardDBMain {
	public static void main(String[] args) {
		// 실행하는 프로그램이 있는 클래스가 있는 BoardDBProc 타입의 객체 bp 선언
		BoardDBProc bp = new BoardDBProc();
		
		// bp에 execute 메소드 실행
		bp.execute();
	}
}