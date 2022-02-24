<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="DTO.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBPKG.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		.tl{border:1px solid black;}
		.tl td{
			border: 1px solid black;
			text-align: center;
			padding: 5px 15px; /*안쪽여백  */
		}
		.tl th{
			border: 1px solid black;
			text-align: center;
			padding: 5px 15px; /*안쪽여백  */
		}
	</style>
</head>
<body>
	
	<%@include file="header.jsp" %>
	<%@include file="menu.jsp" %>
	<%
		MemberDAO memberDao = new MemberDAO();
		ArrayList<MemberDTO> memberList	= memberDao.getMemberList();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
	%>
	<center>
		<h2>회원목록조회/수정</h2>
		<table class=tl>
			<tr >
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%
				for (MemberDTO temp : memberList) {
					if(temp.getGrade().equals("A")){temp.setGrade("VIP");}
					else if(temp.getGrade().equals("B")){temp.setGrade("일반");}
					else{temp.setGrade("직원");}
			%>
				
			<tr>
				<td><a href="update.jsp?custno=<%=temp.getCustno()%>"><%=temp.getCustno() %></a></td>
				<td><%=temp.getCustname() %></td>
				<td><%=temp.getPhone() %></td>
				<td><%=temp.getAddress() %></td>
				<td><%=temp.getJoindate().split(" ")[0]%></td>
				<td><%=temp.getGrade()%></td>
				<td><%=temp.getCity() %></td>
			</tr>
			<%} %>		
		</table>
	</center>
	<%@include file="footer.jsp" %>
</body>
</html>