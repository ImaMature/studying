package 회원제리스트;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Member2_Main {

	// 리스트를 이용한 회원가입, 로그인, 회원수정, 회원탈퇴
	// 입력 객체
	// 리스트 생성
	// 파일 읽어오기 
	// 파일 출력하기
	// 1번 회원 가입 2번 로그인
	// 로그인 회원 정보 회원 수정 회원 탈퇴 로그아웃
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member2> members =new ArrayList<>();
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\member2list.txt");
			byte a [] =new byte[1024];
			fileInputStream.read(a);
			String s = new String(a);
			String [] s2 = s.split("\n");
			for(String t: s2) {
				String [] s3 = t.split(",");
				if(s3.length==1)break;
				Member2 member2 = new Member2(s3[0], s3[1], s3[2]);
				members.add(member2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("1. 회원가입 2. 로그인");	int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("아이디"); String id = sc.next();
				System.out.println("비번"); String pw = sc.next();
				System.out.println("이름"); String name = sc.next();
				Member2 member2 = new Member2(id, pw, name);
				boolean idcheck= true;
				for(Member2 t : members) {
					if(t.getId().equals(id)) {
						System.out.println("중복");
						idcheck =false;
						break;
					}
				}
				if(idcheck) {
					members.add(member2);
					try {
						FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\member2list.txt", true);
						String s = member2.getId()+","+member2.getPw()+","+member2.getName()+"\n";
						fileOutputStream.write(s.getBytes());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}
				
			}else if (ch==2) {
				System.out.println("아이디"); String id = sc.next();
				System.out.println("비번"); String pw = sc.next();
				boolean login = false;
				for(Member2 t : members) {
					if(t.getId().equals(id) && t.getPw().equals(pw) ) {
						login = true;
						while(true) {
							System.out.println("1 정보 2 수정 3 탈퇴 4 로그아웃");
							int ch2 = sc.nextInt();
							if(ch2 ==1 ) {
								System.out.println(t.getName());
							}else if (ch2==2) {
								System.out.println("이름"); String name2 = sc.next();
								t.setName(name2);
								try {
									FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\member2list.txt");
									String as="";
									for(Member2 t2 : members) {
										String ds = t2.getId()+","+t2.getPw()+","+t2.getName()+"\n";
										as+=ds;
									}
									fileOutputStream.write(as.getBytes());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else if (ch2==3) {
								members.remove(t);
								try {
									FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\member2list.txt");
									String q ="";
									for(Member2 t2 : members) {
										String e = t2.getId()+","+t2.getPw()+","+t2.getName()+"\n";
										q+=e;
									}
									fileOutputStream.write(q.getBytes());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}else if (ch2==4) {
								System.out.println("logout");
								break;
							}else {
								System.out.println("nono");
							}
						}
						break;
					}
					if(login) {
						System.out.println("ㅌㅌㅌ");
					}
				}
			}else {
				System.out.println("xxx");
			}
		}
	}
	
}//class end
