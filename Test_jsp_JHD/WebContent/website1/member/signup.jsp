<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="col-md-12">
			<form action="signup.jsp" method="post">
				<div class = "row">
	                 <div class = "col-md-3 m-2"><label>아이디</label></div>
	                 <div class = "col-md-8"> <input type="text" name = "id" class = "form-control" maxlength="15" ></div>
	               
	              </div>
	              <div class = "row">
	                 <div class = "col-md-3 m-2"><label>비밀번호</label></div>
	                 <div class = "col-md-8"> <input type="password" name = "password" class = "form-control" maxlength="15"></div>
	              </div>
	              <div class = "row">
	                 <div class = "col-md-3 m-2"><label>비밀번호 확인</label></div>
	                 <div class = "col-md-8"> <input type="password" name = "passwordconfirm" class = "form-control" maxlength="15"></div>
	              </div>
	              <div class = "row">
	                 <div class = "col-md-3 m-2"><label>이름</label></div>
	                 <div class = "col-md-8"> <input type="text" name = "name" class = "form-control" maxlength="10"></div>
	              </div>
	              <div class = "row">
	                 <div class = "col-md-3 m-2"><label>생년월일</label></div>
	                 <div class = "col-md-8"> <input type="date" name = "birth" class = "form-control"></div>
	              </div>
	              <div class = "row">
	                 <div class = "col-md-3 m-2"><label>연락처</label></div>
	                 <div class = "col-md-8"> 
	                    <input type="text" name = "phone" class = "form-control" placeholder = "000-0000-0000" maxlength="11">
	                </div>
	              </div>
	              <div>
	                 <input type="submit" value = "가입하기 " class = "form-control p-3 m-3">
	              </div>
			</form>
		</div>
	</div>

</body>
</html>