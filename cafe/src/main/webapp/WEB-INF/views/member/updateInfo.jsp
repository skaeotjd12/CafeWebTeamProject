<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="500">
		<c:forEach items="${loginView}" var="dto">
			<form method="post" action="updateInfoOk?mem_id=${dto.mem_id}">
				<tr height="50">
					<td colspan="2" align="center">
						<h1>정보 변경</h1>
						<p>'*'표시 항복은 필수 입력 항목입니다.</p>
					</td>			
				</tr>
				<tr height="30">
					<td width="100" align="center">아이디</td>
					<td align="center">${dto.mem_id}</td>
				</tr>
				<tr height="30">
					<td width="100" align="center">암호</td>
					<td align="center">
						<input type="password" name="mem_pw" size="50" value="${dto.mem_pw}">*
					</td>
				</tr>
				<tr height="30">
					<td width="100" align="center">이름</td>
					<td align="center">
						<input type="text" name="mem_name" size="50" value="${dto.mem_name}">*
					</td>
				</tr>
				<tr height="30">
					<td width="100" align="center">이메일</td>
					<td align="center">
						<input type="text" name="mem_email" size="50" value="${dto.mem_email}">*
					</td>
				</tr>
				<tr height="30" align="center">
					<td width="100">연락처</td>
					<td align="center">
						<input type="text" name="mem_tel" size="50" maxlength="13" value="${dto.mem_tel}">*
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="로그아웃" onclick="location.href='logout'">
					</td>
				</tr>
			</form>
		</c:forEach>
	</table>
</body>
</html>