package view;

import java.util.Scanner;

import controller.BoardController;
import controller.MemberController;
import controller.ReplyController;
import database.File;
import model.Board;
import model.Member;
import model.Reply;

public class Application {

	public static Scanner sc = new Scanner(System.in); //입력 객체(static)
	
	
	public static void main(String[] args) {//main start
		
		//프로그램 시작
		File.txtload(1);
		File.txtload(2);
		mainmenu(); //메인메뉴 메소드 호출
		
	}//main end

	public static void mainmenu() {
		
		while(true) {
			try {
				sc = new Scanner(System.in);
				System.out.println("--------------- 회원 커뮤니티 ----------------");
				System.out.println("1. 로그인 | 2. 회원가입 | 3. 아이디찾기 | 4. 비밀번호찾기");
				System.out.println("번호 선택 : ");	int ch = sc.nextInt();
				
				//로그인
				if(ch == 1) {
					System.out.println("=== 로그인 페이지 ===");
					System.out.println("아이디 입력 : ");	String id = sc.next();
					System.out.println("패스워드 입력 : ");	String pw = sc.next();
					
					boolean rs = MemberController.login(id, pw); //로그엔 메소드에 인수 전달
					if(rs) { //true일 때
						System.out.println("로그인 완료.");
						membermenu(id); //메소드 호출 및 인수 전달
					}else { //false일때
						System.err.println("로그인 실패.");
						
					}
				
				//회원가입
				}else if(ch == 2) {
					System.out.println("=== 회원가입 페이지 ===");
					System.out.println("아이디 입력 : ");	String id = sc.next();
					System.out.println("패스워드 입력 : ");	String pw = sc.next();
					System.out.println("이름 입력 : ");	String name = sc.next();
					System.out.println("이메일 입력 : ");	String email = sc.next();
					//변수들 캡슐화
					Member member = new Member(id, pw, name, email, 0);
					
					boolean rs = MemberController.signup(member); //회원 가입 유효성 검사 메소드 호출
					if(rs) {
						
						System.out.println("회원 가입 완료.");
						System.out.println("회원 가입을 축하드립니다. 포인트 100 증정.");
					}else {
						System.err.println("회원 가입 실패.");
					}
					
				//아이디 찾기	
				}else if(ch == 3) {
					System.out.println("=== 아이디 찾기 페이지 ===");
					System.out.println("이름 입력 : ");	String name = sc.next();
					System.out.println("이메일 입력 : ");	String email = sc.next();
					
					String rs = MemberController.findpw(name, email);
					if(!rs.equals(null)) {
						//System.out.println("회원님의 아이디를 이메일로 전송했습니다.");
						System.out.println("회원님의 아이디는 " + rs+"입니다.");
					}else {
						System.err.println("해당하는 정보와 일치하는 정보가 없습니다.");
					}
				
				//비밀번호 찾기	
				}else if(ch == 4) {
					System.out.println("=== 비밀번호 찾기 페이지 ===");
					System.out.println("아이디 입력 : ");	String id = sc.next();
					System.out.println("이메일 입력 : ");	String email = sc.next();
					
					//boolean rs = MemberController.findpw(id, email);
					String rs = MemberController.findpw(id, email);
					if(!rs.equals(null)) {
						//System.out.println("회원님의 비밀번호를 이메일로 전송했습니다.");
						System.out.println("회원님의 비밀번호는 " + rs+"입니다.");
					}else {
						System.err.println("해당하는 정보와 일치하는 정보가 없습니다.");
					}
				}
			}catch (Exception e) {
				System.err.println("잘못된 입력 입니다.");
			}
			
		}
	}//mainmenu end

	//로그인 성공시 메뉴 나오는 메소드
	public static void membermenu(String id) {
		while(true) {
			try {
				sc = new Scanner(System.in); //무한루프 안될때 방지용
				System.out.println("------------ 회원 메뉴 -----------");
				System.out.println("1.회원정보 | 2.커뮤니티 | 3.로그아웃");
				System.out.println("--------------------------------");
				System.out.print("선택 : ");		int ch = sc.nextInt();
				
				//회원정보
				if(ch==1) {
					System.out.println("[[회원정보]]");
					
					Member rs = MemberController.m_info(id);
					System.out.println("-----------------------------");
					System.out.println("아이디 : " + rs.getId());
					System.out.println("이름 : " + rs.getName());
					System.out.println("이메일 : " + rs.getEmail());
					System.out.println("포인트 : " + rs.getPoint());
					System.out.println("-----------------------------");
					
				//커뮤니티(게시판)	
				}else if(ch==2) {
					System.out.println("[[커뮤니티 페이지]]");
					//게시판 메소드 호출
					boardmenu(id);
					
				//로그아웃	
				}else if(ch==3) {
					System.out.println("로그아웃 되었습니다.");
					//현재 메소드 끝내기
					break;
					
				}else {
					System.out.println("잘못된 입력입니다.");
				}
			}catch (Exception e) {
				System.out.println("회원 페이지 오류");
				System.out.println(e.getMessage());
			}
		}
	}//membermenu end
	
