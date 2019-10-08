package hellow;

import java.util.Scanner;

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member();
		m1.setName("유승우");
		m1.setId("YSW");
		m1.setPasswd("SSS123");
		m1.setAge(20);
		
		Member m2 = new Member("관리자", "admin");
				m2.setName("유승우");
				m2.setAge(20);

		Member m3 = new Member("사용자1", "user1", "user123", 20);
		Member[] memberAry = { m1 , m2 , m3 };
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 id 입력: ");
		String id = sc.nextLine();
		
		for (Member m : memberAry ) {              // memberAry에 
			if (m.getId().equals(id))
				System.out.println("==>" + m.getName() + ","+ m.getId() );
		}
	}
}
