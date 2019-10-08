package hellow;

import java.util.Scanner;

public class AccountExample {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------");
			System.out.println("1.계좌생성2.계좌목록3.예금4.출금5.종료");
			System.out.println("-----------------------------------");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				createAccount();
			} else if (menu == 2) {
				getAccountlist();
			} else if (menu == 3) {
				deposit();
			} else if (menu == 4) {
				withdraw();
			} else if (menu == 5) {
				run = false;
			}
		}
	}

	// 계좌인스턴스만드는 메소드
	public static void createAccount() {
		System.out.println("getAccount()");
		System.out.println("계좌번호 입력: ");
		String accountNo = sc.nextLine();
		System.out.println("사용자명 입력");
		String accountName = sc.nextLine();
		System.out.println("첫 계좌금액");
		int accountBalance = sc.nextInt();
		Account accnt = new Account(accountNo, accountName, accountBalance);
		for (int i=0; i<accountArray.length; i++) {
			while (accountArray[i] == null) {
				accountArray[i] = accnt;
				break;
			}
		}
	}

	// 계좌리스트 조회하는 메소드
	public static void getAccountlist() {
		System.out.println("getAccounlist()");
		for (Account a : accountArray) {
			if (a != null)
				System.out.println("계좌번호" + a.getAno() + ", 소유자: " + a.getOwner());
		}
	}

	// 입금하는 메소드
	public static void deposit() {
		System.out.println("deposit()");
		System.out.println("계좌번호 입력: ");
		String accntNo = sc.nextLine();
		System.out.println("입금액: ");
		int accntBalance = sc.nextInt();
		for (Account accnt : accountArray) {
			if(accnt != null && accnt.getAno().equals(accntNo)) {
				accnt.setBalance(accntBalance);
			}
		}
	}
	// 출금하는 메소드
	public static void withdraw() {
	}
	public static Account findAccount(String ano) {
		return null;
	}

}
