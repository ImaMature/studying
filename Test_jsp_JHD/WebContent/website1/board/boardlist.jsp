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
	
	<br><br><br><br><br>
	<div class = "container mt-5">
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
			<tr>
				<td>5</td><td><a href="boardview.jsp">제목입니다.</a></td><td>작성자입니다.</td><td>2021-12-01</td><td>1</td>
			</tr>
			<tr>	
				<td>4</td><td><a href="boardview.jsp">제목입니다.</a></td><td>작성자입니다.</td><td>2021-12-01</td><td>1</td>
			</tr>
			<tr>	
				<td>3</td><td><a href="boardview.jsp">제목입니다.</a></td><td>작성자입니다.</td><td>2021-12-01</td><td>1</td>
			</tr>
			<tr>	
				<td>2</td><td><a href="boardview.jsp">제목입니다.</a></td><td>작성자입니다.</td><td>2021-12-01</td><td>1</td>
			</tr>
			<tr>	
				<td>1</td><td><a href="boardview.jsp">제목입니다.</a></td><td>작성자입니다.</td><td>2021-12-01</td><td>1</td>
			</tr>	
			
		</table>
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
</body>
</html>