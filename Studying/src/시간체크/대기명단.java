package 시간체크;

import java.util.ArrayList;
import java.util.Scanner;

public class 대기명단 {
	//5분
//	[ 메뉴 ]
//		1. 명단 추가 ( 인원수를 입력받아 대기번호[인덱스] 반환 )
//		2. 명단 취소 ( 대기번호 입력받아 명단 취소 )
//		[관리자] 
//		3. 명단 입장( 대기번호 1번부터 입장 없으면 없음 출력 )
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		while(true) {
			for(int i=0; i<a.size(); i++) {
				System.out.println("대기번호 "+(i+1) + "번, 현재 인원 수" + a.get(i) +"명");
			}
			System.out.println("1.명단추가 2.명단취소 3.명단입장"); int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("인원 수 : "); int p = sc.nextInt();
				a.add(p);
				
			}else if (ch==2) {
				System.out.println("취소할 번호");	int num = sc.nextInt();
				a.remove(num-1);
				System.out.println(num+"번 취소");
				
			}else if (ch==3) {
				System.out.println("1번입장");
				a.remove(0);
				
			}else {
				System.out.println("잘못입력");
			}
		}
	}	
}
