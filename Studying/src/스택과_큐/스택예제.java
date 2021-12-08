package 스택과_큐;

import java.util.Scanner;

import 스택과_큐.IntStack.EmptyInStackException;
import 스택과_큐.IntStack.OverflowIntStackException;

public class 스택예제 {
	
	//꼬치
	 private int max; //꼬치 최대 용량
	 private int 재료;
	 private int [] 꼬치;
	 
	 public class EmptyInStackException extends RuntimeException{
			public EmptyInStackException() {}
		}
		
		public class OverflowIntStackException extends RuntimeException{
			public OverflowIntStackException() {}
		}
	 
	 public 스택예제(int 재료용량) {
			재료 = 0;
			max = 재료용량;
			try {
				꼬치 = new int[max];
			}catch (Exception e) {
				max=0;
			}
		}

	public int push (int x)throws OverflowIntStackException {
		 if (재료 >= max)
			 throw new OverflowIntStackException();
		 return 꼬치[재료++] = x;
		
	 }
	 
	 public int pop() throws EmptyInStackException{
			if(재료 <= 0) 		//스택이 비어 있음
				throw new EmptyInStackException();
			return 꼬치[--재료];
	 }
	 
	 public int peek() throws EmptyInStackException{
			if (재료 <= 0)
				throw new EmptyInStackException();
			return 꼬치[재료-1];
	 }
	 
	 public int indexOf(int x) {
			for (int i = 재료 -1; i >= 0; i--)
				if (꼬치[i]==x)
					return i; //값 있으면 i값 반환
			return -1;
			
	 }	
	 
	 public void clear() {
			재료 = 0;
	}
	 
	 public int 재료용량() {
			return max;
	}
	 
	 public boolean isFull() {
			return 재료 >=max;
	}
	 
	 public boolean isEmpty() {
			return 재료 <=0;
	}
	 public void dump() {
			if(재료 <= 0)
				System.out.println("꼬치가 비어 있습니다.");
			else { // 포인터가 0보다 크다면
				for(int i=0; i<재료; i++)
					System.out.println(꼬치[i] + " ");
					//0번째 인덱스부터 출력
				System.out.println();
			}
		}
	 public int size() {
		 return 재료;
	 }
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		스택예제 temp = new 스택예제(12);
		
		while(true) {
			System.out.println("현재 꼬치에 끼워진 재료 수 : "+ temp.size() + " / " + temp.재료용량());
			System.out.println("1.재료끼우기 2.재료빼기 3.맨 위 재료 4.재료뭐있나 5.isfull 6. isempty");
			
			int ch = sc.nextInt();
			if( ch == 0) break;
			
			String x;
			switch(ch) {
			
			case 1:
				System.out.println("");
			}
		}
	}
}
