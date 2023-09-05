<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						var formObj = $("form[name='readForm']");

						// 수정 
						$(".update_btn").on("click", function() {
							formObj.attr("action", "modify_view");
							formObj.attr("method", "get");
							formObj.submit();
						});

						// 삭제
						$(".delete_btn").on("click", function() {
							var deleteYN = confirm("삭제하시겠습니까?");

							if (deleteYN == true) {
								formObj.attr("action", "delete");
								formObj.attr("method", "post");
								formObj.submit();
							}

						});

						// 목록
						$(".list_btn")
								.on(
										"click",
										function() {
											location.href = "list?page=${scri.page}"
													+ "&perPageNum=${scri.perPageNum}"
													+ "&searchType=${scri.searchType}&keyword=${scri.keyword}";
										});

					});

	/*댓글 js*/
	$(function() {
		$(".addReply_btn").on("click", function() {
			if ($("input[name='mem_id']").val() == "") {
				alert("로그인을 해주세요.");
				$("input[name='mem_id']").focus();
				return false;
			}
			if ($("textarea[name='reply_content']").val() == "") {
				alert("내용을 써주세요.");
				return false;
			}
			$(".checkFrm").submit();
			return false;
		});
		$(".addreReply_btn").on("click", function() {
			if ("input[name='mem_id']" == "") {
				alert("로그인을 해주세요.");
				return false;
			}
			if ($("textarea[name='reply_content']").val() == "") {
				alert("내용을 써주세요.");
				$("input[name='reply_content']").focus();
				return false;
			}
			$(".reReply${replydto.reply_no}").submit();
			return false;
		});

		/*
		
		jstl javascript 혼용어려워 body 안으로 작성
		
		 */
	});
</script>
<style>
.reReplyChild {
	background: #DCDCDC;
	margin-left: 50px;
}

