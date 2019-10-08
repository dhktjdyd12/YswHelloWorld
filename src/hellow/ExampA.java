package hellow;

public class ExampA {
	public static void main(String[] args) {
		char chr = 'A';
		int num = chr;
//		for (int i =0; i<26; i++)
//		System.out.println(chr++ +" ,"+ num++);
		
		//////배열 복사하는 법 ////
		String[] strAry = {"Hello", "World", "Good", "Morning"};  // String str을 의미
		String[] copyAry = new String[strAry.length];
		for (int i=0; i<strAry.length; i++) {
			copyAry[i] = strAry[i];
		}
		System.arraycopy(strAry, 0, copyAry ,0, strAry.length);
		for (String str : strAry) {            // for (int i=0; i<strAry.length; i++) 을 생략해서 사용하는 법
											   //for(변수타입 변수이름 : 배열이름)
//												{
//															내용;
//												}
			System.out.println(str);
		}
	}
}
