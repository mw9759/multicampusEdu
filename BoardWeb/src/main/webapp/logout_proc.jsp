<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료한다.
	session.invalidate();

	// 화면이동
	response.sendRedirect("/");
	
%>