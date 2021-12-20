<%@page import="DAO.BoardDAO"%>
<%@page import="DTO.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int b_num = Integer.parseInt(request.getParameter("b_num"));
	String b_title = request.getParameter("b_title");
	String b_contents = request.getParameter("b_contents");
	
	b_contents = b_contents.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
	b_title = b_title.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\S)*(/)?","");
	
	//System.out.print("b_num : "+b_num+ " b_title " + b_title + " b_contents " + b_contents);
	Board board = new Board(b_title, b_contents, b_num);
	boolean rs = BoardDAO.getBoardDAO().boardupdate(board);
	if(rs){
		out.print("<script>alert('수정 완료.');</script>");
		out.println("<script>location.href='../board/boardview.jsp?b_num="+b_num+"';</script>");
	}else{
		out.print("<script>alert('수정 실패.');</script>");
	}
%>