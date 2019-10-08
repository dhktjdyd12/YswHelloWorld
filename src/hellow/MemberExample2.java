package hellow;

import java.util.Scanner;

public class MemberExample2 {
	private static Member[] memberArray = new Member[10];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.아이디 생성 | 2.전체리스트 조회 | 3.아이디와 비밀번호 조회 | 4. 종료");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택>");
			int sel2 = sc.nextInt();sc.nextLine();
			sc.nextLine();
			if (sel2 == 1) {
				create();
			} else if (sel2 == 2) {
				getlist();
			} else if (sel2 == 3) {
				idpassCheck();
			} else if (sel2 == 4) {
				run = false;
			}
		}
		System.out.println("프로그램 종료. ");                ////////////// 못한거
	}

	/////////////////////// 생성 메소드 만들기
	public static void create() {
		System.out.println("사용할 ID를 입력해주세요.");
		String createid = sc.nextLine();
		System.out.println("사용할 비밀번호를 입력해주세요.");
		String createpwd = sc.nextLine();
		System.out.println("사용자 이름를 입력해주세요.");
		String createname = sc.nextLine();
		System.out.println("나이를 입력해주세요.");
		int createage = sc.nextInt();
		Member member = new Member(createname, createid, createpwd, createage); // member클래스에 필드에 타입 메소드에 쓸 인스턴스를 새로 생성해주는 것
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] == null) {
				memberArray[i] = member;
				break;
			}
		}
	}

	/////////////////////// 전체 리스트 조회하는 메소드 만들기
	public static void getlist() {
		System.out.println();
		for (Member a : memberArray) {
			if (a != null) {
				System.out.println("아이디" + a.getId() + ", 이름" + a.getName());
			}
		}
	}

	/////////////////////// id,password 조회해주는 메소드 만들기
	public static void idpassCheck() {
		System.out.println("조회할 Id를 입력해주세요");
		String checkId = sc.nextLine();
		System.out.println("조회할 password를 입력해주세요");
		String checkPwd = sc.nextLine();
		boolean isId = false, isPw = false;
		String createname = null;
		int createage = 0;
		//////////////////////// id,passwd가 같으면 이름, 나이 출력
		//////////////////////// id가 맞고 passwd가 다를때
		//////////////////////// id랑 passwd 둘다 틀릴때

		for (Member b : memberArray) {
			if (b != null && b.getId().equals(checkId)) {
				if (b.getPasswd().equals(checkPwd)) {
//					isId = true;
//					isPw = true;
//					createname = b.getName();
//					createage = b.getAge();
					System.out.println("이름은:" + b.getName() + ", 나이는" + b.getAge());
				} else {
//					isId = true;
//					isPw = false;break;
					System.out.println("비밀번호가 틀립니다.");
				}
			} else {
//				isId = false;
//				isPw = false;
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
//		if(isId==true && isPw ==true)
//			System.out.println("이용은:" + createname + ", 나이는" + createage);
//		else if (isId == true && isPw == false)
//			System.out.println("비번이 틀립니다. ");
//		else if (isId == false && isPw == false)
//			System.out.println("존재하지 않는 아이디입니다.");
	}
}
