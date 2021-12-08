package 시간체크;

import java.util.Scanner;
import java.util.Stack;


public class 문자열역순출력 {

	// 문제4 : 스택구조를 이용한 문자열 역순 출력 
				// [ 조건1] 스택구조
				// [ 조건2] 입력받은 문자열을 순서대로 스택에 저장 
					// Char // String 
				// [ 조건3 ] 문자열 반대로 출력 
				// [ 출력 예시 ]
					// 입력 : ABC 
					// 출력 : CBA 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Character> s = new Stack<>();
		
		System.out.println("문자열 입력 : "); String str = sc.next();
		
			for(int i =0; i<str.length(); i++) {
				s.push(str.charAt(i));
			}
			
			for(int i=0; i<str.length(); i++) {
				System.out.println(s.pop());
			}
		
	}
}
