package 회원제리스트;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;

	//빈 생성자
	public Member() {}
	
	
	//회원 가입하는 생성자
	public Member(String id, String pw, String name, String phone) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}
	
	//로그인 하는 생성자
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
