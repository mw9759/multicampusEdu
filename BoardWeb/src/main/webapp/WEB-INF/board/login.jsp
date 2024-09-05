<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<center>
	<h1><spring:message code="user.login.mainTitle"/></h1>
	<a href="login.do?lang=en">English</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="login.do?lang=kr">한글</a>
	<hr>
	
	<form action="login.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="400">
		<tr>
			<td bgcolor="orange" width="150"><spring:message code="user.login.id"/></td>
			<td><input name="id" type="text" value="${user.id }"/></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="150"><spring:message code="user.login.password"/></td>
			<td><input name="password" type="password" value="${user.password }"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="<spring:message code="user.login.loginBtn"/>"/>
			</td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>