<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<center>
	<h1>회원 로그인</h1>
	<hr>
	
	<form action="login_proc.jsp" method="get">
	<table border="1" cellpadding="0" cellspacing="0" width="400">
		<tr>
			<td bgcolor="orange" width="150">아이디</td>
			<td><input name="id" type="text" value="test"/></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="150">비밀번호</td>
			<td><input name="password" type="password" value="test"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인"/>
			</td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>