<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center"  width="500">
		<form method="post" action="registerOk">
			<tr height="50">
				<td colspan="2" align="center">
					<h1>회원 가입 신청</h1>
					<p>'*'표시 항복은 필수 입력 항목입니다.</p>
				</td>			
			</tr>
			<tr height="30">
				<td width="100">아이디</td>
				<td>
					<input type="text" name="mem_id" size="50">*
				</td>
			</tr>
			<tr height="30">
				<td width="100">암호</td>
				<td>
					<input type="password" name="mem_pw" size="50">*
				</td>
			</tr>
			<tr height="30">
				<td width="100">이름</td>
				<td>
					<input type="text" name="mem_name" size="50">*
				</td>
			</tr>
			<tr height="30">
				<td width="100">이메일</td>
				<td>
					<input type="text" name="mem_email" size="50">*
				</td>
			</tr>
			<tr height="30">
				<td width="100">연락처</td>
				<td>
					<input type="tel" name="mem_tel" size="50" maxlength="13">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="로그인" onclick="location.href='login'">
				</td>
			</tr>
		</form>
	</table>
	
</body>
</html>