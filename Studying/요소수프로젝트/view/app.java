package view;

import java.util.Scanner;

public class app {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
			sc = new Scanner(System.in);
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 프로그램 종료");
			int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("아이디 : "); 	 String id = sc.next();
				System.out.println("비밀번호 : "); String pw = sc.next();
				System.out.println("이름 : ");	 String name = sc.next();
				System.out.println("전화번호 : ");	 String phone = sc.next();
				
			}
		}
	}
}
