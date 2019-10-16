package com.yedam.collections.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Fruits {
	String name;
	int price;
	
	public Fruits(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
}

class ComparatorClass implements Comparator<Fruits> {
	@Override
	public int compare(Fruits O1, Fruits O2) {
		if(O1.price < O2.price)
			return 1;
		else if (O1.price == O2.price)
			return 0;
		else 
			return -1;
	}
}

public class ComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruits> tset = new TreeSet<>(new ComparatorClass());  // 컬렉션 set인 Fruit타입인 변수 tset에
		                                                              // ComparatorClass를 담는 tset 객체 생성 
		tset.add(new Fruits("aaa", 3000));
		tset.add(new Fruits("bbb", 2000));
		tset.add(new Fruits("ccc", 4000));
		tset.add(new Fruits("ddd", 5000));
		
		
		Iterator<Fruits> iter = tset.iterator();
		while (iter.hasNext()) {                 // Iterator에 속한 hasNext()는 다음 값이 있는지 확인하는 메소드- 확인만 함
			Fruits p = iter.next();              // person타입인 p에 다음값을 넣는 next()를 p에 대입 - 값을 대입함
			System.out.println(p.name + ", " + p.price);
		}
	}
}
