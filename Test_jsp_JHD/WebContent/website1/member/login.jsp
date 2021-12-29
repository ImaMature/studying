<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%@ include file = "../view/header.jsp" %>

	 
	 <br><br><br><br><br><br>
	 <div class="container">
	 	<div class="row d-flex justify-content-between">
	 		<div class="col-md-6 offset-3">
	 			<form action="../controller/logincontroller.jsp" method="post">
	 				<div class="row">
	 					<div class="col-md-3 m-2"><label>아이디</label></div>
	 					<div class="col-md-8 ml-3"><input type="text" name="id" class="form-control" maxlength="15" ></div>
	 				</div>
	 				<div class="row">
	 					<div class="col-md-3 m-2"><label>비밀번호</label></div>
	 					<div class="col-md-8 ml-3"><input type="password" name="password" class="form-control" maxlength="15" ></div>
	 				</div>
	 				<div >
	 					<input type="submit" value="로그인" class="form-control btn btn-primary p-3" style="margin: 2px 0px 2px 0px;">
	 				</div>
	 				<div class="find d-flex justify-content-between ml-2">
	 					<div class="findid"><a href ="#" class = "btn text-dark">아이디 찾기</a></div>
	 					<div class="findpw"><a href ="#" class = "btn text-dark">비밀번호 찾기</a></div>
	 				</div>
	 			</form>
	 		</div>
	 	</div>
	 </div>
	<%@include file="../view/footer.jsp" %>
</body>
</html>