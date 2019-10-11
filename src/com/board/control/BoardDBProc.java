package com.board.control;

import java.util.List;
import java.util.Scanner;

import com.board.impi.BoardDBServiceImpl;
import com.board.model.Board;
import com.board.model.BoardDB;
import com.board.model.BoardDBService;

public class BoardDBProc {
	Scanner sc = new Scanner(System.in);
	BoardDBService service = new BoardDBServiceImpl();
	Board[] boardAry = new Board[10];
	String loginId = null;

	public void execute() {
		loginCheck();
		while (true) {
			System.out.println("1.게시글작성|2.게시글리스트|3.글조회|4.글내용수정|5.글번호 변경|9.종료");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				createBoard();
			} else if (menu == 2) {
				checkBoardList();
			} else if (menu == 3) {
				getBoard();
			} else if (menu == 4) {
				updateBoard();
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

	private void loginCheck() {
		while (true) {
			System.out.println("Id를 입력해주세요");
			String Id = sc.nextLine();
			System.out.println("passwd를 입력해주세요.");
			String passwd = sc.nextLine();
			String name = service.loginCheck(Id, passwd); // loginCheck를 따라가보면 loginId만 적히고 passwd는 안니온다.
			if (name != null) {
				System.out.println(name + "환영합니다.");
				loginId = Id; // 전역변수의 loginIdid를 쓴다.
				break;
			} else {
				System.out.println("아이디와 비밀번호를 다시 입력해주세요");
			}
		}
	}

	private void createBoard() {
		System.out.println("제목을 작성해주세요");
		String title = sc.nextLine();
		System.out.println("내용을 작성해주세요");
		String content = sc.nextLine();

		BoardDB das = new BoardDB();
		das.setTitle(title);
		das.setContent(content);
		das.setWriter(loginId);
		service.insertBoard(das); // 실행한 값을 갖고 와서 여기서 적용시키는 구문
	}

	private void checkBoardList() {
		System.out.println("전체 조회");
		BoardDB[] okList = service.getBoardList(boardAry);
		for (Board board : okList) {
			if (board != null) {
				System.out.println(board);
			}
		}
	}

	private void getBoard() {
		System.out.println("조회할 글 번호를 입력해주세요.");
		int boardNo = sc.nextInt();sc.nextLine();
		// 원본 글
		System.out.println("------[원본글]-------");
		BoardDB board = service.getBoard(boardNo);
		if (board != null) {
			System.out.println("제목: " + board.getTitle());
			System.out.println("내용: " + board.getContent());
			System.out.println("작성자: " + board.getWriter());
			System.out.println("작성일자: " + board.getCreationDate());
			// 댓글
			List<BoardDB> list = service.getReply(boardNo);
			if (list.size() > 0 ) {
				System.out.println("-------[댓글]------------------");
				for (BoardDB brd : list ) {
					System.out.println("->" + brd.getBoardNo() + "|"
											+ brd.getContent() + "|"
											+ brd.getCreationDate() + "|");
				}
				System.out.println("------------------------------");
			} else {
				System.out.println(" [댓글]이 없습니다.");
			}
			System.out.println("1.댓글작성 2.이전메뉴");
			int subMenu = 0;
			subMenu = sc.nextInt();sc.nextLine();
			if (subMenu == 1 ) {
				System.out.println("댓글 입력");
				String reply = sc.nextLine();
				BoardDB board1 = new 
			}
		}
		}

	private void updateBoard() {
		System.out.println("변경할 글번호를 입력하세요.");
		int boardNo = sc.nextInt();sc.nextLine();
		System.out.println("제목 변경");
		String title = sc.nextLine();
		System.out.println("내용 변경");
		String content = sc.nextLine();
		BoardDB board = new BoardDB();
		board.setBoardNo(boardNo);
		board.setContent(content);
		board
	}

}