	//게시판 페이지 메소드
	public static void boardmenu(String id) {
		while(true) {
			try {
				sc = new Scanner(System.in); //무한루프 안될때 방지용
				System.out.println("-------------------- 게시판 페이지 -------------------");
				System.out.println("\n번호\t타이틀\t\t작성자\t작성일\t조회수");
				
				//게시물 출력하는 곳
				//번호 = i = 1
				int i = 1;
				for(Board temp : BoardController.boards) {
					System.out.println(i+"\t"+temp.getTitle()+"\t\t"+temp.getWriter()+"\t"+temp.getDate()+"\t"+temp.getView());
					i++;
				}
				System.out.println("--------------------------------------------------");
				
				System.out.println("--------------------------------------------------");
				System.out.println("1. 등록 | 2. 상세보기 | 3. 뒤로가기");
				System.out.println("--------------------------------------------------");
				System.out.print("선택 : ");		int ch = sc.nextInt();
				
				//게시물 등록
				if(ch==1) {
					System.out.println("------------------- 게시판 등록 페이지 ------------------");
					//오류방지
					sc.nextLine();
					System.out.println("제목 : ");	String title = sc.nextLine();
					System.out.println("내용 : ");	String contents = sc.nextLine();
					
					//입력받은 제목, 내용, boardmenu메소드로 전달받은 id 객체화
					Board board = new Board(title, contents, id);
					boolean rs = BoardController.boardAdd(board);
					if(rs) {
						System.out.println("게시물 등록 완료");
					}else {
						System.err.println("게시물 등록 실패");
					}
					
				//게시물 상세보기	
				}else if(ch==2) {
					System.out.println("게시물 번호 입력 : "); int boardCh = sc.nextInt();
					Board board = BoardController.b_detail(boardCh-1);
					
					//null값인 경우
					if(board==null) {
						System.err.println("해당하는 번호의 게시물이 존재하지 않습니다.");
					}else {
						System.out.println("------------------- 게시판 상세보기 ------------------");
						System.out.println("제목 : " + board.getTitle());
						System.out.println("내용 : " + board.getContents());
						System.out.println("작성자 : " + board.getWriter());
						System.out.println("작성일 : " + board.getDate());
						System.out.println("조회수 : " + board.getView());
						System.out.println("-----------------------댓글------------------------");
						// 리플 출력
						System.out.println("작성자\t댓글 내용\t\t작성일");
										//???
						for(Reply temp : board.getReplies()) {
							System.out.println(temp.getWriter()+"\t"+temp.getContents()+"\t\t"+temp.getDate());
						}
						System.out.println("--------------------------------------------------");
						System.out.println();
						System.out.println("1.댓글 쓰기 | 2. 뒤로가기");
						
						//게시판 번호의 id와 boardmenu(id)에서 전달받은 id값(로그인한 id값)이 같다면 게시물 수정 삭제 가능 
						if(board.getWriter().equals(id)) {
							System.out.println("3. 게시물 삭제 | 4. 게시물 수정");
						}
						
						int ch2 = sc.nextInt();
						
						//댓글 쓰기
						if(ch2 == 1) {
							sc.nextLine(); //오류 방지
							System.out.println("\n내용 입력 : "); String contents = sc.nextLine(); //띄어쓰기 포함
							//내용 id 객체화
							Reply reply = new Reply(contents, id);
							System.out.println(boardCh);
							//댓글 등록을 위해서 (게시물 번호, 리플 객체(내용, 아이디)) 인수로 넘기기
							boolean rs = ReplyController.r_Add(boardCh-1, reply);
							if(rs) {
								System.out.println("댓글 등록 완료");
							}else {
								System.err.println("댓글 등록 실패, 해당 번호의 게시물이 존재하지 않습니다.");
							}
							
						//뒤로가기	
						}else if (ch2 == 2) {
							return;
							
						//게시물 삭제	
						}else if (ch2 == 3) {
							System.out.println("현재 삭제하려는 게시물은"+ boardCh+" 번째 게시물 입니다.");
							System.out.println("정말 삭제하시겠습니까? 예[y] 아니오[n]" );
							String removech = sc.next();
							if(removech.equals("y")) {
								BoardController.boards.remove(boardCh-1);
								File.txtload(2);
								System.out.println("게시물 삭제 성공");
							}else if(removech.equals("n")){
								System.out.println("게시물 삭제 취소");
								
							}else {
								System.err.println("잘못된 입력입니다.");
							}
							
						//게시물 수정
						}else if (ch2 == 4) {
							System.out.println("현재 수정하려는 게시물은"+ boardCh+" 번째 게시물 입니다.");
							System.out.println("정말 수정하시겠습니까? 예[y] 아니오[n]" );
							
							String removech = sc.next();
							
							if(removech.equals("y")) {
								sc.nextLine();
								System.out.println("제목 : "); String newTitle = sc.nextLine();	
								System.out.println("내용 : "); String newContents = sc.nextLine();
								Board board2 = new Board(newTitle, newContents, id);
								boolean rs = BoardController.b_rewrite(board2);
								
							}else if(removech.equals("n")){
								System.out.println("게시물 수정 취소");
								
							}else {
								System.err.println("잘못된 입력입니다.");
							}
						}
					}//게시물 상세보기 끝
				//뒤로가기	
				}else if(ch==3) {
					System.out.println("뒤로가기를 선택하셨습니다.");
					break;
				}else {
					System.out.println("잘못된 입력입니다.");
				}
			}catch (Exception e) {
				System.out.println("게시판 페이지 오류");
				System.out.println(e.getMessage());
			}
		}//while end
	}//boardmenu end
}//class end
