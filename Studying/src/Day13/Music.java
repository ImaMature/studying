package Day13;

public class Music extends Thread{		//스레드 상속
	
	//필드
	static boolean stop = true;	// stop을 전역변수로 선언 
									//main클래스의 stop과 헷갈리지않게 stop로 선언
									//필드인가요??
	
	//생성자
	public static void musicStop(boolean stopmusic) { //stop을 매개변수로 받아오는 생성자 //setter 메소드에서 이름 바뀐것??
		stop = stopmusic;							//인수로 받아온 값(true or false)를 stop에 저장
		if(stop) {								//stop가 true면 음악시작 출력
			System.out.println("음악시작");
			
		}else {									//false면 음악종료 출력
			System.out.println("음악종료");
		}
	}



	//메소드
	@Override
	public void run() {
		while(stop) {		//필드 stop에서 전달받아온 값이 true이면 while문 실행 false면 실행 X
							
			System.out.println("음악재생중");
			try {
				Thread.sleep(1000);		//1초 동안 쉬기 (try catch 필수)
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
