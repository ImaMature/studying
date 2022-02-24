<%@page import="DTO.MemberDTO"%>
<%
request.setCharacterEncoding("utf-8"); // 한글 변수 요청시 꼭 사용하기

MemberDTO memberDTO = new MemberDTO();
request.getParameter("custno");
request.getParameter("custname");
request.getParameter("phone");
request.getParameter("address");
request.getParameter("joindate");
request.getParameter("grade");
request.getParameter("city");
%>