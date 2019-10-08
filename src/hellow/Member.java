package hellow;

public class Member { // 필드
	private String name;
	private String id;
	private String passwd;
	private int age;

	Member() {
	} // 생성자

	Member(String name, String id) { // 생성자 2
		this.name = name;
		this.id = id;
	}

	Member(String name, String id, String passwd, int age) { // 생성자3
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
