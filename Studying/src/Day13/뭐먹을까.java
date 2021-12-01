package Day13;

import java.util.Random;
import java.util.Scanner;

public class 뭐먹을까 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //입력객체 선언
		
		boolean gimbap = false;
		boolean fry = false;
		while(true) {
			System.out.println("분식집에 왔습니다. 메뉴를 골라주세요.");
			System.out.println("1.김밥 | 2.튀김");
			int ch = scanner.nextInt();
			if(ch == 1 ) {
				System.out.println("김밥을 고르셨습니다.");
				System.out.println("몇 줄을 사시겠습니까?"); int ch2 = scanner.nextInt();
				
				System.out.println(ch2+"개 주문완료!");
				
				Runnable runnable = new Runnable() {//Runnable로 즉시 쓰레드 시작
					@Override
					public void run() {
						String loading [] = new String[]{"잠시 전화와서 받는 중", "원산지 확인하는 중", "재료 준비 중"};
						//Random r = new Random(); //String배열을 랜덤하게 출력하는 법을 모르겠습니다.
						for(int i =0; i<loading.length; i++) {
							System.out.println(loading[i]);
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				};
				
				Thread thread = new Thread(runnable);
				thread.start();
			}else if (ch==2) {
				System.out.println("튀김을 고르셨습니다.");
				fry = true;
			}
		}
		
	}
}
