package Day13;

public class Thread_Exam01 {

	public static void main(String[] args) {
		Thread thread = new Exam01();
		thread.start();
		
		//1~9까지 합계 구하기
		int sum = 0;
		for(int i =1; i<10; i++) {
			sum = sum+i;
			System.out.println(i+"번째 sum 합계 : " + sum);
		}
		System.out.println("=================================");
		System.out.println("sum의 최종 합계 값 : " + sum);
		try {
			Thread.sleep(500);
			System.out.println("0.5초 뒤 sum+sum2 : "+ (sum+Exam01.sum2));
			Thread.sleep(5500);
			System.out.println("5.5초 뒤 sum+sum2 : " + (sum+Exam01.sum2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
