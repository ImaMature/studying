package 검색;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;



public class 예제 {

	//학생부
	static class S_Data{
		private String s_name; 	//이름
		private int s_num;		//번호
		private int s_age; 		//나이
		private double s_height; //키
		
		//제일키큰 사람, 제일 번호가 낮은 사람 찾기
		//1번 키큰 사람
		//2번 나이 많은사람
		//3번 번호 제일 큰 사람
		
		public S_Data(String s_name, int s_num, int s_age, double s_height) {
			this.s_name = s_name;
			this.s_num = s_num;
			this.s_age = s_age;
			this.s_height = s_height;
		}
		
		public String toString() {
			return s_name + " " + s_num + " " + s_age + " " + s_height;
		}
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			S_Data [] a = {	new S_Data("홍길동", 1, 25, 167.2),
							new S_Data("김길수", 2, 35, 182.9),
							new S_Data("박정태", 3, 40, 178.3),
							new S_Data("오호수", 4, 18, 169.0),
							new S_Data("안영권", 5, 22, 166.1),
							new S_Data("신기루", 6, 23, 178.7),
							new S_Data("한길만", 7, 24, 162.4),
			};
			
			
			String [] s = a.toString().split("\n");	

			System.out.println(Arrays.toString(s));

			
			for(int i =0; i<a.length; i++) {
					
			}
			

			System.out.println("1. 가장 키가 큰 사람 2. 가장 키가 작은 사람");
			int ch = sc.nextInt();
			if(ch==1) {
				
			}else if (ch==2) {
			
			}else {
				System.out.println("잘못된 입력");
			}
			
			
			
		}
	}
}
