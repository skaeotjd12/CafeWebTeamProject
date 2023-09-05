<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${mem_id eq null}">
				<%@include file="member/login.jsp" %>
			</c:when>
			<c:otherwise>
				<%@include file="member/login_ok.jsp" %>
			</c:otherwise>
		</c:choose>
	</header>
	
	<section>
		<%@include file="post/list.jsp" %>
	</section>
</body>
</html>
