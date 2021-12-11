package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;



import database.File;
import model.Member;

public class MemberController {
	
	//리스트 선언 (모든 회원을 담고 있는 객체)
	public static ArrayList<Member> members = new ArrayList<>();
	
	
	//메소드
	
	//1. 로그인 메소드
	public static boolean login (String id, String pw) {
		
		for(Member temp : members) {
			if(id.equals(temp.getId()) && pw.equals(temp.getId())) {
				return true;
			}
		}
		return false;
	}
	
	//2. 회원가입 메소드 (유효성 검사 포함)
	public static boolean signup(Member member) {
		
		if(member.getId().length()>12 || member.getId().length()<4) {
			System.out.println("아이디의 길이는 4글자 이상 12글자 이하로 정해주십시오.");
			return false; //회원 가입 안되게 막기
		}
		if(member.getPassword().length()>12 || member.getPassword().length()<4) {
			System.out.println("비밀번호의 길이는 4글자 이상 12글자 이하로 정해주십시오.");
			return false; //회원 가입 안되게 막기
		}
		if(member.getName().length()<2) {
			System.out.println("이름의 길이는 2글자 이상으로 정해주십시오.");
			return false; //회원 가입 안되게 막기
		}
		if(!member.getEmail().contains("@")) {
			System.out.println("올바른 이메일 형식이 아닙니다.");
			return false; //회원 가입 안되게 막기
		}
		
		//아이디 중복체크
		for(Member temp : members) {
			if(member.getId().equals(temp.getId()) && member.getPassword().equals(temp.getId())) {
				System.out.println("중복된 아이디가 존재합니다.");
				return false;
			}
		}
		//회원 가입 성공시
		
		//포인트 100증가
		int pointup = member.getPoint() + 100;
		member.setPoint(pointup);
		
		//리스트 저장
		members.add(member);
		
		//파일 처리
		File.txtsave(1);
		
	
		
		//true값 반환 
		return true;
	}
	
	

	// 아이디 찾기 메소드
	public static String findid(String name, String email) {
		for(Member temp : members) {
			if(temp.getName().equals(name) && temp.getEmail().equals(email)) {
//				sendmail(temp.getEmail(), 1, "");
				return temp.getId();
			}
		}
		return null;
	}
	// 비밀번호 찾기 메소드
	public static String findpw(String id, String email) {
		for(Member temp : members) {
			if(temp.getId().equals(id) && temp.getEmail().equals(email)) {
//				sendmail(temp.getEmail(), 2, "");
				return temp.getPassword();
			}
		}
		
		return null;
	}
	
	//회원 정보
	public static Member m_info(String id) {
		
		for(Member temp : members) {
			if(temp.getId().equals(id)) {
				Member member = new Member(temp.getId(),"",temp.getName(),temp.getEmail(),temp.getPoint());
				return member;
			}
		}
		return null;
	}
	
	//이메일 전송
//	private static void sendmail(String tomail, int type, String contents) {
//		
//		String fromemail = "오류";
//		String frompassword = "오류";
//				
//		
//		Properties properties = new Properties(); // 설정 컬렉션 map 프레임워크
//		properties.put("mail.smtp.host", "smtp.gmail.com"); // host : 호스트 주소 
//		properties.put("mail.smtp.port" , 587 ); // port : 호스트의 접속하는 번호 
//		properties.put("mail.smtp.auth" , true ); // auth : 회원인증 
//		
//		
//		Session session = Session.getDefaultInstance( properties , new Authenticator() {
//			
//			// 익명 구현 객체 : 일회성 객체
//			@Override //패스워드 인증 메소드 
//			protected PasswordAuthentication getPasswordAuthentication() { 	
//				return new PasswordAuthentication(fromemail, frompassword);		
//			}									// 인증할 이메일 , 인증할 패스워드 
//		}); // 인증 끝
//		
//		try {
//			// 2. 메일 보내기 
//				// 1. 보내는사람의 인증정보 
//			MimeMessage message = new MimeMessage(session);
//				// 2. 보내는사람 메일주소 설정 
//			message.setFrom( new InternetAddress(fromemail) );
//				// 3. 받는 사람 메일주소 설정
//			message.addRecipient( Message.RecipientType.TO , new InternetAddress(tomail) );
//			
//			// * type 구분 
//			if( type == 1 ) {
//				// 4. 메일 제목 
//				message.setSubject("java console( forgot ID ) ");
//				// 5. 메일 내용
//				message.setText(" 회원님의 아이디 : " + contents );
//			}
//			if( type == 2 ) {
//				message.setSubject("java console( forgot Password ) ");
//				message.setText(" 회원님의 비밀번호 : " + contents );
//			}
//			if( type == 3 ) {
//				message.setSubject("java console( Member Signup ) ");
//				message.setText(" java console에 가입해주셔서 감사합니다 ~~ ");
//			}
//				// 6. 메일 전송 
//			Transport.send(message);
//			
//		}
//		catch (Exception e) {
//			System.err.println(" [알림] : 메일전송 실패 [ 관리자에게 문의 ]"+e);
//		}
	
}
