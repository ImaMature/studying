package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.MemberDTO;

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
	
	//1. 마지막 회원 번호 +1 반환 메소드
	public int getCustno() {
		String sql = "select max(custno) from member_tbl_02";
		
		try {
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1)+1; //마지막 회원번호 +1 반환
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//2. 회원등록하기
	public boolean join(MemberDTO memberDTO) {
		String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getCustno());
			preparedStatement.setString(2, memberDTO.getCustname());
			preparedStatement.setString(3, memberDTO.getPhone());
			preparedStatement.setString(4, memberDTO.getAddress());
			preparedStatement.setString(5, memberDTO.getJoindate());
			preparedStatement.setString(6, memberDTO.getGrade());
			preparedStatement.setString(7, memberDTO.getCity());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	//3. 회원 목록 조회
	public ArrayList <MemberDTO> getMemberList (){
		ArrayList<MemberDTO> memberDTOLists = new ArrayList<>();
		String sql = "select * from member_tbl_02";
		try {
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				MemberDTO dto = new MemberDTO(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7)
						);
				
				memberDTOLists.add(dto);
			}
			return memberDTOLists; //while문 종료 시 list 반환
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; //에러 발생 시 null 반환
		
	}
	
	//4. 회원 개별 조회
	public MemberDTO getMember(String custno) {
		String sql = "select * from member_tbl_02 where custno = "+custno;
		try {
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				MemberDTO dto = new MemberDTO(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7)
						);
				return dto;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	//5. 회원 정보 수정 [조건 : 회원번호]
	public boolean updateMember(MemberDTO memberDTO) {
		String sql = "update member_tbl_02 set custname = ?, phone =?, address =?, joindate=?, grade=?, city=? where custno = ?";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(7, memberDTO.getCustno());
			preparedStatement.setString(1, memberDTO.getCustname());
			preparedStatement.setString(2, memberDTO.getPhone());
			preparedStatement.setString(3, memberDTO.getAddress());
			preparedStatement.setString(4, memberDTO.getJoindate());
			preparedStatement.setString(5, memberDTO.getGrade());
			preparedStatement.setString(6, memberDTO.getCity());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	//6.매출조회 [조건 X, 그룹 O, join O]
	public ArrayList <MemberDTO> getMoneyList (){
		ArrayList<MemberDTO> list = new ArrayList<>();
		String sql = "select a.custno, a.custname, a.grade, sum(b.price) from member_tbl_02 a join money_tbl_02 b on a.custno = b.custno group by (a.custno, a.custname, a.grade) order by sum(b.price) desc";
		try {
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				MemberDTO dto = new MemberDTO();  //빈생성자 => 빈객체
					dto.setCustno(resultSet.getString(1));
					dto.setCustname(resultSet.getString(2));
					dto.setGrade(resultSet.getString(3));
					dto.setMoney(resultSet.getString(4));
					list.add(dto);
			}
			return list; //while문 종료 시 list 반환
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; //에러 발생 시 null 반환
		
	}
}
