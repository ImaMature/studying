package Day14;
import java.util.Scanner;



public class RamenProgram 
{



	public static void main(String[] args) 
	{
		int num;
		Scanner input = new Scanner(System.in);
		
		System.out.println("라면 몇 개 끓일까요?");
		
		num = input.nextInt();
		
		System.out.println(num + "개 주문 완료! 조리시작!");
		try
		{
			RamenCook ramenCook = new RamenCook(num);
			new Thread(ramenCook,"A").start();
			new Thread(ramenCook,"B").start();
			new Thread(ramenCook,"C").start();
			new Thread(ramenCook,"D").start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}



interface Runnable
{
	public void run();
}


class currentThread extends Thread
{
	public RamenCook ramenCook;
	static String nam;
	
	
	currentThread(RamenCook ramenCook , String nam)
	{
		this.ramenCook = ramenCook;
		currentThread.nam = nam;
	}
}



