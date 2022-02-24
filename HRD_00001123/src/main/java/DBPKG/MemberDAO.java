package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO { //1. DB 연동 클래스
	
	private PreparedStatement preparedStatement; // 2. sql 조작 인터페이스
	private Connection con;						 // 3. DB 연결 인터페이스
	private ResultSet resultSet;				 // 4. sql 결과 인터페이스
	
	//DB 클래스 생성자
	public MemberDAO() {
		try {
			con = getConnection();	// 아래에 있는 연결 메소드의 반환타입을 con에 저장 [연결 메소드에서 반환된 값과 예외처리가 딸려온다.]
			 						// 그래서 예외처리를 여기도 해줘야됨		
			//System.out.println("db연동 성공 확인");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
		
	//DB 클래스 생성자 다른 예외처리방법
	/*
	 * public MemberDAO() throws Exception {
	 * 
	 * con = getConnection(); }
	 */
	
	//DB 연결 메소드
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");	//DB 드라이브 연결 [ 무조건 예외가 발생해서 throws로 던지기 ]
		//특정 DB 연결하기
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
		return con; //연결된 인터페이스 반환하기
	}
}
