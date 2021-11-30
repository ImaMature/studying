package Day13;

import java.util.Scanner;

public class Thread_Exam02 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			sc = new Scanner(System.in);
			//난수 범위 && 범위를 토대로 한 난수의 개수 입력받아서 2초마다 난수 출력
			//출력한 난수를 파일에 저장
			System.out.println("난수 범위를 입력해주세요. 예) 50 : 1~50까지의 난수"); int num = sc.nextInt();
			System.out.println("출력할 난수의 개수를 입력해주세요.");					int num2 = sc.nextInt(); 
			boolean a =true;
			while(a) {
				if(num>2147483647 || num<=0) { //int 만큼의 범위 제한
					System.out.println("다시 입력해 주세요");
					a= false;
				}
				else if ( num2<=0 || num2>50) {
					System.out.println("다시 입력해 주세요.");
					a=false;
				}
				else {
					Thread t = new Exam02_random(num, num2);
					t.start();
					
				}
				
				
			}
			
			
		}
	}
}
