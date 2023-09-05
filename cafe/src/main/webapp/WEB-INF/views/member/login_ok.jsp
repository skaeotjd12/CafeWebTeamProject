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
<!-- 로그인확인페이지 -->
	<c:forEach items="${loginView}" var="dto">
		<table border="1" align="center">
		<tr>
			<td>Lv. ${dto.mem_level}&nbsp;&nbsp;${dto.mem_name} 님 반갑습니다.</td>
		</tr>
		<tr>
			<td>
				<!-- 관리자가 로그인하면 회원관리 페이지로 들어갈 버튼이 생성 -->
				<c:if test="${dto.mem_level eq 0}"> 
					<input type="button" value="회원관리" onclick="location.href='memberView'">
				</c:if>
				&nbsp;
				<input type="button" value="정보확인" onclick="location.href='checkInfo?mem_id=${dto.mem_id}'">
				&nbsp;
				<input type="button" value="로그아웃" onclick="location.href='logout'">
			</td>
		</tr>
		</table>
	</c:forEach>
</body>
</html>