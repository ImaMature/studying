package Day13;

import java.util.Random;
import java.util.Scanner;


public class 뭐먹을까 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //입력객체 선언
		/*식당

		무슨 음식을 먹을건지 1. 김밥 2. 튀김
		
		1 ⇒ 재료 준비, 3초뒤 준비완료→ 김밥 말기 →완성

		
		2 ⇒  재료준비, 3초뒤 준비완료 → 튀김기에 넣기 → 완성
		
		 	*/
		
		boolean 김밥주문 = false;
		boolean 재료준비 = false;	
		boolean 튀김주문 = false;
			System.out.println("분식집에 왔습니다. 메뉴를 골라주세요.");
			System.out.println("1.김밥 | 2.튀김");
			int ch = scanner.nextInt();
			if(ch == 1 ) {
				System.out.println("김밥을 고르셨습니다.");
				System.out.println("몇 줄을 사시겠습니까?"); int 김밥선택 = scanner.nextInt();
				
				System.out.println("김밥 "+김밥선택+"줄 주문완료!!");
				김밥주문 = true; 
				
				
				Runnable runnable = new Runnable() {//Runnable로 따로 클래스 안 만들고 즉시 쓰레드 시작
					@Override
					public void run() {
						String loading [] = new String[]{"잠시 전화와서 받는 중", "원산지 확인하는 중", "재료 준비 중"};
						Random r = new Random(); //String배열의 내용을 랜덤하게 출력
						for(int i =0; i<3; i++) {
							int runm = r.nextInt(loading.length);
							System.out.println(loading[runm]); //out of bound (nextInt 값 넣어주기)
							try {
								Thread.sleep(2000); //2초마다 loading 배열 안 문구가 랜덤으로 출력
							} catch (Exception e) {
								e.getMessage();
							}
						}
						System.out.println("재료 준비 완료");
					}
				};
				
				if(김밥주문) {
					Thread thread = new Thread(runnable);
					thread.start();// runnable 스레드 실행
					
					try {
						thread.join(); // join을 써야 runnable부터 시작하고 그뒤에 thread2가 시작한다.
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					재료준비 = true;
					김밥주문 = false;
				}
				if(재료준비) {
					Thread thread2 = new Gimbap(김밥선택);
					thread2.start();
					재료준비 = false;
					
				}else {
					System.out.println("주방이 혼잡합니다.");
				}
			}else if (ch==2) {
				System.out.println("튀김을 고르셨습니다.");
				System.out.println("몇개를 사시겠습니까?"); int 튀김선택 = scanner.nextInt();
				System.out.println("튀김 " + 튀김선택 + "개 주문완료!!");
				튀김주문 = true;
				
				Runnable runnable2 = new Runnable() {
					
					@Override
					public void run() {
						String loading2 [] = new String[] {"새로운 기름으로 바꾸는 중", "반죽 준비하는 중", "기름 온도 체크 중"};
						Random r = new Random();
						for(int i =0; i<3; i++) {
							int rnum = r.nextInt(loading2.length);
							System.out.println(loading2[rnum]);
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				};
				
				if(튀김주문) {
				Thread thread3 = new Thread(runnable2);
				thread3.start();
				
					try {
						thread3.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("튀김 준비 완료");
					튀김주문 = false;
					재료준비 = true;
				}
				
				if(튀김주문 == false && 재료준비==true) {
					Thread thread4 = new Fry(튀김선택);
					thread4.start();
				}else {
					System.out.println("주방이 혼잡합니다.");
				}
			}else {
				System.out.println("잘못된 주문입니다.");
			}

	}
}
