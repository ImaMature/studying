package 시간체크;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 지하철관제 {

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
		 Scanner sc = new Scanner(System.in);
		 Queue<String> 종점 = new LinkedList<String>();
		 Queue<String> 용산 = new LinkedList<String>();
		 Queue<String> 서울 = new LinkedList<String>();
		 Queue<String> 구로 = new LinkedList<String>();
		 
		 종점.offer("1번전철");
		 종점.offer("2번전철");
		 종점.offer("3번전철");
		 
		 while(true) {
			 System.out.println(종점);
			 System.out.println(용산);
			 System.out.println(서울);
			 System.out.println(구로);
			 System.out.println("1.종점 2.용산 3.서울 4.구로");
			 int ch = sc.nextInt();
			 if(ch ==1) {
				if(!종점.isEmpty()) {
					System.out.println("종점역 출발");
					try {
						용산.offer(종점.peek());
						Thread.sleep(2000);
						종점.poll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 }else if(ch ==2) {
				 if(!종점.isEmpty()) {
					 System.out.println("용산 출발");
						try {
							서울.offer(용산.peek());
							Thread.sleep(2000);
							용산.poll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }
			 }else if(ch ==3) {
				 if(!종점.isEmpty()) {
					 System.out.println("서울 출발");
						try {
							구로.offer(서울.peek());
							Thread.sleep(2000);
							서울.poll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }
			 }else if(ch ==4) {
				 if(!종점.isEmpty()) {
					 System.out.println("구로 출발");
						try {
							종점.offer(구로.peek());
							Thread.sleep(2000);
							구로.poll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }
			 }
		 }
	}
}
