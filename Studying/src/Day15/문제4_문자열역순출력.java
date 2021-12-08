package Day15;

import java.util.Scanner;
import java.util.Stack;

public class 문제4_문자열역순출력 {

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
		Stack<Character> b = new Stack<>(); 
		
		System.out.println("문자열 입력 : ");
		String a = sc.next();
		for(int i = 0; i<a.length(); i++) { //b.length가 안되는이유?? 인터페이스라서?? 배열이 아니라서??
			b.push(a.charAt(i));
			//.charAt(인덱스) : 문자열 내 i번째 인덱스의 문자를 추출하기
			//스택명.push : 문자 집어넣기
		}
		
		for(int i =0; i<a.length(); i++) {
			System.out.println(b.peek()); //abc입력시 a부터 들어감 그래서 c가 출력
			System.out.println(b.pop()); //맨 나중에 넣은거 부터 꺼내기
			//b.peek()출력하고 b.pop()출력하니 CCBBAA가 나옵니다 이유가 뭘까요????????
			//맨꼭대기 인덱스 출력하고 그 인덱스 출력하고 pop 반복
		}
	}
}
