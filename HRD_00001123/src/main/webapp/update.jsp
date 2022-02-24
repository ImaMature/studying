<%@page import="DTO.MemberDTO"%>
<%@page import="DBPKG.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<%@include file="menu.jsp" %>
	<script type="text/javascript">
		function memberUpdate() {
			//회원 성명
			if(document.update.custname.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("회원성명이 입력되지 않았습니다.").
				document.update.custname.focus(); //포커스(커서 이동)
				return false;
			}
			//회원 전화
			else if(document.update.phone.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("회원전화가 입력되지 않았습니다.").
				document.update.phone.focus(); //포커스(커서 이동)
				return false;
			}
			//회원 주소
			else if(document.update.address.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("회원주소가 입력되지 않았습니다.").
				document.update.address.focus(); //포커스(커서 이동)
				return false;
			}
			//가입일자
			else if(document.update.joindate.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("가입일자가 입력되지 않았습니다.").
				document.update.joindate.focus(); //포커스(커서 이동)
				return false;
			}
			//고객등급
			else if(document.update.grade.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("고객등급이 입력되지 않았습니다.").
				document.update.grade.focus(); //포커스(커서 이동)
				return false;
			}
			//도시코드
			else if(document.update.city.value == ""){
				//문서.폼이름.input이름.값 이 공백이면
				alert("도시코드가 입력되지 않았습니다.").
				document.update.city.focus(); //포커스(커서 이동)
				return false;
			//모두 다 입력 되었으면
			}else{
				alert("회원 수정이 완료되었습니다.");
				document.update.submit(); //폼 전송
			}
		}
	</script>
	
	<%
		MemberDAO memberDAO = new MemberDAO();
		String custno = request.getParameter("custno");
		MemberDTO memberDTO = memberDAO.getMember(custno);
	%>
	<center>
	<h2>홈쇼핑 회원 정보 수정</h2>
	<form action="updateController.jsp" method="post" name="update">
		<table>
			<tr>
				<th>회원번호(자동발생)</th><td><input type="text" name="custno" value="<%=memberDTO.getCustno()%>"></td>
			</tr>
			<tr>
				<th>회원성명</th><td><input type="text" name="custname" value="<%=memberDTO.getCustname()%>"></td>
			</tr>
			<tr>
				<th>회원전화</th><td><input type="text" name="phone" value="<%=memberDTO.getPhone()%>"></td>
			</tr>
			<tr>
				<th>회원주소</th><td><input type="text" name="address" value="<%=memberDTO.getAddress()%>"></td>
			</tr>
			<tr>
				<th>가입일자</th><td><input type="text" name="joindate" value="<%=memberDTO.getJoindate()%>"></td>
			</tr>
			<tr>
				<th>고객등급 [A:VIP, B:일반, C:직원]</th><td><input type="text" name="grade" value="<%=memberDTO.getGrade().split(" ")[0]%>"></td>
			</tr>
			<tr>
				<th>도시코드</th><td><input type="text" name="city" value="<%=memberDTO.getCity()%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
					<input type="button" value="수정" onclick="memberUpdate();"> 
					<a href="memberlist.jsp"><button type="button">조회</button></a>
					</center>
				</td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>