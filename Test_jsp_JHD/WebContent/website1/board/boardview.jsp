<%@page import="DTO.Board"%>
<%@page import="DAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../view/header.jsp" %>
	
	<%
	int b_num = Integer.parseInt(request.getParameter("b_num"));
	Board board = BoardDAO.getBoardDAO().boardcontents(b_num);
	%>
	<br><br><br><br>
	<div class="container my-5 table-responsive">
		<h3>게시판 상세 페이지</h3>
			<div class="row">
				<div class="m-2"><a href="boardlist.jsp"><button class = "form-control">목록보기</button></a></div>
				<div class="m-2"><a href="boardupdate.jsp?b_num=<%=board.getB_num()%>"><button class = "form-control btn btn-primary">수정하기</button></a></div>
				<div class="m-2"><a href="../controller/boarddeletecontroller.jsp?b_num=<%=board.getB_num()%>"><button class = "form-control btn btn-danger">삭제하기</button></a></div>
			</div>
			<table class= "table  text-center">
				<tr>
					<td style="background-color: #cccccc;">작성자</td><td>익명.</td>
					<td style="background-color: #cccccc;">작성일</td><td><%=board.getB_date() %></td>
					<td style="background-color: #cccccc;">조회수</td><td>1</td>
				</tr>
				<tr >
					<td style="background-color: #cccccc;">제목</td>
					<td colspan="5"><%=board.getB_title() %></td>
				</tr>
				<tr>
					<td style="background-color: #cccccc; height: 300px;">내용</td>
					<td style=" height: 300px;" colspan="5"><%=board.getB_contents() %></td>
				</tr>
				<tr>
					<td style="background-color: #cccccc;">첨부파일</td><td>공사중</td>
					
				</tr>
			</table>
	</div>
	
	<%@include file="../view/footer.jsp" %>
</body>
</html>