<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var formObj = $("form[name='modifyForm']");
		
		$(".modify_btn").on("click", function(){
			if(fn_valiChk()){
				return false;
			}
			formObj.attr("action", "modify");
			formObj.attr("method", "post");
			formObj.submit();
		});
		
		$(".cancel_btn").on("click", function(){
			event.preventDefault();
			location.href = "list?post_no=${modify_view.post_no}"
				   + "&page=${scri.page}"
				   + "&perPageNum=${scri.perPageNum}"
				   + "&searchType=${scri.searchType}"
				   + "&keyword=${scri.keyword}";
		});
		
	});
		
	function fn_valiChk(){
		var updateForm = $("form[name='modifyForm'] .chk").length;
		for(var i = 0; i<updateForm; i++){
			if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
				alert($(".chk").eq(i).attr("title"));
				return true;
			}
		}
	}
</script>
</head>
<body>
	<form name="modifyForm" method="post" action="post/modify">
		<input type="hidden" name="post_no" value="${modify_view.post_no }">
		<div>
			<a href="list">목록</a>
		</div>
		<div>
			<table>
				<tr>
					<td>작성자</td>
					<td>${modify_view.post_writer }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name=post_title value="${modify_view.post_title }" class="chk" title="제목을 입력하세요">
					</td>
					<td>조회수</td>
					<td>${modify_view.post_hit }</td>
					<td><button type="button" onclick="">신고</button></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate value="${modify_view.post_regdate }" pattern="yyyy.MM.dd hh:mm:ss"/></td>
					<td>수정일</td>
					<td><fmt:formatDate value="${modify_view.post_moddate }" pattern="yyyy.MM.dd hh:mm:ss"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="5" name="post_content" class="chk" title="내용을 입력하세요">${modify_view.post_content }</textarea>
					</td>
				</tr>
				<tr>
					<td>좋아요</td>
					<td>${modify_view.post_like }</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="저장" class="modify_btn">
						<input type="button" value="취소" class="cancel_btn">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>