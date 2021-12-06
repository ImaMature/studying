package 검색;

import java.util.Scanner;

//선형 검색 (보초법)
class SeqSearchsen {

	static int seqSearchSen(int [] a, int n, int key) {
		int i = 0;
	
		a[n] = key; //  [요솟수]번째 인덱스에 검색할 값 저장 (보초)
		while(true) {
			if(a[i] == key)
				break; //해당 값이 나오면 while문 탈출 아니면 인덱스 증가
			i++;
		}
		return i == n ? -1 : i; //i값이 요솟수와 같다면, 보초라서 i=-1 반환
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("요솟수 :");
		int num  = stdIn.nextInt();
		int[] x = new int[num+1]; //입력받은 요솟수 num+1
		
		for(int i= 0; i<num; i++) { //입력받은 수의 미만만큼 반복문 실행
			System.out.println("x[" + i + "]: "); 
			x[i] = stdIn.nextInt(); //0~(입력받은 수 -1)번째 인덱스까지 입력받아서 배열에 저장
		}
		
		System.out.println("검색할 값");
		int ky = stdIn.nextInt();
		int idx = seqSearchSen(x, num, ky); 
		
		if(idx==-1) { //입력받은 값이 없으면(0이면)
			System.out.println("그 값의 요소가 없습니다."); //출력
		}else {//입력받은 값이 있으면
			System.out.println(+ky+"은(는) x["+idx+"]에 있습니다.");
			//return i값이 출력
		}
	}
}
