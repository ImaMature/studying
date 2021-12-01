package Day13;

public class 시간재기_movie extends Thread{

	public static boolean moviestop;
	
	public static void moviestop(boolean moviestop2) {
		
		moviestop= moviestop2;
		if(moviestop) {
			System.out.println("영화 상영 시작");
		}else {
			System.out.println("영화 상영 종료");
		}
	}
	@Override
	public void run() {
		while(moviestop) {
			try {
				System.out.println("영화기 상영 중입니다.");
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
