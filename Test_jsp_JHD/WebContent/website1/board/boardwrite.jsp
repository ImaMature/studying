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
	<div class="container" style="margin-top: 160px;">
		<div style="width: 800px; margin-left: 180px;">
			<h3>글쓰기 페이지</h3>
			<form class="form-control-group" action="../controller/boardwritecontroller.jsp">
			제목 : <input type="text" name ="b_title" class="form-control"><br>
			내용 : <textarea rows="10" cols="20" name="b_contents"  class="form-control"></textarea>
			<input type="submit"  class="btn btn-primary mt-3 form-control" value="등록하기">
			</form>
		</div>
	</div>
</body>
</html>