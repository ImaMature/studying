package Day14;
import java.util.Scanner;



public class RamenProgram 
{



	public static void main(String[] args) 
	{
		int num; //객체 선언
		Scanner input = new Scanner(System.in); //라면 개수 입력받기
		
		System.out.println("라면 몇 개 끓일까요?");
		
		num = input.nextInt(); //객체화
		
		System.out.println(num + "개 주문 완료! 조리시작!");
		try
		{
			RamenCook ramenCook = new RamenCook(num); 
			//입력 받은 num을 RamenCook클래스 생성자에 전달, 그후 ramenCook에 저장해서 객체화
			new Thread(ramenCook,"A").start(); //(라면갯수,"쓰레드이름") 라면갯수와 쓰레드 이름 지정하기. 쓰레드 시작 run실행
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
	public void run(); // RamenCook 클래스의 @override한 run과의 차이를 잘 모르겠습니다.
	//혹시 RamenCook 클래스에서 오버라이드를 해서 오버라이드한 그 run이 이 친구를 덮어쓰기 한건가요?>>
}


class currentThread extends Thread
{
	public RamenCook ramenCook; 
	static String nam; //전역변수로 외부클래스에서 사용가능
	
	
	currentThread(RamenCook ramenCook , String nam) //라면 개수와 쓰레드 이름 전달받는 생성자. 
	{												// 인스턴스화??
		this.ramenCook = ramenCook;
		currentThread.nam = nam;
	}
}



