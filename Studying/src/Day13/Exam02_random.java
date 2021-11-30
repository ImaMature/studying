package Day13;

import java.util.ArrayList;
import java.util.Random;

public class Exam02_random extends Thread{
	
	public int rangenum; // 난수 범위
	public int countnum; // 출력할 난수 개수
	
	public Exam02_random(int num, int num2) {
		rangenum =num;
		countnum = num2;
		
	}
	

	@Override
	public void run() {
		// rangenum 범위의 난수를 countnum의 수 만큼 2초마다 출력
		int arr [] = new int[countnum];
		Random random = new Random();
		int randnum = random.nextInt(rangenum)+1;
		for(int i = 0; i<arr.length; i++) {
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		ArrayList<Integer> number = new ArrayList<Integer>();
//		for(int i =1; i<=rangenum; i++) {
//			number.add(i);
//		}
//		System.out.println(number.toString());
		
		
	}
}
