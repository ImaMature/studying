package controller;

import model.Reply;

public class ReplyController {

	public static boolean r_Add(int boardCh, Reply reply) {
		
		try {
			//게시판 리스트의 선택한 인덱스번째의 번호인 게시물을 가져와서 리플 리스트에 리플 내용(내용, 아이디)을 넣는다. 
			BoardController.boards.get(boardCh).getReplies().add(reply);
			return true;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	
}
