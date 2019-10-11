package com.board.control;

import java.util.Scanner;

import com.board.impi.BoardDBServiceImpl;
import com.board.model.BoardDB;
import com.board.model.BoardDBService;

public class BoardDBProc {
	Scanner sc = new Scanner(System.in);
	BoardDBService service = new BoardDBServiceImpl();
	String loginId = null;

	public void execute() {
		loginCheck();
		while (true) {
			System.out.println("1.게시글작성|2.게시글리스트|9.종료");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				createBoard();
			} else if (menu == 2) {
				checkBoardList();
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
		service.insertBoard(das);   // 실행한 값을 갖고 와서 여기서 적용시키는 구문
	}

	private void checkBoardList() {

	}

}
