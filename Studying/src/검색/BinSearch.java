package 검색;

import java.util.Scanner;

public class BinSearch {
	
	//이진 검색
	//요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
	static int binSearch(int [] a, int n, int key) {
		int pl = 0;		//검색 범위의 첫 인덱스
		int pr = n-1;	// 검색 범위의 끝 인덱스
		
		do{
			int pc =(pl+pr)/2; //중앙 요소의 인덱스 //정수의 나눗셈은 버림을 한다.
			if(a[pc] == key) //중앙 요소가 key값이면 바로 내보내기
				return pc;
			
			else if (a[pc]<key) 
				pl = pc+1; // 검색 범위 뒤쪽 반으로 좁히기
			
			else
				pr=pc-1; // 검색 범위를 앞쪽 반을 좋비기
		}while (pl<=pr);
		//do while 문 : 무조건 중괄호 {} 블럭을 한번 실행하고, 조건을 검사하여 반복을 결정합니다.
		//while == false 면 탈출
		
		return -1;
	}
	

	
	
	//선형 검색의 시간 복잡도
	static int seqSearch3(int [] a, int n, int key) {
		int i = 0;		//검색 범위의 첫 인덱스
		while(i<n) {
			if(a[i] == key)
				return i; //검색 성공
			
			 i++; //a[i]!=key 일때
		}
		return -1; //검색 실패
	}
	
	//메인 start
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("요솟수 :");
		int num  = stdIn.nextInt();
		int[] x = new int[num]; //입력받은 요솟수 num+1
		
		System.out.println("오름차순으로 입력하세요."); //오름차순이라는 가정하
		
		System.out.println("x[0] :"); //첫 요소 입력
		x[0] = stdIn.nextInt();
		
		for(int i = 1; i<num; i++) {
			do {
				System.out.println("x[" + i + "]: "); 
				x[i] = stdIn.nextInt(); //0~(입력받은 수 -1)번째 인덱스까지 입력받아서 배열에 저장
			}while(x[i] < x[i-1]); //바로 앞의 요소보다 작으면 다시 입력하기
		}
		
		System.out.println("검색할 값 : ");
		int ky = stdIn.nextInt();
		
		int idx =binSearch(x, num, ky);
		int idx2 =binSearch(x, num, ky);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(+ky+"은(는) x["+idx+"]에 있습니다.");
		
		if(idx2 == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(+ky+"은(는) x["+idx+"]에 있습니다.");
	}
}
