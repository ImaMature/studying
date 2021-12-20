<%@page import="DAO.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
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

	<%@include file="../view/header.jsp" %>
	<% 
		ArrayList<Board> boards = BoardDAO.getBoardDAO().boardlist();
		//System.out.print("boards : " + boards.get(0).getB_title()+","+boards.get(0).getB_date()+","+boards.get(0).getB_contents());
	%>
	<br><br><br><br><br>
	<div class="container">
		<div class = " mt-5">
			<div class="text-center">
				<h3>고객센터</h3>
			</div>
		</div>
		<div class="col-md-12">
			<table class = "table text-center">
				<tr class="table-active">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<%for(Board temp : boards) {%>
				<tr>
					<td><%=temp.getB_num() %></td>
					<td>
						<a href="boardview.jsp?b_num=<%=temp.getB_num() %>"><%=temp.getB_title() %></a>
					</td>
					<td>작성자입니다.</td>
					<td><%=temp.getB_date() %></td>
					<td><%=temp.getB_view() %></td>
				</tr>
				<%} %>	
			</table>
		</div>
		<div class="offset-11 col-md-1">
			<a href="boardwrite.jsp?"><button class="btn btn-primary">글쓰기</button></a>
		</div>
		
		
		<form action="#" method="get" class = "col-md-5 offset-3 input-group my-3">
			<select class="custom-select col-md-3"> 
				<option value="b_title">제목</option>
				<option value="b_contents">내용</option>
				<option value="b_num">번호</option>
				<option value="b_writer">작성자</option>
			</select>
			<input type="text" class="form-control">	<!-- keyword : 검색대상 -->
			<input type="submit" class="btn btn-primary" value="검색">
		</form>
	<%@include file="../view/footer.jsp" %>
	</div>
</body>
</html>