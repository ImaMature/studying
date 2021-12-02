package Day13;

import java.util.Scanner;

public class Ramen_Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("라면 몇개 끓일까요?");
		int ramen = sc.nextInt();
		System.out.println("라면 "+ramen+"개 조리시작");
		
		try {
			Ramen ramen2 = new Ramen(ramen);
			new Thread(ramen2, "A").start();
			new Thread(ramen2, "B").start();
			new Thread(ramen2, "C").start();
			new Thread(ramen2, "D").start();
		}catch(Exception e) {
			
		}
	}
	
		interface  Runnable {
			public void run();
		}
		
		class currentThread extends Thread {
			static String name1;
			public Ramen ramen2;
			
			public currentThread(String name, Ramen ramen2) {
				
				this.name1 = name;
				this.ramen2 = ramen2;
			}
		}
	
}
