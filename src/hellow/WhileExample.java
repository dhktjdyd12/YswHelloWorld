package hellow;

public class WhileExample {
	public static void main(String[] args) {
		int i =1;
		while (true) {
			System.out.println(i);
			if(i++ <= 5)
				continue;
			System.out.println(4 + "*" + i + "=" +(4*i));
			if(i == 9);
			 	break;
//			i++;
		}
	}
}
