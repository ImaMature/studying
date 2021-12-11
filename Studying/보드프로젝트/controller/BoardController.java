package controller;

import java.util.ArrayList;

import database.File;
import model.Board;

public class BoardController {

	public static ArrayList<Board> boards = new ArrayList<>(); //게시판 리스트 선언
	
	//게시물 등록
	public static boolean boardAdd(Board board) {
		
		boards.add(board); //리스트에 저장
		
		File.txtsave(2); //게시판 저장하는 메소드호출
		
		return true;
	}

	//게시판 상세페이지
	public static Board b_detail(int boardch) {//{(선택한 번호-1)==boardch}의 값을 가진 인수를 넘겨받음
		try {
			Board board = boards.get(boardch);  //boardch번째의 인덱스를 가져옴
			return board;
		}catch(Exception e) {
			return null;		//해당 값이 없으면 null값 반환
		}
	}

	public static boolean b_rewrite(Board board2) {
		
		try {
			for(int i =0; i<boards.size(); i++) {
				boards.get(i).setTitle(board2.getTitle());
				boards.get(i).setContents(board2.getContents());
				File.txtsave(2);
				break;
			}
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	

	
}
