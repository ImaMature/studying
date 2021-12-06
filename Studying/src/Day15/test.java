package Day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class test {
	
	public static void main(String[] args) {
		
		//리스트 인터페이스 선언. Board클래스의 생성자 참조
		//리스트에 들어갈 자료형(타입변수)은 Board 클래스
			//Vector는 멀티스레드를 쓸 때 사용, 동기화가 가능.
		
		/*하지만 ArrayList와 다른 점은,

			Vector는 동기화된 메소드로 구성되어 있어서 멀티 스레드가 동시에 이 메소드를 실행할 수 없고 
			
			하나의 스레드가 실행을 끝내야만 다른 스레드들이 실행을 할 수 있다.

			그렇기 때문에 멀티 스레드 환경에서 안전하게 객체를 추가하고 삭제할 수 있다.
		 
		 */
		
			//Board클래스의 필드가 어떻게 메모리 참조가 되는지 궁금합니다.
		List<Board> boards = new Vector<>();
			//List는 인터페이스이다. 클래스가 아니다.
			//Vector<>()를 참조하는 것이다.
			//Vector<>{}
		
		
		//리스트에 객체 넣기
		//메모리에 바로 집어넣는 방법
		//괄호 안의 요소들이 
		boards.add(new Board("제목1", "내용1", "글쓴이1"));
		
		//System.out.println(boards);
		
		//객체 생성해서 리스트에 집어넣기	//객체(메모리의 주소값)(힙영역) = new ~~ (메모리의 스택영역에 저장)
		Board board = new Board("제목2", "내용2", "글쓴이2");
		boards.add(board);
		//System.out.println(boards); //인덱스가 한 칸 더 늘어났다.	
		
		boards.add(new Board("제목3", "내용3", "글쓴이3"));
		boards.add(new Board("제목4", "내용4", "글쓴이4"));
		boards.add(new Board("제목5", "내용5", "글쓴이5"));
		
		//리스트의 2번째 인덱스의 내용을 지우고 뒤에서부터 한칸씩 당겨온다.
		boards.remove(2);
		//0번째는 [제목1,내용1,글쓴이1]
		//1번째는 [제목3,내용3,글쓴이3]
		//2번째는 [제목4,내용4,글쓴이4]
		//3번째는 [제목5,내용5,글쓴이5]
		
		//여기에서 3번째 인덱스를 지우면
		boards.remove(3);
		//0번째는 [제목1,내용1,글쓴이1]
		//1번째는 [제목3,내용3,글쓴이3]
		//2번째는 [제목4,내용4,글쓴이4]
		
		//주소값이 3개가 나온다.
		System.out.println(boards);
		
		
		//주소 값이 아니라 실제 값 출력하기
		//String으로 변환 불가
		//임시객체 t를 통해 리스트 boards의 길이만큼 리스트에 저장되어있는 Board클래스의 필드값 참조?? 
		for(Board t : boards) {
			System.out.println(t.subject);
				//필드에 바로 접근하는 녀석들
				//생성자와는 상관이 없다.
			System.out.println(t.content);
			System.out.println(t.writer);
	
		}
		//Vector는 멀티 스레드일때 사용.
		//ArrayList는 데이터의 크기가 정해져있고(단일스레드), 추가적인 삽입이나 삭제가 일어나지 않으며 검색할 때 유리하다.
		ArrayList<String> list1 = new ArrayList<>();
		//LinkedList는 데이터 크기가 정해져 있지 않고, 삽입 삭제가 빈번하며, 검색이 적을 때 유리하다.
		LinkedList<String> list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		//nanoTime() 
		//현재 시간(시스템 시간)과 관계가 X. 작동중인 JVM의 정밀한 시간 소스의 현재 값을 long타입으로 나노세컨드(1/1000000000초)를 반환하는 메소드.
		startTime = System.nanoTime();
		
		//ArrayList에 i를 0번 인덱스에다 1만번 삽입
		for(int i = 0; i<10000; i++ ) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("arraylist 10000개 삽입 시간 : " + (endTime-startTime) +" 나노 초");
		
		//LinkedList에 i를 0번 인덱스에다 1만번 삽입
		for(int i = 0; i<10000; i++ ) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("arraylist 10000개 삽입 시간 : " + (endTime-startTime) +" 나노 초");
		
		
		// ArrayList가 LinkedList보다 반복문을 실행하는데 10만~20만 나노초 정도 더 빨랐다.
	}
}
