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
<!-- 관리자가 보는 회원 정보 페이지 -->
	<table border="1" align="center" width="900">
		<caption><b>회원관리</b></caption>
		<tr>
			<th width="75" align="center">아이디</th>
			<th width="75" align="center">이름</th>
			<th width="150" align="center">이메일</th>
			<th width="150" align="center">연락처</th>
			<th width="200" align="center">가입일</th>
			<th width="75" align="center">경과일</th>
			<th width="50" align="center">등급</th>
			<th width="100" align="center">게시글수</th>
			<th width="80" align="center">등업</th>
			<th width="50" align="center">강퇴</th>
		</tr>
		<c:forEach items="${MemberView}" var="dto">
			<tr>
				<td align="center"> ${dto.mem_id}</td> 
				<td align="center"> ${dto.mem_name}</td> 
				<td align="center"> ${dto.mem_email}</td> 
				<td align="center"> ${dto.mem_tel}</td> 
				<td align="center"> ${dto.mem_regdate} </td> 
				<td align="center"> ${dto.mem_days}</td>
				<td align="center"> LV. ${dto.mem_level}</td>
				<td align="center"> ${dto.mem_post}</td>
				
				<td align="center">
					<!-- 회원레벨이 2이면 등급을 올릴수있게, 회원레벨이 3이면 등급을 내릴 수 있게 -->
					<c:if test="${dto.mem_level eq 2}">
						<input type="button" value="↑" onclick="location.href='levelUp_admin?mem_id=${dto.mem_id }'">
					</c:if>
					<c:if test="${dto.mem_level eq 3}">
						<input type="button" value="↓" onclick="location.href='levelDown_admin?mem_id=${dto.mem_id }'">
					</c:if>
				</td>
				<td align="center">
					<!-- 관리자의 경우엔 관리자 개인정보확인페이지가 나오게, 관리자를 제외한 회원은 강제삭제처리가능하게 -->
					<c:if test="${dto.mem_level eq 0}">
						<button onclick="location.href='checkInfo?mem_id=${dto.mem_id}'">check</button>
					</c:if>
					<c:if test="${dto.mem_level ne 0}">
						<button onclick="location.href='deleteMember?mem_id=${dto.mem_id}'">∨</button>
					</c:if>
				</td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>