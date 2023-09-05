<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<form action="loginYn" method="post">
			<tr height="30">
				<td width="100" align="center">사용자 ID</td>
				<td>
					<input type="text" name="mem_id" size="30">
				</td>
			</tr>
			<tr height="30">
				<td width="100" align="center">비밀번호</td>
				<td>
					<input type="password" name="mem_pw" size="32">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="회원가입" onclick="location.href='register'"> 
				</td>
			</tr>
		</form>
	</table>
</body>
</html>