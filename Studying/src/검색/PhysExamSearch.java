package 검색;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//자연정렬
//신체 검사 데이터 배열에서 이진 검색하기
public class PhysExamSearch{
	
	//신체 검사 데이터 정의
	static class PhyscData{
		private String name; 	//이름
		private int height; 	//키
		private double vision; 	//시력
		
		
		//생성자
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		//오름차순으로 정렬하기 위한 comparator
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrdercomparator(); 
			
		private static class HeightOrdercomparator implements Comparator<PhyscData>{

			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1:
						(d1.height < d2.height) ? -1 : 0;
				
				//d1 > d2 : 양의 값 반환
				//d1 < d2 : 음의 값 반환
				//d1 == d2 : 0 반환
			}
			
		}
		
		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);
			PhyscData[] x = {new PhyscData("이나령", 162, 0.3),
							new PhyscData("유지훈", 168, 0.4),
							new PhyscData("김한결", 169, 0.8),
							new PhyscData("홍준기", 171, 1.5),
							new PhyscData("전서현", 173, 0.7),
							new PhyscData("이호연", 174, 1.2),
							new PhyscData("이수민", 175, 2.0),
			};
			
			System.out.println("몇 cm인 사람을 찾나요? : ");
			int height = stdIn.nextInt();
			
			int idx = Arrays.binarySearch( // 배열의 요소가 어떤 순서로 줄지어있는지 
					x,									//배열 x에서 
					new PhyscData("", height, 0.0),		//키가 height인 요소를
					PhyscData.HEIGHT_ORDER				//HEIGHT_ORDER에 의해 검색
			);
			
			if (idx < 0){
				System.out.println("요소가 없습니다.");
			}else {
				System.out.println("x[" +idx+ "]에 있습니다.");
				System.out.println("찾은 데이터 : " + x[idx]);
			}
		}
	}
	
}
