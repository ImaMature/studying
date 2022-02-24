<%@page import="DBPKG.MemberDAO"%>
<%@page import="DTO.MemberDTO"%>
<%
request.setCharacterEncoding("utf-8"); // 한글 변수 요청시 꼭 사용하기

//memberlist 페이지에서 변수 요청하여 dto 생성자로 dto 객체 만들기
String custno = request.getParameter("custno");
MemberDTO memberDTO = new MemberDTO(
	custno,
	request.getParameter("custname"),
	request.getParameter("phone"),
	request.getParameter("address"),
	request.getParameter("joindate"),
	request.getParameter("grade"),
	request.getParameter("city")
	);

//db 저장
MemberDAO memberDAO = new MemberDAO();
memberDAO.updateMember(memberDTO);
response.sendRedirect("update.jsp?custno="+custno);

%>