<%@page import="java.util.List"%>
<%@page import="com.multicampus.biz.board.BoardDAOJdbc"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	// 1. DB 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAOJdbc dao = new BoardDAOJdbc();
	List<BoardVO> boardList = dao.getBoardList(vo);
	
	// 2. 응답 화면 구성
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
	<h1>게시글 목록</h1>
	<a href="logout_proc.jsp">LOGOUT</a>
	<hr>
	
	<table border="1" cellpadding="0" cellspacing="0" width="800">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="300">제목</th>
			<th bgcolor="orange" width="150">작성자</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
		<% for(BoardVO board : boardList){ %>
		<tr>
			<td><%= board.getSeq() %></td>
			<td><a href="getBoard.jsp?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
			<td><%= board.getWriter() %></td>
			<td><%= board.getRegDate() %></td>
			<td><%= board.getCnt() %></td>
		</tr>
		<%} %>
	</table>
	<hr>
	<br>
	<a href="insertBoard.jsp">글 등록 화면으로 이동</a>
</center>
</body>
</html>