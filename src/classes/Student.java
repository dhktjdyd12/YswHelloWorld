package classes;

public class Student {
	/////////특징
	String name;
	String major;
	int studentNo;
	
	//////// 생성자
	public Student() {
			
	}
	
	Student(String name){
		this.name = name;
	}
	
	Student(String name, String major) {
		this.name = name;
		this.major = major;
	}
	//////// 기능(메소드)
	void study() {
		System.out.println("공부합니다");
	}



void goToSchool() {	
}
}
