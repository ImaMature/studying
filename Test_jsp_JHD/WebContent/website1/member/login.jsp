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
	 			<form action="#" method="post">
	 				<div class="row">
	 					<div class="col-md-3 m-2"><label>아이디</label></div>
	 					<div class="col-md-8 "><input type="text" name="id" class="form-control" maxlength="15" ></div>
	 				</div>
	 				<div class="row">
	 					<div class="col-md-3 m-2"><label>비밀번호</label></div>
	 					<div class="col-md-8"><input type="password" name="password" class="form-control" maxlength="15" ></div>
	 				</div>
	 				<div class="row">
	 					<div class="col-md-3 m-2"><label>비밀번호 확인</label></div>
	 					<div class="col-md-8"><input type="password" name="passwordconfirm" class="form-control" maxlength="15" ></div>
	 				</div>
	 				<div >
	 					<input type="submit" value="로그인" class="form-control btn btn-primary p-3 m-3">
	 				</div>
	 				<div class="find d-flex justify-content-between">
	 					<div class="find"><a href ="#" class = "btn text-dark">아이디 찾기</a></div>
	 					<div class="find"><a href ="#" class = "btn text-dark">비밀번호 찾기</a></div>
	 				</div>
	 			</form>
	 		</div>
	 	</div>
	 </div>
	<%@include file="../view/footer.jsp" %>
</body>
</html>