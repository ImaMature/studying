package 시간체크;

import java.util.HashSet;
import java.util.Scanner;

public class 로또 {

	//	* 로또 프로그램
	//	1. 6개 입력받아 set 컬렉션에 저장하여 출력 
	//	[조건] 중복값 허용 X
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> a = new HashSet<>(); //set을 왜 Hashset으로??????
		while(true) {
			System.out.println("수 입력"); int ch = sc.nextInt();
			if(ch>45 || ch<1) {
				System.out.println("잘못된 수");
			}else {
				
					a.add(ch);
					if(a.size()==6) {
						System.out.println(a);
						break;
					}
			
			}
		}
	}
}
