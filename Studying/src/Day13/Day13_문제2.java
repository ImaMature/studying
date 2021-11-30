package Day13;

import java.util.Scanner;

public class Day13_문제2 {


	/*
	 * 1. 음악재생
	 * 2. 영화재생
	 * [조건1] 1번 선택시 1초 간격으로 음악재생 출력
	 * [조건2] 2번 선택시 1초 간격으로 영화재생 출력
	 * [조건3] 음악, 영화가 실행 중 번호를 다시 선택하면 재생 종료 [스레드 종료]
	 */
		
	public static void main(String[] args) {
			
		boolean stopmusic = true; 	//음악 재생 여부 확인 변수
										//한번 더 1번 누르면 boolean stopmusic = false가 나옵니다.
			
		boolean stopmovie = true; 	//영화 재생 여부 확인 변수
										//한번 더 2번 누르면 boolean stopmovie = false;
			
		while(true) {
			Scanner sc = new Scanner(System.in); //입력객체 선언
			System.out.println("1.음악| 2.영화");
			int ch = sc.nextInt();				//선택하는 객체 선언
			if(ch==1) {							//1번 선택시
			Thread thread = new Music();	//Music클래스의 스레드 선언
			if(stopmusic) {					//stopmusic = true이므로 if문 실행
				Music.musicStop(stopmusic);		
				//1. Music클래스의 musicStop생성자에 인수(true or false) 전달??
				//2. Music클래스의 run메소드에 인수전달??
					//답 
					//둘 다 동시에 전달해서 "음악시작" && "음악재생중"이 동시에 콘솔에 출력됩니다.
					// 그 후에 "음악재생중"이라는 문구가 .sleep스레드로 인해서 1초동안 대기한 뒤에 콘솔에 출력됩니다.
				
				thread.start(); 			//stopmusic에 저장된 값이 true이면 스레드 시작
				stopmusic = false;			//true일때 run()메소드가 실행됐으니까 
											//false로 변경해서 한번 더 누르면 음악종료가 출력되도록
					
			}else {							
				Music.musicStop(stopmusic); 	//애초에 stopmusic에 저장된 값이 false 라면? -> false값 전달
												//생성자의 "음악 종료" 출력과 동시에 run()메소드에 false값이 전달되서 while문을 탈출합니다. 
				stopmusic = true;				//음악을 다시 실행할 때를 위해서 stop을 true로 변경
			}
				
			}else if (ch==2) {						//2번 선택시
				Thread thread = new Movie();		//Movie클래스의 스레드 선언
				if(stopmovie) {						//stopmovie가 true이면
					Movie.movieStop(stopmovie);		//stopmovie의 값 전달(Movie클래스의 run과 movieStop()메소드로)
													
					thread.start();					//스레드 시작
					stopmovie = false;
				}
				else {
					Movie.movieStop(stopmovie);
					stopmovie = true;
				}	
			}
		}
	}
}


