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
<!-- 회원이 보는 개인정보페이지 -->
	<c:forEach items="${loginView}" var="dto">
	<center><jsp:include page="login_ok.jsp?mem_id=${dto.mem_id}"/></center>
		<table border="1" align="center" width="500">
			<form method="post" action="updateInfo?mem_id=${dto.mem_id}">
				<tr height="50">
					<td colspan="2" align="center">
						<h1>정보 확인</h1>
						<p>${dto.mem_name}님의 정보입니다.</p>
						
					</td>			
				</tr>
				<tr height="30">
					<td width="80" align="center">아이디</td>
					<td align="center">${dto.mem_id}</td>
				</tr>
				<tr height="30">
					<td width="80" align="center">암호</td>
					<td align="center">${dto.mem_pw}</td>
				</tr>
				<tr height="30">
					<td width="80" align="center">이름</td>
					<td align="center">${dto.mem_name}</td>
				</tr>
				<tr height="30">
					<td width="80" align="center">이메일</td>
					<td align="center">${dto.mem_email}</td>
				</tr>
				<tr height="30">
					<td width="80" align="center">연락처</td>
					<td align="center">${dto.mem_tel}</td>
				</tr>
				<tr>
					<td width="80" align="center">가입일</td>
					<td align="center">${dto.mem_regdate}</td>
				</tr>
				<tr>
					<td width="80" align="center">회원등급</td>
					<td align="center">LEVEL. ${dto.mem_level}</td>
				</tr>
				<tr>
					<td width="80" align="center">가입일수</td>
					<td align="center">${dto.mem_days}일</td>
				</tr>
				<tr>
					<td width="80" align="center">게시글수</td>
					<td align="center">${dto.mem_post}</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="정보수정">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="로그아웃" onclick="location.href='logout'">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="회원탈퇴" onclick="location.href='deleteMember?mem_id=${dto.mem_id}'">
					</td>
				</tr>
			</form>
		</table>
	</c:forEach>
</body>
</html>