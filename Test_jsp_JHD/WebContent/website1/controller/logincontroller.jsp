<%@page import="DTO.Member"%>
<%@page import="DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String id = request.getParameter("id");
String password = request.getParameter("password");
Member member = new Member(id,password);
boolean result = MemberDAO.getMemberDAO().login(member);
if(result){
	out.print("<script>alert('로그인 성공');</script>");
	out.println("<script>location.href='../view/main.jsp';</script>");
}else{
	out.print("<script>alert('로그인 실패');</script>");
	out.println("<script>location.href='../member/login.jsp';</script>");
}
%>
</body>
</html>