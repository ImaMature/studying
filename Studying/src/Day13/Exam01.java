package Day13;

public class Exam01 extends Thread {
	
	public static int sum2;
	
	@Override
	//1~10까지 합계구하기
	public void run() {
		sum2=0;
		for(int i=1; i<=10; i++) {
			sum2 = sum2+i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i+"번째 sum2 합계" +sum2);
		}
		System.out.println("================================");
		System.out.println("sum의 합계 최종 값 : " + sum2);
	}	
}
