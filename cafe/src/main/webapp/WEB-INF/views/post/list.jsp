<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
	li {list-style: none; float: left; padding: 6px;}
</style>
</head>
<body>
	<c:if test="${empty mem_id}">
		<a href="../member/login">로그인</a>
		<a href="../member/register">회원가입</a>
	</c:if>
	<c:if test="${not empty mem_id}">
		<p>Lv.${mem_level}&nbsp;&nbsp;&nbsp;${mem_id}님 반갑습니다.</p>
		<a href="write_view">글쓰기</a>
		<a href="../member/checkInfo?mem_id=${mem_id}">정보확인</a>
		<a href="../member/logout">로그아웃</a>
	</c:if>
	<form role="form" method="get">
	<div class="container">
		<div class="wrap">
			<table>
				<thead>
					<tr>
						<td>번호</td>
						<td>작성자</td>
						<td>제목</td>
						<td>조회수</td>
						<td>좋아요</td>
						<td>작성일</td>
					</tr>
				</thead>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.post_no}</td>
						<td>${dto.post_writer }</td>
						<td>
							<a href="content_view?post_no=${dto.post_no}
											&page=${scri.page}
											&perPageNum=${scri.perPageNum}
											&searchType=${scri.searchType}
											&keyword=${scri.keyword}
											&mem_id=${mem_id}">
								${dto.post_title }
							</a>
							<c:if test="${dto.reply_count ne 0}">
							<small><b>[&nbsp;${dto.reply_count}&nbsp;]</b></small>
							</c:if>
						</td>
						<td>${dto.post_hit }</td>
						<td>${dto.post_like }</td>
						<td><fmt:formatDate value="${dto.post_regdate }" pattern="yyyy.MM.dd"/></td>
					</tr>
				</c:forEach>
			</table>
			<div class="searchBox">
			    <select name="searchType">
				    <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
				    <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
				    <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
				    <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
			    </select>
			    
			    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
			    
			    <button id="searchBtn" type="button">검색</button>
			    <script>
			      $(function(){
			        $('#searchBtn').click(function() {
			          self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
			        });
			      });   
			    </script>
			</div>
			<div>
				<ul>
					<c:if test="${pageMaker.prev }">
						<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">이전</a></li>
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li><a href="list${pageMaker.makeSearch(idx) }">${idx }</a></li>
					</c:forEach>
					
					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1) }">다음</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	</form>
</body>
</html>