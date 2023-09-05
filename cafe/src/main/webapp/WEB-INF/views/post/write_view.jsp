<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj = $("form[name='writeForm']");
		
		$(".write_btn").on("click", function(){
			if(fn_valiChk()){
				return false;
			}
		
			formObj.attr("action", "write");
			formObj.attr("method", "post");
			formObj.submit();
		});
	});
	
	function fn_valiChk(){
		var regForm = $("form[name='writeForm'] .chk").length;
		for(var i = 0; i<regForm; i++){
			if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
				alert($(".chk").eq(i).attr("title"));
				return true;
			}
		}
	}
</script>
<body>
	<form name="writeForm" method="post" action="write" enctype="multipart/form-data">
	<div>
		<a href="list">목록</a>
	</div>
	<div>
		<table>
			<input type="hidden" name="post_writer" value="${mem_id}">
			<tr>
				<td>제목</td>
				<td><input type="text" name="post_title" size="50" class="chk" title="제목을 입력하세요"> </td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="post_content" class="chk" title="내용을 입력하세요"></textarea></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력" class="write_btn"> </td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>