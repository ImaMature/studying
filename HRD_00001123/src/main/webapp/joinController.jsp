<%@page import="DBPKG.MemberDAO"%>
<%@page import="DTO.MemberDTO"%>
<%
request.setCharacterEncoding("utf-8"); // 한글 변수 요청시 꼭 사용하기

//join 페이지에서 변수 요청하여 dto 생성자로 dto 객체 만들기
MemberDTO memberDTO = new MemberDTO(
	request.getParameter("custno"),
	request.getParameter("custname"),
	request.getParameter("phone"),
	request.getParameter("address"),
	request.getParameter("joindate"),
	request.getParameter("grade"),
	request.getParameter("city")
	);

//db 저장
MemberDAO memberDAO = new MemberDAO();
boolean rs = memberDAO.join(memberDTO);

response.sendRedirect("join.jsp");

%>