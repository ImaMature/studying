package Day15;

import java.util.ArrayList;
import java.util.Scanner;

public class 문제1_대기명단프로그램 {

//	문제1: list 컬렉션 
//	*대기명단 프로그램
//	[ 메뉴 ]
//		1. 명단 추가 ( 인원수를 입력받아 대기번호[인덱스] 반환 )
//		2. 명단 취소 ( 대기번호 입력받아 명단 취소 )
//		[관리자] 
//		3. 명단 입장( 대기번호 1번부터 입장 없으면 없음 출력 )
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // 입력객체 선언
		ArrayList<Integer> people = new ArrayList<>(); // 명단 저장할 ArrayList선언
		
		//무한루프
		while(true) {
			//입력받기 전에 명단을 출력해야되기 때문에 미리 명단을 출력한다.
			for(int i=0; i<people.size(); i++) {
				System.out.println("대기 번호 " + (i+1)+"번, 현재 인원 수 : " + people.get(i) );
							//인덱스는 0번부터 시작해서 +1			//인덱스 i번째의 내용(입력받은 인원 수) 가져오기
			}
			
			System.out.println("1. 명단 추가 | 2. 명단 취소 | 3. 명단 입장");
			int ch = scanner.nextInt(); // 번호 입력받기
			if(ch == 1) {
				System.out.println("인원 수 입력 : "); int p_num = scanner.nextInt(); //인원 수 입력받기
				
				people.add(p_num); //입력 받은 수 리스트에 저장
				
				System.out.println("대기번호 : " + people.size());
				//ArrayList는 순차적으로 들어가고 나옴. 입력받으면 길이가 하나씩 늘어남.
				//그래서 people의 길이가 곧 대기번호가 된다.
				
			}else if(ch == 2) {
				System.out.println("취소할 번호 : "); int delete_num = scanner.nextInt();

				System.out.println(delete_num + "번 취소되었습니다.");
				
				people.remove(delete_num-1); 
				//인덱스는 0번부터 시작하기 때문에 -1을 해준다.
				
			}else if (ch == 3) {
				
				if(people.isEmpty()) {
					System.out.println("명단이 비었습니다.");
				}
				else {	
					people.remove(0); //대기번호는 1번부터 순서대로 줄어들기 때문에 0번째 인덱스를 지우면 된다.
					System.out.println("1번째 대기번호 입장");	
				}
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}	
	}
}
