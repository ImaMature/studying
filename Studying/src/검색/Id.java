package 검색;

//id를 부여하는 클래스
public class Id {
	
	private static int counter = 0; //아이디를 몇개 부여했는지 저장
	private int id;	//아이디
	
	//생성자
	public Id() {
		//id 1씩 증가
		id=++counter;
	}
	
	//아이디 값 반환하는 인스턴스 메소드
	public int getId() {
		return id;
	}
	
	//counter 반환 메소드
	public static int getCounter() {
		return counter;
	}
	
}
	
	
