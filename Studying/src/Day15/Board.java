package Day15;

public class Board {

	//필드
	String subject;
	String content;
	String writer;
	
	//생성자
	public Board(String subject, String content, String writer) {
		
		//this 자신을 참조하는 참조변수
		//this는 참조값이기 때문에 객체가 생성되기 전에는 사용할 수 없다.
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}

}
