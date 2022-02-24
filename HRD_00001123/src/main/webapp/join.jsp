<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function regchk() {
			//회원 성명
			if(document.join.custname.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("회원성명이 입력되지 않았습니다.").
				document.join.custname.focus(); //포커스(커서 이동)
				return false;
			}
			//회원 전화
			else if(document.join.phone.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("회원전화가 입력되지 않았습니다.").
				document.join.phone.focus(); //포커스(커서 이동)
				return false;
			}
			//회원 주소
			else if(document.join.address.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("회원주소가 입력되지 않았습니다.").
				document.join.address.focus(); //포커스(커서 이동)
				return false;
			}
			//가입일자
			else if(document.join.joindate.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("가입일자가 입력되지 않았습니다.").
				document.join.joindate.focus(); //포커스(커서 이동)
				return false;
			}
			//고객등급
			else if(document.join.grade.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("고객등급이 입력되지 않았습니다.").
				document.join.grade.focus(); //포커스(커서 이동)
				return false;
			}
			//도시코드
			else if(document.join.city.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("도시코드가 입력되지 않았습니다.").
				document.join.city.focus(); //포커스(커서 이동)
				return false;
			//모두 다 입력 되었으면
			}else{
				alert("회원 등록이 완료되었습니다.");
				document.join.submit(); //폼 전송
			}
		}
	</script>
	<%@include file="header.jsp" %>
	<%@include file="menu.jsp" %>
	<center>
		<h2>홈쇼핑 회원 등록</h2>
		<form action="joinController.jsp" method="post" name="join">
			<table>
				<tr>
					<th>회원번호(자동발생)</th><td><input type="text" name="custno"></td>
				</tr>
				<tr>
					<th>회원성명</th><td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th><td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<th>회원주소</th><td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>가입일자</th><td><input type="text" name="joindate"></td>
				</tr>
				<tr>
					<th>고객등급 [A:VIP, B:일반, C:직원]</th><td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th><td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
						<input type="button" value="등록" onclick="regchk();"> 
						<a href="memberlist.jsp"><button>조회</button></a>
						</center>
					</td>
				</tr>
			</table>
		</form>
	</center>
	<%@include file="footer.jsp" %>
</body>
</html>