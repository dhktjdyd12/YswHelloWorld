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

	
	public void execute() { // 프로그램을 실행하는 execute 메소드
		loginCheck();       // 회원인지 체크하는 메소드
		while (true) {
			System.out.println("1.게시글작성|2.게시글리스트|3.글조회|4.글내용수정|5.글번호변경|6.댓글 조회|7.종료");
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
			} else if (menu == 5) {
				deleteBoard();
			} else if (menu == 6) {
				getReply();
			}else if (menu == 7) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}



	private void loginCheck() {                       // 회원인지 확인하는 메소드
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

	private void createBoard() {                       // 게시글 작성하는 메소드
		System.out.println("제목을 작성해주세요");
		String title = sc.nextLine();
		System.out.println("내용을 작성해주세요");
		String content = sc.nextLine();

		BoardDB das = new BoardDB();
		das.setTitle(title);
		das.setContent(content);
		das.setWriter(loginId);
		service.insertBoard(das);          // 실행한 값을 갖고 와서 여기서 적용시키는 구문
	}

	private void checkBoardList() {                     // 게시글 리스트 조회하는 메소드
		System.out.println("-------[전체글]-------");
        System.out.println("==============================");
        System.out.println("글번호 |  제목   |    내용     |  작성자   | 작성일자 ");
        
        List<BoardDB> list =service.getBoardList();
        for (BoardDB b : list) {
            System.out.println(b.getBoardNo() + " | " + b.getTitle() + " | " + b.getContent() 
                               + " | " + b.getWriter() + " | " + b.getCreationDate() );

        }
        System.out.println("==============================");

	}

	private void getBoard() {                            // 게시글 한개 조회하는 메소드
		System.out.println("조회할 글 번호를 입력해주세요.");
		int boardNo = sc.nextInt();sc.nextLine();
		
		// 원본 글 조회하는 부분
		System.out.println("------[원본글]-------");
		BoardDB board = service.getBoard(boardNo);
		
		if (board != null) {
			System.out.println("제목: " + board.getTitle());
			System.out.println("내용: " + board.getContent());
			System.out.println("작성자: " + board.getWriter());
			System.out.println("작성일자: " + board.getCreationDate());
			
			// 댓글 조회하는 부분
			List<BoardDB> list = service.getReply(boardNo);
			if (list.size() > 0 ) {
				System.out.println("-------[댓글]------------------");
				for (BoardDB brd : list ) {
					System.out.println("->" + brd.getBoardNo() + "|"
											+ brd.getContent() + "|"
											+ brd.getCreationDate() + "|");
				}
				System.out.println("------------------------------");
			} else {                                       // 댓글이 하나도 없으면 출력
				System.out.println(" [댓글]이 없습니다.");
			}
			System.out.println("1.댓글작성 2.이전메뉴");
			int subMenu = 0;
			subMenu = sc.nextInt();sc.nextLine();
			if (subMenu == 1 ) {
				System.out.println("댓글 입력");
				String reply = sc.nextLine();
				
				BoardDB board1 = new BoardDB();
				board1.setContent(reply);
				board1.setOrigNo(board.getBoardNo());
				board1.setWriter(loginId);
				
				service.insertReply(board1);
			}
		}
		}

	private void updateBoard() {                             // 글 내용 수정하는 메소드
		System.out.println("변경할 글번호를 입력하세요.");
		int boardNo = sc.nextInt();sc.nextLine();
		System.out.println("제목 변경");
		String title = sc.nextLine();
		System.out.println("내용 변경");
		String content = sc.nextLine();
		
		BoardDB board = new BoardDB();
		board.setBoardNo(boardNo);
		board.setContent(content);
		board.setWriter(loginId);
	
		service.updateBoard(board);
	}
	
	private void deleteBoard() {         // 글번호 변경하는 메소드
		System.out.println("삭제할 글번호 입력");
		int boardNo = sc.nextInt();sc.nextLine();
		
		BoardDB board = new BoardDB();
		board.setOrigNo(boardNo);
		board.setWriter(loginId);
		
		service.deleteBoard(board);     // Ctrl 마우스클릭했을때 open implementation은 클래스로 이동
	}
	
	private void getReply() {                         // 댓글조회하는 메소드
		
	}
}