.reReplyParent {
	background: antiquewhite;
	font-size: 20px;
}
</style>
<body>
	<div>
		<button class="list_btn">목록</button>
	</div>
	<div>
		<form name="readForm" role="form" method="post">
			<input type="hidden" id="post_no" name="post_no" value="${content_view.post_no}" /> <input type="hidden" id="page" name="page" value="${scri.page}"> <input type="hidden" id="perPageNum"
				name="perPageNum" value="${scri.perPageNum}"> <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> <input type="hidden" id="keyword" name="keyword"
				value="${scri.keyword}">
		</form>
		<table>

			<tr>
				<td>작성자</td>
				<td>${content_view.post_writer }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${content_view.post_title }</td>
				<td>조회수</td>
				<td>${content_view.post_hit }</td>
				<td><button type="button" onclick="">신고</button></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${content_view.post_regdate }" pattern="yyyy.MM.dd" /></td>
				<td>수정일</td>
				<td><fmt:formatDate value="${content_view.post_moddate }" pattern="yyyy.MM.dd" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${content_view.post_content }</td>
			</tr>
			<tr>
				<td>좋아요</td>
				<td>${content_view.post_like }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><c:if test="${content_view.file_name ne null}">
						<a href="download_file?post_no=${content_view.post_no}&file_name=${content_view.file_name}">${content_view.file_name }</a>
						${content_view.file_name }
						(${content_view.file_size }KB)
					</c:if></td>
			</tr>
			<c:if test="${not empty mem_id && mem_id eq content_view.post_writer}">
				<tr>
					<td colspan="2">
						<button type="submit" class="update_btn">수정</button>
						<button type="submit" class="delete_btn">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- 댓글 등록 폼 -->
	<h2 align="center">댓글 등록</h2>
	<div>
		<table align="center">
			<form action="addReply" method="post" class="checkFrm">
				<input type="hidden" name="post_no" value="${content_view.post_no}"> <input type="hidden" name="mem_id" value="${mem_id}">
				<tr>
					<td><textarea style="width: 800px" rows="3" cols="30" name="reply_content" placeholder="댓글을 입력하세요"></textarea></td>
				</tr>
				<tr>
					<td>
						<button class="addReply_btn">등록</button>
					</td>
				</tr>
			</form>
		</table>
	</div>
	<!-- 댓글 리스트 -->
	<h2>댓글 목록</h2>
	<hr>

	<c:forEach items="${replyList}" var="replydto">

		<script>
			/*
			
			jstl javascript 혼용어려워 body 안으로 작성
			
			 */
			$(function() {
				var reReplyForm = $('<form></form>');
				reReplyForm.attr("name", "reReplyForm");
				reReplyForm.append($('<textarea/>', {
					name : 'reply_content'
				}));
				reReplyForm.append($('<input/>', {
					type : 'hidden',
					name : 'post_no',
					value : '${content_view.post_no}'
				}));
				reReplyForm.append($('<input/>', {
					type : 'hidden',
					name : 'mem_id',
					value : '${mem_id}'
				}));
				reReplyForm.append($('<input/>', {
					type : 'hidden',
					name : 'reply_no',
					value : '${replydto.reply_no}'
				}));
				reReplyForm.append($('<input/>', {
					id : '${replydto.reply_no}',
					type : 'hidden',
					name : 'reply_depth',
					value : 1
				}));
				reReplyForm.append($('<input/>', {
					type : 'submit',
					value : '등록'
				}));

				$(".btn2${replydto.reply_no}").hide();
				$(".btn3${replydto.reply_no}").hide();

				var a = false;
				var b = false;

				$(".reReply${replydto.reply_no}").on("click", function() {
					if (b == true) {
						alert("수정과 동시에 불가합니다.")
						return;
					}
					reReplyForm.attr("method", "post");
					reReplyForm.attr("action", "addreReply");
					$(this).parent().parent().after(reReplyForm);
					$(".reReply${replydto.reply_no}").hide();
					$(".btn2${replydto.reply_no}").show();
					a = true;
				});
				$(".btn2${replydto.reply_no}").on("click", function() {
					$(this).parent().parent().next("form").remove();
					$(".btn2${replydto.reply_no}").hide();
					$(".reReply${replydto.reply_no}").show();
					a = false;
				});
				$(".update${replydto.reply_no}").on("click", function() {
					if (a == true) {
						alert("답변 달기와 동시에 불가합니다.")
						return;
					}
					reReplyForm.attr("method", "post");
					reReplyForm.attr("action", "updateReply");
					$(this).parent().parent().after(reReplyForm);
					$(".update${replydto.reply_no}").hide();
					$(".btn3${replydto.reply_no}").show();
					b = true;

				});

				$(".btn3${replydto.reply_no}").on("click", function() {
					$(this).parent().parent().next("form").remove();
					$(".btn3${replydto.reply_no}").hide();
					$(".update${replydto.reply_no}").show();
					b = false;
				});

				$(".delete${replydto.reply_no}")
						.on(
								"click",
								function() {
									var deleteYn = confirm("삭제하시겠습니까?");

									if (deleteYn == true) {
										location.href = "deleteReply?reply_no=${replydto.reply_no}"
												+ "&reply_parent=${replydt.reply_parent}"
												+ "&reply_depth=${replydto.reply_depth}"
												+ "&post_no=${content_view.post_no}";
									}
								});
			});
		</script>

		<!-- 부모 댓글 -->
		<div class="reReplyParent">
			<c:if test="${replydto.reply_depth ne 1}">
				<p>
					작성자&nbsp;&nbsp;&nbsp;&nbsp;<strong>${replydto.mem_id}</strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:formatDate value="${replydto.reply_regdate}" pattern="yyyy.MM.dd" />
				</p>
				<pre>${replydto.reply_content}</pre>

				<p>
					<button class="reReply${replydto.reply_no}" type="button">답글</button>
					<button class="btn2${replydto.reply_no}" type="button">감추기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${replydto.mem_id eq mem_id}">
						<button class="update${replydto.reply_no}" type="button">수정</button>
						<button class="btn3${replydto.reply_no}" type="button">감추기</button>&nbsp;&nbsp;&nbsp;&nbsp;
					    <button class="delete${replydto.reply_no}">삭제</button>&nbsp;&nbsp;&nbsp;&nbsp;					    	
					</c:if>
				</p>
				<hr>
			</c:if>
		</div>


		<!-- 자식 댓글 -->
		<div class="reReplyChild">
			<c:if test="${replydto.reply_depth eq 1}">
				<b>→ @${replydto.reply_writer}</b>
				<p>
					작성자&nbsp;&nbsp;<b>${replydto.mem_id}</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:formatDate value="${replydto.reply_regdate}" pattern="yyyy.MM.dd" />
				</p>
				<pre>${replydto.reply_content}</pre>
				<p>
					<c:if test="${replydto.mem_id eq mem_id}">
						<button class="update${replydto.reply_no}" type="button">수정</button>
						<button class="btn3${replydto.reply_no}" type="button">감추기</button>&nbsp;&nbsp;&nbsp;&nbsp;
				    <button class="delete${replydto.reply_no}">삭제</button>
					</c:if>
				</p>
				<hr>
			</c:if>
		</div>
	</c:forEach>
</body>
</html>