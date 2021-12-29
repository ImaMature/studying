package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.Member;

public class MemberDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test1?serverTimezone=UTC", "root","1234");
			System.out.println("DB 연동 성공");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패");
		}
	}
	
	public static MemberDAO memberDAO = new MemberDAO();
	
	public static MemberDAO getMemberDAO() {
		return memberDAO;
	}
	
	//1. 회원가입 메소드
	public boolean signup(Member member) {
		String sql = "insert into member (m_id, m_password, m_name, m_email, m_address, m_phone) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getM_id());
			ps.setString(2, member.getM_password());
			ps.setString(3, member.getM_name());
			ps.setString(4, member.getM_email());
			ps.setString(5, member.getM_address());
			ps.setString(6, member.getM_phone());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
 	}
	//2. 로그인 메소드
	public boolean login(Member member) {
		String sql = "select * from member where m_id=? and m_password=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getM_id());
			ps.setString(2, member.getM_password());
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//3. 아이디 중복 체크
	public boolean idcheck(String userid) {
		
		String sql = "select m_id from member where m_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
				//아이디가 존재함
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false; //아이디 존재X
	}

}
