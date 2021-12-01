package Day13;

import java.util.Scanner;

public class Day13_2_시간재기 {
//	문제2 무한루프 메뉴
//
//	1.음악재생
//	2.영화재생
//
//	[조건1] 1번 선택시 1초간격으로 음악재생 출력
//	[조건2] 2번 선택시 1초간격으로 영화재생 출력
//	[조건3] 음악,영화가 실행중 번호를 다시 선택하면 재생 종료 [스레드종료]
//	ex) 1번누르면 음악실행, 실행중 다시 1번누르면 종료.
//
//출력 예) 
//1 번 누르면? 
//음악재생
//음악재생
//   .
//   . 
	public static void main(String[] args) {
		
		boolean musicstop = true;
		boolean moviestop = true;
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.음악 | 2.영화");
			int ch = sc.nextInt();
			if(ch == 1) {
				Thread t = new 시간재기_music();
				if(musicstop) {
					시간재기_music.stopmusic(musicstop);
					t.start();
					musicstop = false;	
				}else {
					시간재기_music.stopmusic(musicstop);
					musicstop = true;
				}
			}else if(ch==2) {
				Thread t = new 시간재기_movie();
				if(moviestop) {
					시간재기_movie.moviestop(moviestop);
					t.start();
					moviestop = false;
				}else {
					시간재기_movie.moviestop(moviestop);
					moviestop = true;
				}
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
