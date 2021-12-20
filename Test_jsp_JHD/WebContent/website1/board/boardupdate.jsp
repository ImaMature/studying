<%@page import="DAO.BoardDAO"%>
<%@page import="DTO.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file ="../view/header.jsp" %>
	<%
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		Board board = BoardDAO.getBoardDAO().boardcontents(b_num);
		//System.out.println("board : " + board.getB_title()+"," +b_num+",");
	%>

	<div class="container" style="margin-top: 160px;">
		<form action="../controller/boardupdatecontroller.jsp" method="post">
			<input type="hidden" name="b_num" value="<%=b_num%>">
			제목 : <input type="text"  name="b_title" class="form-control" >
			내용 : <textarea rows="10" cols="20" name="b_contents" class="form-control" ></textarea>
			<input type="submit" class="form-control btn btn-primary mt-3" value="수정완료">
		</form>
	</div>
</body>
</html>