<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
	<link rel="stylesheet" href="/Test_jsp_JHD/website1/css/main.css?=v3">
</head>
<body>

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
	
	<script src="../../js/main.js"></script>
	
	<div class="fixed-top bg-white">
		<div class="container">
			<header class="py-3">
			
				<div class="row">
					<div class="col-md-4 offset-4 text-center">
						<a href="/Test_jsp_JHD/website1/view/main.jsp" class="header_logo">쇼핑몰</a>
					</div>
					<div class="col-md-4 d-flex justify-content-end">
						<ul class="nav header-topmenu">
							<li><a class="header_menu mx-3" href="../member/login.jsp">로그인</a></li>
							<li><a class="header_menu" href="../member/signup.jsp">회원가입</a></li>
						</ul>
					</div>
				</div>
			</header>
			
			<nav class="navbar navbar-expand-lg navbar-light bg-white">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-toggle="#main_menu">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="main_menu">
					<ul class="navbar-nav col-md-12 justify-content-between" > <!-- 알아서 수직정렬하기 -->
						<li class="nav-item"><a href="#" class="nav-link">세일</a></li>
						<li class="nav-item"><a href="#" class="nav-link">베스트</a></li>
						<li class="nav-item"><a href="#" class="nav-link">남성복</a></li>
						<li class="nav-item"><a href="#" class="nav-link">여성복</a></li>
						<li class="nav-item"><a href="/Test_jsp_JHD/website1/board/boardlist.jsp" class="nav-link">고객센터</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>