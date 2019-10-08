package hellow;

public class ForExample {
	public static void main(String[] args) {
		int a = 4 ;
		for(int t=1; t<=9; t++) {
		System.out.println(a+"*"+(t*2)+"="+(a*(t*2)));
		}
	}
}           
// 3*1=3
// ~~~
// 3*9=27

// a만 바꿔넣어주면 구구단 a단 출력가능
//  i = i +1;
// (a+"*"+i+"="+(a*i)