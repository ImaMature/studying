package 재귀;

import java.util.Scanner;

public class 유클리드호제법 {

	//유클리드 호제법으로 최대공약수 구하기
	
	static int gcd(int x, int y) {
		if(y==0){
			return x;
		}
		else
			return gcd(y, x % y);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수의 최대 공약수를 구합니다.");
		
		System.out.println("정수1 입력 : ");	int x = sc.nextInt();
		System.out.println("정수2 입력 : ");	int y = sc.nextInt();
		
		System.out.println("최대 공약수는" + gcd(x, y) + "입니다.");
		System.out.println("최소 공배수는" + x*y/gcd(x, y));
		
		int a= 10;
		int b= 120;
		int c = a%b;
		System.out.println(c);
	}
}
