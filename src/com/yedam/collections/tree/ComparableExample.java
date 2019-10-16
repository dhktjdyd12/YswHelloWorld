package com.yedam.collections.tree;

import java.util.Iterator;
import java.util.TreeSet;

import com.mycompany.ysw.Person;

class person implements Comparable<person> {
	String name;
	int age;

	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(person o) {
		if (this.age > o.age)
			return 1;
		else if (this.age == o.age)
			return 0;
		else
			return -1;
	}
}

public class ComparableExample {
	public static void main(String[] args) {
		TreeSet<person> tSet = new TreeSet<>(); // 컬렉션 set인 tSet 생성
		tSet.add(new person("aaa", 30));        // 컬렉션에 각각의 요소를 대입하는 메소드 add()
		tSet.add(new person("bbb", 20));
		tSet.add(new person("ccc", 25));

		Iterator<person> iter = tSet.iterator(); // Iterator은 컬렉션에 있는 요소들을 불러오는 인터페이스 API이다. 
		                                         // Tset에 있는 요소들을 불러와서 iter라는 객체를 생성
		while (iter.hasNext()) {                 // Iterator에 속한 hasNext()는 다음 값이 있는지 확인하는 메소드- 확인만 함
			person p = iter.next();              // person타입인 p에 다음값을 넣는 next()를 p에 대입 - 값을 대입함
			System.out.println(p.name + ", " + p.age);
		}
	}
}
