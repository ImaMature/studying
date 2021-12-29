<%@page import="DAO.MemberDAO"%>
<%@page import="DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
String passwordconfirm = request.getParameter("passwordconfirm");
String name = request.getParameter("name");
String email = request.getParameter("email");
String address = request.getParameter("address");
String phone = request.getParameter("phone");
System.out.println("id : " + id);
System.out.println("password : " + password);
System.out.println("name : " + name);
System.out.println("email : " + email);
System.out.println("address : " + address);
System.out.println("phone : " + phone);

Member member = new Member(id, password, name, email, address, phone);
System.out.println("member : " + member.getM_id());


boolean rs = MemberDAO.getMemberDAO().signup(member);
System.out.println(rs);
if(rs){
	out.print("1");
	out.println("<script>location.href='../member/login.jsp';</script>");
}else{
	out.print("0");
	out.print("<script>alert('회원가입 실패');</script>");
	out.println("<script>location.href='../member/signup.jsp';</script>");
}
%>