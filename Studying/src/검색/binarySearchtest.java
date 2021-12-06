package 검색;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearchtest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("요솟수 :");
		int num  = stdIn.nextInt();
		int[] x = new int[num]; //요솟수가 num인 배열 x
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.println("x[0] :"); //첫 요소 입력
		x[0] = stdIn.nextInt();
		
		for(int i = 1; i<num; i++) {
			do {
				System.out.println("x[" + i + "]: "); 
				x[i] = stdIn.nextInt(); //0~(입력받은 수 -1)번째 인덱스까지 입력받아서 배열에 저장 //인덱스는 0부터 시작하기 때문
			}while(x[i] < x[i-1]); //바로 앞의 요소보다 작으면 다시 입력하기
		}
		
		System.out.println("검색할 값");
		int ky = stdIn.nextInt(); //key값 입력받기
		
		int idx = Arrays.binarySearch(x, ky); //배열 x에서 키 값이 ky인 요소 검색 
		//Arrays.binarySearch 이진 검색
		//이진 검색 메소드를 코딩할 필요가 없다.
		//모든 자료형 배열에서 검색할 수 있다.
		//삽입 포인트는 검색하기 위해 지정한 key보다 큰 요소 중 첫 번째 요쇼의 인덱스.
		//검색에 실패 했을 때, 삽입 포인트가 x이면 -x-1을 반환한다.
		
		if(idx<0) { //입력받은 값이 0보다작으면
			System.out.println("그 값의 요소가 없습니다."); //출력
		}else {//입력받은 값이 있으면
			System.out.println(+ky+"은(는) x["+idx+"]에 있습니다.");
			//return i값이 출력
		}
	}
}
