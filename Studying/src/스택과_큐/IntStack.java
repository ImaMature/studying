package 스택과_큐;

import java.util.Scanner;



//int형 스택
public class IntStack {
	private int max;	//스택 용량
	private int ptr;	//스택 포인터
	private int [] stk;	//스택 본체
	
	//실행 시 예외 : 스택이 비어 있음
	public class EmptyInStackException extends RuntimeException{
		public EmptyInStackException() {}
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}

	//생성자
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity; //최대용량
		try {
			stk = new int[max];		//스택 본체용 배열 생성
		} catch (OutOfMemoryError e) {	//생성 못할 때
			max=0;
		}
	}
	
	// 스택에 x를 푸시  //인수 x
	public int push (int x) throws OverflowIntStackException{
		if (ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
		//포인터가 최대용량보다 크면 예외 처리 아니면 인수를 stk[ptr]에 저장하고 포인터 1올림 stk[ptr]값 반환
	}
	
	// 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)	
	public int pop() throws EmptyInStackException{
		if(ptr <= 0) 		//스택이 비어 있음
			throw new EmptyInStackException();
		return stk[--ptr];
		//포인터가 0보다 작거나 같으면 예외 처리 아니면 포인터를 -1하고 stk[ptr]값을 반환
	}
	
	// 스택에서 데이터를 피크(맨 위의 값 보기)
	public int peek() throws EmptyInStackException{
		if (ptr <= 0)
			throw new EmptyInStackException();
		return stk[ptr-1];
		// 포인터가 0 보다 작거나 같으면 예외처리 아니면 stk[ptr-1]번째 인덱스 값 반환
	}
	
	// 스택에서 인수 x를 찾아서 인덱스 값을 반환
	public int indexOf(int x) {
		for (int i = ptr -1; i >= 0; i--)
			if (stk[i]==x)
				return i; //값 있으면 i값 반환
		return -1;
		//인덱스 값이 없으면 -1반환
	}
	
	// 스택 비우기
	public void clear() {
		ptr = 0;
	}
	
	//스택 용량 반환
	public int capacity() {
		return max;
	}
	
	//스택에 쌓여있는 데이터 수를 반환
	public int size() {
		return ptr; //포인터 값 반환
	}
	
	//스택이 비어있는지 여부
	public boolean isEmpty() {
		return ptr <=0;
	}
	
	// 스택이 가득 찾는지 여부
	public boolean isFull() {
		return ptr >=max;
	}
	
	// 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력하기
	public void dump() {
		if(ptr <= 0)
			System.out.println("스택이 비어 있습니다.");
		else { // 포인터가 0보다 크다면
			for(int i=0; i<ptr; i++)
				System.out.println(stk[i] + " ");
				//0번째 인덱스부터 출력
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64); // 최대 64개를 푸시할 수 있는 스택
		
		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / "
												+ s.capacity());
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)isFull (6)isEmpty (7)indexOf (0)종료 : ");
			
			int menu = stdIn.nextInt();
			if( menu == 0) break; //0번 누르면 탈출
			
			int x; //x선언
			switch (menu) {
			
			//푸시
			case 1:
				System.out.println("데이터 : ");
				x = stdIn.nextInt(); //입력받은값 x에 저장
				try {
					s.push(x);	//푸쉬 집어넣기
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break; //한번에 하나만 실행되게 break;
				
			//팝
			case 2:
				try {
					x = s.pop();	//팝 꺼내기
					//스택 s에 pop 메소드 실행, 포인터를 -1하고 stk[ptr]값을 반환
				} catch (IntStack.EmptyInStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			//피크
			case 3:
				try {
					x = s.peek(); //맨 위의 값 보기
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyInStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			//덤프 : 스택 안 모든 데이터 표시(바닥에서 꼭대기 순)	
			case 4:
				s.dump();
				break;
				
			//가득찼는지 여부
			case 5:
				System.out.println("스택이 가득찼나요 ? " + s.isFull());
				break;
			
			//비어있는지 여부
			case 6:
				System.out.println("스택이 비어있나요 ? " + s.isEmpty());
				break;	
				
			//인덱스 값 검색	
			case 7:
				try {
				System.out.println("검색할 값 : ");
				x = stdIn.nextInt();
				int a = s.indexOf(x);
				System.out.println("해당 값은 " + a + "번째 인덱스에 존재합니다.");
				}catch (IntStack.EmptyInStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
			}
		}
	}
}
