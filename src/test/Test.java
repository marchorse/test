package test;

import java.io.IOException;
import java.lang.Math;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int a = -1;
		int b = -1;
		System.out.println(a%1);
		while(true) {
			a = System.in.read();
			b = System.in.read();
			if (b == 0) break;
			System.out.println(a);
			System.out.println(b);
			System.out.println("a/b="+a/b);
			System.out.println("a%b="+a%b);
		}
	}

}
