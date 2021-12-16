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
	<br><br><br><br>
	<div class="container my-5 table-responsive">
		<h3>게시판 상세 페이지</h3>
			<div class="row">
				<div class="m-2"><a href="boardlist.jsp"><button class = "form-control">목록보기</button></a></div>
				<div class="m-2"><a href="#"><button class = "form-control btn btn-primary">수정하기</button></a></div>
				<div class="m-2"><a href="#"><button class = "form-control btn btn-danger">삭제하기</button></a></div>
			</div>
			<table class= "table  text-center">
				<tr>
					<td style="background-color: #cccccc;">작성자</td><td>작성자이빈다.</td>
					<td style="background-color: #cccccc;">작성일</td><td>2021-12-01</td>
					<td style="background-color: #cccccc;">조회수</td><td>1</td>
				</tr>
				<tr >
					<td style="">제목</td>
					<td colspan="5">제목입니다.</td>
				</tr>
				<tr>
					<td style="height: 300px;">내용</td>
					<td style="height: 300px;" colspan="5">내용입니다.</td>
				</tr>
				<tr>
					<td >첨부파일</td>
					<td colspan="5">첨부파일.</td>
				</tr>
			</table>
	</div>
	
	<%@include file="../view/footer.jsp" %>
</body>
</html>