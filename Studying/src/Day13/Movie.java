package Day13;

public class Movie extends Thread{//스레드 상속

	static boolean stop = true; //같은 이름의 객체인데 static으로 선언된다면(전역변수라면) 서로 다른 객체인가요???
	
	public static void movieStop(boolean stopmovie) {	//
		stop = stopmovie;	//전달 받은 인수 (true or false)를 전역변수 stop에 저장합니다.
		if(stop) {			//stop 객체 값이 true이면 if문 실행 아니면 else문을 실행합니다.
			System.out.println("영화시작");
		}else {
			System.out.println("영화종료");
		}
	}		

	@Override
	public void run() {
		while(stop) {	//필드 stop의 값이 true 이면 while문 실행, false이면 while문 탈출
			try {
				System.out.println("영화 상영 중");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
