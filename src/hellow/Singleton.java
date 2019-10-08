package hellow;

public class Singleton {
	private static Singleton singleton = new Singleton();  // 정적필드  private static 클래스 singleton = new 클래스
	private Singleton() {}                     // 생성자        private 클래스() {
	static Singleton getInstance() {           // 정적 메소드   static 클래스 getInstance
		return singleton;
	}
}
