<%@page import="DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String m_id = request.getParameter("m_id");
	System.out.print(m_id);
	boolean result =  MemberDAO.getMemberDAO().idcheck(m_id);
	System.out.print(result);
	if( result ){ 
		out.print("1"); 
	}else{ 
		out.print("0"); 
	}
%>