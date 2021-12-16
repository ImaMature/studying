package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDAO {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/jsp?serverTimezone=UTC" , "root","1234");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패");
		}
	}
	
	public static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}

}
