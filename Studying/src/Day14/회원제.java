package Day14;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class 회원제 {

	public static void main(String[] args) {
		// 리스트를 이용한 회원가입, 로그인, 회원수정, 회원탈퇴
		// 입력 객체
		// 리스트 생성
		// 파일 읽어오기 
		// 파일 출력하기
		// 1번 회원 가입 2번 로그인
		// 로그인 회원 정보 회원 수정 회원 탈퇴 로그아웃
		// user
		String a [] = new String [] {"a","b","c"};
		Random r = new Random();
		for(int i =0; i<10; i++) {
			int r2 = r.nextInt(3);
			System.out.println(a[r2]);
		}
	}
}
