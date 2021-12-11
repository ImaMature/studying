package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Board {

	//필드
	private String title;
	private String contents;
	private String writer;
	private String date;
	private int view;
	
	//댓글 리스트의 메모리 할당
	private ArrayList<Reply> replies;
	
	//생성자
	//빈 생성자
	public Board (){}
	
	//게시물 등록시 생성자
	public Board(String title, String contents, String writer) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		
		//date는 인수로 전달받는게 아니라 현재 시간을 표시하는 것이기 때문에 이렇게 사용
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		this.date = simpleDateFormat.format(date);
		//view도 인수 전달 받지 않고 함.
		this.view = 1;
		//???
		this.replies = new ArrayList<>();
	}
	
	//게시물 파일 처리 생성자
	public Board(String title, String contents, String writer, String date, int view) {
		super();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.replies = new ArrayList<>();
	}

	//메소드
	//get set
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public ArrayList<Reply> getReplies() {
		return replies;
	}

	public void setReplies(ArrayList<Reply> replies) {
		this.replies = replies;
	}
	
	
	
	
	
}
