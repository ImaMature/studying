package 스택과_큐;

import java.util.Scanner;

//int 형 큐
public class IntQueue {

	private int max; 	//큐의 최대 용량 == 배열 que에 저장할 수 있는 최대 요소의 개수
	private int front; 	//첫번째 요소 커서 == 첫 번째 요소의 인덱스 저장하는 필드
	private int rear; 	//마지막 요소 커서 == 맨 나중에 넣은 요소의 하나 뒤의 인덱스를 저장하는 필드
	private int num; 	//현재 데이터 수 == 큐에 쌓아놓은 데이터 수
	private int [] que; //큐 본체
	
	public class EmptyException extends RuntimeException{
		public EmptyException() {}
	}
	
	public class OverflowException extends RuntimeException{
		public OverflowException() {}
	}
	
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];				//큐 본체용 배열 생성
			} catch (OutOfMemoryError e) {	//생성이 안된다면
			max = 0;
		}
	}
	
	//큐에 데이터를 인큐 (값 추가)
	public int enque(int x) throws OverflowException {
		if ( num >= max)
			throw new OverflowException();	//큐가 가득 찼을때
		//아니라면
		que[rear++] = x; 	// que[rear]번째 인덱스에 x값 저장하고 인덱스 1증가 
		num++;				// 데이터 수 증가
		if(rear == max) 	// 최대 용량과 마지막 요소가 같다면
			rear=0;			// 마지막 요소는 0
		//아니라면
		return x; 			// x반환
	}
	
	//데이터 디큐 (값 삭제)
	public int deque() throws EmptyException {
		if(num <= 0)
			throw new EmptyException(); 	//큐가 비었을때
		//아니라면
		int x = que[front++];				//que[front]번째 요소 x에 저장, 인덱스 1 증가
		num--;								//데이터 수 감소
		if(front == max) 					//최대값과 첫번째 요소가 같다면
			front = 0; 						// 0
		//아니라면
		return x;							//x 값(que[front]번째 요소) 반환
	}
	
	//맨 위 값(front) 보기
	public int peek() throws EmptyException{
		if(num <= 0)
			throw new EmptyException();	//큐가 비어있을때
		return que[front];
	}
	
	//값 검색하기(인덱스 반환) 이해 안감
	public int indexOf(int x) {
		for(int i =0; i< num; i++) { //현재 데이터 수만큼 반복
			int idx = (i + front) % max; // 이해 안감
			if(que[idx] == x) //검색 성공시
				return idx;
		}
		return -1;	//검색 실패시
	}
	
	//큐 비우기
	public void clear() {
		num = front = rear = 0;
		//커서들 초기화, 현재 데이터 수도 초기화
	}
	
	//큐의 용량 반환
	public int capacity() {
		return max;
	}
	
	//큐의 쌓인 데이터 수 반환
	public int size() {
		return num;
	}
	
	//큐가 비었는지
	public boolean isEmpty() {
		return num <= 0; //num(현재 데이터수)이 0보다 작거나 같은지 num(true, false) 반환
	}
	
	//큐가 가득 찼는지
	public boolean isFull() {
		return num >= max;	//num이 최대값 보다 크거나 같은지(true) 작은지(false) 반환 
	}
	
	public void dump() {
		if(num <= 0)
			System.out.println("큐가 비었습니다.");
		else {
			//System.out.println("front"+front); //front는 0이 나옴 첫번째 인덱스
			//System.out.println(max);				//max는 64 최대용량
			
			for(int i =0; i< num; i++)
				System.out.println(que[(i+front) % max] + " "); // % 몫0밑으로는 나머진
			System.out.println();
		}
	}
}
	
