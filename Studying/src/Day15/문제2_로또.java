package Day15;

import java.util.HashSet;
import java.util.Scanner;

public class 문제2_로또 {
//	* 로또 프로그램
//	1. 6개 입력받아 set 컬렉션에 저장하여 출력 
//	[조건] 중복값 허용 X
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> lotto = new HashSet<>(); //set을 왜 Hashset으로??????
		
		while(true) {
			System.out.println("수 입력 [1 ~ 45]: "); int num = sc.nextInt();
			// 1 ~ 45의 숫자를 입력
			
			// 범위 제한
			if(num > 45 || num < 1) {
				System.out.println("잘못된 수를 입력하셨습니다.");
			}
			// 중복체크
			else {
				if(lotto.contains(num)) {
				//set명.contains(객체명) : 해당 객체가 set에 존재하는지 여부 확인 (true, false)
					System.out.println("중복된 값입니다.");
				}else {
					//중복이 아니면 입력받은 값 저장 //set은 중복저장안된다던데 왜???
					lotto.add(num);
					//값 출력
					System.out.println("저장완료 : " + lotto);
					if(lotto.size()==6) {
						System.out.println("6개 입력 완료");
						break;//6개 입력하면 반복 탈출
					}
				}
			}
		}
	}
}
