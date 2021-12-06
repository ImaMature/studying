package 스택과_큐;

import java.util.Scanner;

public class IntQueueTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue s = new IntQueue(64); // 최대 64개를 푸시할 수 있는 스택
		
		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / "
												+ s.capacity());
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)isFull (6)isEmpty (7)indexOf (0)종료 : ");
			
			int menu = stdIn.nextInt();
			if( menu == 0) break; //0번 누르면 탈출
			
			int x; //x선언
			switch (menu) {
			
			//인큐 : 값 집어넣기 앞에다
			case 1:
				System.out.println("데이터 : ");
				x = stdIn.nextInt(); //입력받은값 x에 저장
				try {
					s.enque(x);	
				} catch (IntQueue.OverflowException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break; //한번에 하나만 실행되게 break;
				
			//디큐 : 값 빼기 뒤에서
			case 2:
				try {
					x = s.deque();	
					System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch (IntQueue.EmptyException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
				
			//피크
			case 3:
				try {
					x = s.peek(); //맨 위의 값 보기
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntQueue.EmptyException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
				
			//덤프 : 큐 안 모든 데이터 표시(프런트에서 리어(앞에서 뒤에) 순)	
			case 4:
				s.dump();
				break;
				
			//가득찼는지 여부
			case 5:
				System.out.println("큐가 가득찼나요 ? " + s.isFull());
				break;
			
			//비어있는지 여부
			case 6:
				System.out.println("큐가 비어있나요 ? " + s.isEmpty());
				break;	
				
			//인덱스 값 검색	
			case 7:
				try {
				System.out.println("검색할 값 : ");
				x = stdIn.nextInt();
				int a = s.indexOf(x);
				System.out.println("해당 값은 " + a + "번째 인덱스에 존재합니다.");
				}catch (IntQueue.EmptyException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
			}
		}
	}
}
