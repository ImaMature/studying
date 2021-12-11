package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
	
	private String contents;
	private String writer;
	private String date;
	
	public Reply() {}

	public Reply(String contents, String writer) {
		super();
		this.contents = contents;
		this.writer = writer;
		
		//date는 인수로 전달받는게 아니라 현재 시간을 표시하는 것이기 때문에 이렇게 사용
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
		this.date = dateFormat.format(date);
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
	
	
}
