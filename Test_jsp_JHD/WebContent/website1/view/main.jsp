<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div id="carouselcontent" class="carousel slide" data-ride="carousel" data-interval="2000">
		<ol class="carousel-indicators">
			<li data-target="#carouselcontent" data-slide-to="0" class="active"></li>
			<li data-target="#carouselcontent" data-slide-to="1"></li>
			<li data-target="#carouselcontent" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active"><img src="../img/1.jpg"></div>
			<div class="carousel-item "><img src="../img/2.jpg"></div>
			<div class="carousel-item "><img src="../img/3.jpg"></div>
		</div>
		<a class="carousel-control-prev" href="#carouselcontent" data-slide="prev" >
			<span class="carousel-control-prev-icon"></span>
		</a>
		<a class="carousel-control-next" href="#carouselcontent" data-slide="next" >
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
	
	<div class="container my-3">
		<div class="row">
			<div class="col-md-3">
				<div class="card">
					<a href=""><img class="card-img-top p_img" src="../img/c1.jpg"></a>
					<div class="card-body">
						<p class="card-text">상품1</p>
						<hr>
						<p class="item">
							최고 품질의 옷<br><br>
							<span>120,000원</span>
							<span class="badge badge-pill badge-warning">판매중</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card">
					<a href=""><img class="card-img-top p_img" src="../img/c2.jpg"></a>
					<div class="card-body">
						<p class="card-text">상품2</p>
						<hr>
						<p class="item">
							최고 품질의 옷<br><br>
							<span>120,000원</span>
							<span class="badge badge-pill badge-warning">판매중</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card">
					<a href=""><img class="card-img-top p_img" src="../img/c3.jpg"></a>
					<div class="card-body">
						<p class="card-text">상품3</p>
						<hr>
						<p class="item">
							최고 품질의 옷<br><br>
							<span>120,000원</span>
							<span class="badge badge-pill badge-warning">판매중</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card">
					<a href=""><img class="card-img-top p_img" src="../img/c4.jpg"></a>
					<div class="card-body">
						<p class="card-text">상품4</p>
						<hr>
						<p class="item">
							최고 품질의 옷<br><br>
							<span>120,000원</span>
							<span class="badge badge-pill badge-warning">판매중</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>