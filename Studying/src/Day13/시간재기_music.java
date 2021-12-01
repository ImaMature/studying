package Day13;

public class 시간재기_music extends Thread{

	public static boolean musicstop;
	
	public static void stopmusic(boolean musicstop2) {
		musicstop= musicstop2;
		if(musicstop) {
			System.out.println("음악시작");
		}else {
			System.out.println("음악종료");
		}
	}
	
	@Override
	public void run() {
		while(musicstop) {
			System.out.println("음악 실행중");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
