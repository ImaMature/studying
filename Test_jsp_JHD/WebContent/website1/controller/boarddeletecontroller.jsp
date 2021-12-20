<%@page import="DAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_num = Integer.parseInt(request.getParameter("b_num"));
	boolean rs = BoardDAO.getBoardDAO().boarddelete(b_num);
	if(rs){
		out.print("<script>alert('삭제 되었습니다.');</script>");
		out.println("<script>location.href='../board/boardlist.jsp';</script>");
	}else{
		out.print("<script>alert('삭제 실패했습니다.');</script>");
		out.println("<script>location.href='../board/boardlist.jsp';</script>");
	}
%>