package 검색;

import java.util.Scanner;


//선형검색 (while, for)
class SeqSearch{
	static int seqSearch(int[] a, int n, int key) {
		int i=0;
		
		while(true) {
			if(i==n) //i = n(num)일 때 즉 0==num일때
				return-1; //-1 반환
			if(a[i] == key) //배열 (int [] x)의 i번째 인덱스가 찾는 값이면
				return i; // i번째 인덱스 값 반환
			i++;//찾는 값이 아니면 i증가
		}
	}
						//int [] a = n번째 인덱스까지 입력받은 값들이 저장된 배열, n = 요솟수 ,key = 검색할 값
	static int seqSearch2(int []a, int n, int key) {
		for(int i =0; i<n; i++) 
			if(a[i] == key)
				return i;
			return-1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("요솟수 : ");
		int num  = stdIn.nextInt();
		int[] x = new int[num]; //입력받은 요솟수를 int 배열 x의 길이로 설정
		
		for(int i= 0; i<num; i++) { //입력받은 수의 미만만큼 반복문 실행
			System.out.println("x[" + i + "]: "); 
			x[i] = stdIn.nextInt(); //0~(입력받은 수 -1)번째 인덱스까지 입력받아서 배열에 저장
		}
		
		System.out.println("검색할 값 : ");
		int ky = stdIn.nextInt();
		int idx = seqSearch(x, num, ky); //(while문) 입력받은 수들이 있는 배열, 입력받은 요솟수, 찾으려는 값을 매개변수로 seqSearch메소드로 전달
		int idx2 = seqSearch2(x, num, ky);//for문
		//return i가 idx에 저장됨
		
		if(idx==-1) { //입력받은 값이 없으면(0이면)
			System.out.println("그 값의 요소가 없습니다."); //출력
		}else {//입력받은 값이 있으면
			System.out.println("while문 예제 : "+ky+"은(는) x["+idx+"]에 있습니다.");
			//return i값이 출력
		}
		
		if(idx2==-1) { //입력받은 값이 없으면(0이면)
			System.out.println("그 값의 요소가 없습니다."); //출력
		}else {//입력받은 값이 있으면
			System.out.println("for문 예제 : "+ky+"은(는) x["+idx+"]에 있습니다.");
			//return i값이 출력
		}
	}
}

