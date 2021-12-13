package 재귀;

import java.util.Scanner;

public class Factorial {

	static int factorial(int n) {
		if(n>0)
			return n * factorial(n - 1);
		else {
			return 1;
		}
	}
	
	
	//x가 3이라면
	/*
	 * 3*factorial(2)
	 * == 3*2*factorial(1)
	 * == 3*2*1*factorial(0)
	 * == 3*2*1*1 == 6
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수르 입력하세요 : ");
		int x = sc.nextInt();
		
		System.out.println(x+"의 팩토리얼은" + factorial(x) + "입니다.");
	}
}
