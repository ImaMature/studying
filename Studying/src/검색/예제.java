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

		
		public S_Data(String s_name, int s_num, int s_age, double s_height) {
			this.s_name = s_name;
			this.s_num = s_num;
			this.s_age = s_age;
			this.s_height = s_height;
		}
		
		public String toString() {
			return s_name + " " + s_num + " " + s_age + " " + s_height;
		}
		
		//키 비교 인터페이스
		public static final Comparator<S_Data> HEIGHT_ORDER = new HeightOrdercomparator(); 
		
		private static class HeightOrdercomparator implements Comparator<S_Data>{

			@Override
			public int compare(S_Data o1, S_Data o2) {
				return (o1.s_height>o2.s_height) ? 1:
						(o1.s_height < o2.s_height) ? -1 : 0;
		
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
		
			
			
			double i = Arrays.binarySearch(
					a,
					new S_Data("", 0, 0, s_height),
					S_Data.HEIGHT_ORDER
			);
			
			if(i<0.0) {
				System.out.println("해당하는 값이 없습니다.");
				
			}else {
				System.out.println("배열 ["+i+"]번째 에 있습니다.");
			}
			
		}
	}
}
