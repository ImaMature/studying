package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import controller.BoardController;
import controller.MemberController;
import model.Board;
import model.Member;

public class File {

	//필드
	private static String m_filepath = "C:/Users/JHD/git/studying/Studying/보드프로젝트/database/memberlist.txt";	// 멤버 리스트 경로 객체화
	private static String b_filepath = "C:/Users/JHD/git/studying/Studying/보드프로젝트/database/boardlist.txt";	// 게시판 리스트 경로 객체화
	private static String r_filepath = "C:/Users/JHD/git/studying/Studying/보드프로젝트/database/replylist.txt";	// 리플 리스트 경로 객체화
	//생성자
	
	//멤버, 게시판, 리플 정보를 파일 처리하는(쓰기) 메소드
	public static boolean txtsave(int type) {
		try {
			FileOutputStream fileOutputStream = null; //선언(파일, 게시판, 리플 셋의 파일명이 다르기 때문)
			//멤버 파일 처리
			if (type == 1) {
				//파일 경로 설정
				fileOutputStream = new FileOutputStream(m_filepath);
				//리스트에서 회원 정보 가져오기
				for(Member temp : MemberController.members) {
					String outStr = temp.getId()+","+temp.getPassword()+","+temp.getName()+","+temp.getEmail()+","+temp.getPoint()+"\n";
					//정보 내보내기(저장하기)
					fileOutputStream.write(outStr.getBytes());
				}
				//초기화 
				fileOutputStream.flush(); //파일 스트림내 존재하는 바이트를 제거
				fileOutputStream.close(); //파일 스트림 닫기
				return true;	//true 반환
				
			//게시판 파일 처리	
			}if (type == 2) {
				fileOutputStream = new FileOutputStream(b_filepath);
				for(Board temp : BoardController.boards) {
					String b_outStr = 	temp.getTitle()+","+temp.getContents()+","+
										temp.getWriter()+","+temp.getDate()+","+
										temp.getView()+"\n";
					fileOutputStream.write(b_outStr.getBytes());
				}
				fileOutputStream.flush();
				fileOutputStream.close();
				
			}if (type == 3 ){
//				fileOutputStream = new FileOutputStream(r_filepath);
//				for(Board temp : BoardController.r) {
//					String b_outStr = 	temp.getTitle()+","+temp.getContents()+","+
//										temp.getWriter()+","+temp.getDate()+","+
//										temp.getView()+"\n";
//					fileOutputStream.write(b_outStr.getBytes());
//				}
//				fileOutputStream.flush();
//				fileOutputStream.close();
			}
		}catch (Exception e) {
			System.out.println("파일 저장하기 실패");
			e.getStackTrace();
		}
		return false;
	}
	
	//멤버, 게시판, 리플 정보를 파일 처리(불러오기)하는 메소드
	public static boolean txtload(int type) {
	
		try {
			FileInputStream fileInputStream = null;
			if(type == 1) {
				// inputStream 경로 설정
				fileInputStream = new FileInputStream(m_filepath);
				// 바이트 배열 선언
				byte [] arr = new byte[1024];
				//읽어와서 배열에 저장
				fileInputStream.read(arr);
				//바이트 배열 -> 문자열 전환
				String str = new String(arr);
				//분리하기
				String [] members = str.split("\n");
				
				for(String temp : members) {
					//필드로 다시 분리하기
					String [] members2 = temp.split(",");
					//공백 제거
					if(members2.length ==1) 
						break;
					
					//포인트가 int타입이라서 int로 형변환
					int point = Integer.parseInt(members2[4]);
					
					Member member = new Member(members2[0], members2[1], members2[2], members2[3], point);
					
					MemberController.members.add(member);
				}
				fileInputStream.close(); // 스트림 닫기 
				System.out.println("회원 파일 불러오기 성공");
				return true; // 파일 불러오기 성공
			
			}if (type == 2) {
				fileInputStream = new FileInputStream(b_filepath);
				byte [] arr = new byte[10000];
				fileInputStream.read(arr);
				String inStr = new String(arr);
				String [] b_arr = inStr.split("\n");
				
				for(String temp : b_arr) {
					
					String [] b_arr2 = temp.split(",");
					
					//공백(마지막 인덱스)이 있으면 멈춤
					if(b_arr2.length==1) {
						break;
					}
					Board board = new Board(b_arr2[0], b_arr2[1], b_arr2[2], b_arr2[3], Integer.parseInt(b_arr2[4]));
					BoardController.boards.add(board);
				}
				fileInputStream.close();
				System.out.println("게시판 파일 불러오기 성공");
				
			}if (type == 3 ){
				
			}
		} catch (Exception e) {
			System.out.println("파일 불러오기 실패");
			System.out.println(e);
		}
		return false;
	}
}
