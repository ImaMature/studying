<%@page import="java.util.ArrayList"%>
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
	<%
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.getMoneyList();
	%>
	<center>
		<h2>회원매출조회</h2>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%
				for (MemberDTO temp : list){ 
					if(temp.getGrade().equals("A")){temp.setGrade("VIP");}
					else if(temp.getGrade().equals("B")){temp.setGrade("일반");}
					else{temp.setGrade("직원");}
			%>
			<tr>
				<td><%=temp.getCustno() %></td>
				<td><%=temp.getCustname() %></td>
				<td><%=temp.getGrade() %></td>
				<td><%=temp.getMoney() %></td>
			</tr>
			<%} %>
		</table>
	</center>
	<%@include file="footer.jsp" %>
</body>
</html>