package com.mycompany.ysw;

public class PersonExample {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("hong");
		p1.setAge(20);
		p1.setHeight(180.6);
		p1.setWeight(77.8);
		System.out.println("이름은:" + p1.getName());
		System.out.println("나이는:" + p1.getAge());
		System.out.println("키는:" + p1.getHeight());
		System.out.println("뭄무게는:" + p1.getWeight());
		}
}
