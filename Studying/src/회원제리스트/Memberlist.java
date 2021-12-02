package 회원제리스트;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Memberlist {

	//1. 1. 리스트를 이용한 회원가입 , 로그인 , 회원정보 , 회원수정 , 회원탈퇴
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);	//입력객체 선언
			ArrayList<Member> members = new ArrayList<>(); //Member 클래스의 메모리를(변수, 객체, 메소드, 생성자) 담을 리스트 선언	
			try {
				FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\list.txt");
				//스트림은 입출력 장치들의 중간자 역할을 한다.
				byte [] arr = new byte[1024]; //읽어온 정보가 담긴 바이트배열 //스트림을 통해서 어떻게 바이트배열을 거쳐서 읽어오는 것인지????????
				//임시 배열??같은 느낌인지???
				
				//파일 읽어오기 (바이트)
				fileInputStream.read(arr);
				//바이트 -> String 화
				String meminfo = new String(arr);
				
				String [] mem = meminfo.split("\n"); //회원별 분리
				
				
				for(String temp : mem) {
					//for(임시객체 : 리스트) -> 리스트 내 모든 객체를 하나씩 임시 객체에 대입
					// 이 원리가 이해가 안 갑니다.
					
					String [] member2 = temp.split(",");
					//temp객체에 저장된 배열?리스트? 정보? 들을 ","를 기점으로 나눈 값을
					//String member2 배열에 저장
					
					if(member2.length==1) break; 
					//길이가 1이면 for문을 멈춘다. Arrays.toString()이나 +""를 해서 확인해보니 개행이 마지막 배열이나 인덱스에 들어가있었습니다.
					//공백제거를 위한것 (/r/n)
					
					Member member = new Member(member2[0], member2[1], member2[2], member2[3]);
					//,를 기준으로 자른 값들을 객체화
					
					members.add(member); // 값들을 리스트에 저장
					
				}
//				for(int i =0; i<mem.length; i++) {
//					String [] member2 = mem[i].split(","); //","를 기준으로 자르기
//					for(int l =0; l<member2.length; l++) { //자른 값들을 for문 돌려서
//						if(member2.length == 1) 
//							break;// 공백이면(개행이 있다면) 중지
//						//!!!!!!!!개행 빼는 법을 잘 모르겠음.
//					}break;
					
			} catch (Exception e) {
				System.out.println("파일 읽어오기 실패" + e.getMessage());
			}
			
			while(true) {
				System.out.println("번호를 선택해주세요.");
				System.out.println("1.회원가입 | 2. 로그인 ");
				
				int ch = sc.nextInt(); // 
				
				if( ch ==1 ) { // 입력받은 번호 1번일 떄
					System.out.println("회원가입 페이지");
					System.out.print("아이디 입력 :"); 		String id = sc.next();
					System.out.print("비밀번호 입력 :");	String pw = sc.next();
					System.out.print("이름 입력 :"); 		String name = sc.next();
					System.out.print("전화번호 입력 :");	String phone = sc.next();
					
					Member member = new Member(id, pw, name, phone); 
					// 입력받은 객체를 Member 클래스 생성자에 전달하는 객체 선언
					// 객체는 선언 후 메모리를 할당해야지만 사용 가능
					// 객체를 저장한 공간을 변수, 메모리에 저장된 자료는 객체
					
					boolean idcheck = true; //중복체크
					
					
						for(Member temp : members) {	
							//ArrayList길이 만큼 반복문 실행
							if(temp.getId().equals(id)) { 
								//i값이 id와 같다면 중복
								System.out.println("중복된 아이디 입니다.");
								idcheck = false; 
								break; // 중복되면 끝내기
							}
						}
					
					//입력한 id값이 중복이 아니라면
					if(idcheck) {
						//리스트에 member변수 저장
						members.add(member);
						System.out.println("가입완료");
						try {
							FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\list.txt" , true);
							//누적 저장 : true
							//회원의 정보 객체화
							String output = member.getId()+","+member.getPw()+","+member.getName()+","+member.getPhone()+"\n";
								//정보(,)와 회원들(\n) 간 구분하기
							
							 //String -> byte화
							fileOutputStream.write(output.getBytes());
							System.out.println("파일 처리 완료");
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					

				}else if ( ch ==2 ) { //
					//입력받기
					System.out.println("아이디 : "); String id = sc.next();
					System.out.println("비밀번호 : "); String pw = sc.next();
					
					boolean login = true;
					for(Member temp : members) { // members의 요소가 순차적으로 temp(리스트)에 저장된다.
						if(temp.getId().equals(id) && temp.getPw().equals(pw)) { //리스트에 저장된 값들을 입력받은 값과 비교
							login = false;
							while(true) { //무한루프
								
								System.out.println("1. 회원정보 | 2. 회원수정 | 3. 회원탈퇴 | 4. 로그아웃");
								
								int ch2 = sc.nextInt();
								
								if ( ch2 == 1 ) {
									System.out.println("회원정보 페이지");
									System.out.println("아이디" + temp.getId());
									System.out.println("이름" + temp.getName());
									System.out.println("전화번호" + temp.getPhone());
									//temp 객체에서 저장된 값들을 가져와 출력
									
								}else if ( ch2 == 2 ) {
									System.out.println("회원수정 페이지");
									System.out.println("수정할 이름 : "); String name2 = sc.next();
									System.out.println("수정할 핸드폰 번호 : "); String phone2 = sc.next();
									temp.setName(name2);
									temp.setPhone(phone2);
									//temp 객체에 저장된 값을 .set~메소드로 입력받은 값으로 변경
									
									try {
										FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\list.txt");
										//출력하는 객체 생성
										
										//리스트 내에 회원 정보 저장
										String output=""; //모든 회원의 정보를 담을 문자열??
										//이걸 쓰는 이유?? 
								
										for(Member temp2 : members) {
											//회원을 ,와 개행으로 구분
											String newout = temp2.getId()+","+temp2.getPw()+","+temp2.getName()+","+temp2.getPhone()+"\n";
											//분류된 회원 정보를 모든 회원 문자열에 추가하기
											output = output + newout;
										}
										//모든 회원 파일로 내보내기
										fileOutputStream.write(output.getBytes());
										
									} catch (Exception e) { // 예외처리를 Exception으로 해야 .write()가 오류가 안남
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}else if (ch2 == 3) {
									System.out.println("회원탈퇴");
									members.remove(temp); 	//현재 로그인한 회원의 정보들이 temp에 순차적으로 저장되어있음.
															//그래서 temp를 지워버리면 저장된 회원의 정보들이 지워짐.
															//그러나 이것만 하면 오류가 뜸
									try {
										FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\JHD\\git\\studying\\Studying\\src\\회원제리스트\\list.txt");
										
										//업데이트 ( 다시 빈 문자열에 추가해야됨 )
										String delete = ""; 
										for(Member temp2 : members) {
											
											//정보를 다시 모든 회원 문자열에 추가
											String m_remove = temp2.getId()+","+temp2.getPw()+","+temp2.getName()+","+temp2.getPhone()+"\n";
											// , 과 "\n"으로 회원 구분
											delete += m_remove;
										}
										fileOutputStream.write(delete.getBytes());
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break; // while문 탈출
								
								}else if (ch2 == 4) {
									System.out.println("[로그아웃]");	
									break; // while문 탈출
								}
							}
							break; //회원탈퇴시 무한루프를 탈출해야되기때문에 while문에도 break;
						}
						
					}
					if(login) {
						System.out.println("로그인 실패. 동일한 정보가 없습니다.");
					}
				}else {
					System.out.println("알 수 없는 명령입니다.");
				}
			} // while end
		}//main end
}//class end
