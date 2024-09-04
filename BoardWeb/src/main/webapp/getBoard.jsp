<%@page import="com.multicampus.biz.board.BoardDAOJdbc"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//1. 사용자 입력정보 추출
	String seq = request.getParameter("seq");

	//2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAOJdbc dao = new BoardDAOJdbc();
	BoardVO board = dao.getBoard(vo);
	
	//3. 조회수 업데이트 화면 구성
	BoardVO vo2 = new BoardVO();
	vo2.setSeq(Integer.parseInt(seq));
	vo2.setCnt(board.getCnt()+1);
	dao.updateCnt(vo2);
	board.setCnt(board.getCnt()+1);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
	<h1>게시글 상세</h1>
	<hr>
	
	<form action="updateBoard_proc.jsp" method="get">
	<input name="seq" type="hidden" value="<%= board.getSeq()%>"/>
	<table border="1" cellpadding="0" cellspacing="0" width="500">
		<tr>
			<td bgcolor="orange" width="150">제목</td>
			<td><input name="title" type="text" size="40" value="<%= board.getTitle()%>"/></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="150">작성자</td>
			<td><input name="writer" type="text" value="<%= board.getWriter() %>" disabled/></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="150">내용</td>
			<td><textarea name="content" cols="50" rows="10"><%= board.getContent() %></textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="150">등록일</td>
			<td><input name="writer" type="text" value="<%= board.getRegDate() %>" disabled/></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="150">조회수</td>
			<td><input name="writer" type="text" value="<%= board.getCnt() %>" disabled/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글 수정"/>
			</td>
		</tr>
	</table>
	</form>
	<hr>
	<br>
	<a href="getBoardList.jsp">게시글 목록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq()%>">게시글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="insertBoard.jsp">게시글 등록</a>&nbsp;&nbsp;&nbsp;
</center>
</body>
</html>