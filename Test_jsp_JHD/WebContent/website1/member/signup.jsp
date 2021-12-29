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
 	
 	
	<div class="container" style="margin-top: 150px;">
		<div class="col-md-6 offset-3">
			<form id="formsignup" action="../controller/signupcontroller.jsp" method="post" onsubmit="return signup()">
				<div class="ml-3">
					<div class = "row">
		            	<div class = "col-md-3 m-2"><label>아이디</label></div>
		                <div class = "col-md-8 ml-3"> <input type="text" id="id" name = "id" class = "form-control"onchange="signup();" ></div>
		            </div>
		            <div>
		            	<span id="IdResult"></span>
		            </div>
		            <div class = "row">
		                <div class = "col-md-3 m-2"><label>비밀번호</label></div>
		                <div class = "col-md-8 ml-3"> <input type="password" name = "password" class = "form-control" onchange="signup();"></div>
		            </div>
		            <div>
		            	<span id="PwResult"></span>
		            </div>
		            <div class = "row">
		                <div class = "col-md-3 m-2"><label>비밀번호 확인</label></div>
		                <div class = "col-md-8 ml-3"> <input type="password" name = "passwordconfirm" class = "form-control" onchange="signup();"></div>
		            </div>
		            <div>
		            	<span id="PwCResult"></span>
		            </div>
		            <div class = "row">
		                <div class = "col-md-3 m-2"><label>이름</label></div>
		                <div class = "col-md-8 ml-3"> <input type="text" name = "name" class = "form-control" onchange="signup();"></div>
		            </div>
		            <div>
		            	<span id="NameResult"></span>
		            </div>
		            <div class = "row">
		               	<div class = "col-md-3 m-2"><label>이메일</label></div>
		               	<div class = "col-md-8 ml-3"> <input type="email" name = "email" class = "form-control" onchange="signup();"></div>
		            </div>
		            <div>
		            	<span id="EmailResult"></span>
		            </div>
		            <div class = "row">
		               	<div class = "col-md-3 m-2"><label>주소</label></div>
		               	<div class = "col-md-8 ml-3"> <input type="text" name = "address" class = "form-control" onchange="signup();"></div>
		            </div>
		            <div>
		            	<span id="AddrResult"></span>
		            </div>
	            	<div class = "row">
	                	<div class = "col-md-3 m-2"><label>연락처</label></div>
		                <div class = "col-md-8 ml-3"> 
		                    <input type="text" name = "phone" class = "form-control" placeholder = "000-0000-0000" onchange="signup();" >
		                </div>
	            	</div>
	            	<div>
		            	<span id="PhoneResult"></span>
		            </div>
	              </div>
	              <div>
	                 <input type="submit" value = "가입하기 " class = "form-control btn btn-primary p-3 m-3">
	              </div>
			</form>
		</div>
	</div>

</body>
</html>