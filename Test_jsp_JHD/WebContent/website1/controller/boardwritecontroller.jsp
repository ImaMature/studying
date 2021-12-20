<%@page import="DAO.BoardDAO"%>
<%@page import="DTO.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String b_title = request.getParameter("b_title");
String b_contents = request.getParameter("b_contents");
System.out.println(b_title+","+b_contents);

//태그 막기
b_contents = b_contents.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
b_title = b_title.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?", "");

Board board = new Board(b_title, b_contents);

BoardDAO.getBoardDAO().boardwrite(board);
response.sendRedirect("../board/boardlist.jsp");

%>
