package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Board;

public class BoardDAO {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test?serverTimezone=UTC" , "root","1234");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패");
		}
	}
	
	public static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}

	//1.등록 생성자
	public boolean boardwrite(Board board) {
		String sql = "insert into board(b_title, b_contents) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getB_title());
			ps.setString(2, board.getB_contents());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//2. 출력 생성자
	public ArrayList<Board> boardlist (){
		ArrayList<Board> boards = new ArrayList<Board>();
		String sql = "select * from board order by b_num desc";
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getString(4), 
								rs.getInt(5));
				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Board boardcontents(int b_num) {
		String sql = "select * from board where b_num=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_num);
			rs=ps.executeQuery();
			if(rs.next()) {
				Board board = new Board(rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getString(4), 
								rs.getInt(5));
				return board;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean boarddelete(int b_num) {
		String sql = "delete from board where b_num=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_num); 
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean boardupdate(Board board) {
		String sql = "update board set b_title =?, b_contents=? where b_num=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getB_title());
			ps.setString(2, board.getB_contents());
			ps.setInt(3, board.getB_num());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
