package Day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 문제3_지하철관제 {

//	문제3 :  지하철 관제 ( Queue )
//	[조건1] : 역 4개 ( 종점역 -> 용산 -> 서울 ->구로-> 종점역 )
//	[조건2] : 전철 3개 객체 [ 종점역에 3개 전철 대기 ]
//	[조건3] : 출발 신호를 받아서 해당역에서 출발해서 다음으로 도착 
//	[조건4] : 역 당 소요시간 2초
//
//	출발신호 메뉴 
//	1. 종점 2.용산 3.서울 4.구로 
//
//	[ 예시 ] 1번 선택시 종점역에 먼저 들어온 전철을 다음역으로 이동 
//	[ 예시 ] 만일 해당역에 전철이 없으면 없다 출력 
//
//	[출력 예 ]
//		----현 전철역  현황 -----
//		종점역 :  전철3 , 전철4
//		용산역 :  전철2
//		서울역 :  전철1 
//		구로역 :  
//		---------- 출발 신호 --------
//		1. 종점 2.용산 3.서울 4.구로 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력객체 선언
		
		//링크드 리스트(LinkedList)
		// 데이터의 크기가 정해져 있지 않고(단일스레드), 삽입 삭제가 많이 일어나며, 검색이 적은 경우 유리
		Queue<String> 종점역 = new LinkedList<>(); //큐를 선언할때는 LinkedList를 사용
		Queue<String> 용산역 = new LinkedList<>();
		Queue<String> 서울역 = new LinkedList<>();
		Queue<String> 구로역 = new LinkedList<>(); 
		
		종점역.offer("1번전철"); //큐에 값 넣기
		종점역.offer("2번전철");
		종점역.offer("3번전철");
		
		while(true) {
			System.out.println(종점역); //해당하는 리스트 출력 처음에는 비어있음
			System.out.println(용산역);
			System.out.println(서울역);
			System.out.println(구로역);
			System.out.println("1.종점역 2.용산역 3.서울역 4.구로역");
			int ch = sc.nextInt(); //입력받기
			
			//종점역
			if(ch == 1) {
				System.out.println("현재 종점역 상황 : " + 종점역); //해당하는 역 상태 출력
				
				if(!종점역.isEmpty()) {
					//종점역에 뭔가 있다면(비어있지 않다면)
					try {
						//2초 대기 (예외 발생)
						Thread.sleep(2000);
						
						// .peek() : 맨 첫번째 값 출력하기
						// !!주의!! 제거하지 않고 반환
						// Queue가 비어있으면 예외 발생
						System.out.println("출발 : " + 종점역.peek());
						
						// .poll() : queue에서 값 제거하기
						// 종점역의 첫번째 값 queue에서 제거한 뒤,
						// .offer()로 용산역에 넣기
						용산역.offer(종점역.poll());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//용산역
			else if(ch == 2) {
				System.out.println("현재 용산역 상황 : " + 용산역); //해당하는 역 상태 출력
				
				if(!용산역.isEmpty()) {
					//용산역이 비어있지 않다면
					try {
						//2초 대기 (예외 발생)
						Thread.sleep(2000);
						
						//용산역 맨 첫번째 값 출력하기
						System.out.println("출발 : " + 용산역.peek());
						
						// .poll() : queue에서 값 제거하기
						// 용산역의 첫번째 값 queue에서 제거한 뒤,
						// .offer()로 서울역에 넣기
						서울역.offer(용산역.poll());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//서울역
			else if(ch == 3) {
				System.out.println("현재 서울역 상황 : " + 서울역); //해당하는 역 상태 출력
				
				if(!서울역.isEmpty()) {
					//서울역에 뭔가 있다면(비어있지 않다면)
					try {
						//2초 대기 (예외 발생)
						Thread.sleep(2000);
						
						//서울역 맨 첫번째 값 출력하기
						System.out.println("출발 : " + 서울역.peek());
						
						// .poll() : queue에서 값 제거하기
						// 구로역 첫번째 값 queue에서 제거한 뒤,
						// .offer()로 서울역에 넣기
						구로역.offer(서울역.poll());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			//구로역
			else if(ch == 4) {
				System.out.println("현재 구로역 상황 : " + 구로역); //해당하는 역 상태 출력
				
				if(!구로역.isEmpty()) {
					//구로역에 뭔가 있다면(비어있지 않다면)
					try {
						//2초 대기 (예외 발생)
						Thread.sleep(2000);
						
						//구로역 맨 첫번째 값 출력하기
						System.out.println("출발 : " + 구로역.peek());
						
						// .poll() : queue에서 값 제거하기
						// 구로역의 첫번째 값 queue에서 제거한 뒤,
						// .offer()로 종점역에 넣기
						종점역.offer(구로역.poll());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else {
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
	}
}
