<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../layout/header.jsp"></jsp:include>

<style type="text/css">
a {
	text-decoration: none;
}

input {
	background-color: gray;
}
</style>

<div class="container-md">
	<c:set value="${bvo }" var="bvo" />
	<h2>게시판</h2>
	<br>

	<div class="mb-3">
		<label for="title" class="form-label">bno</label> <input type="text"
			name="title" class="form-control" id="title" placeholder="Title"
			value="${bvo.bno }" readonly="readonly">
	</div>
	<div class="mb-3">
		<label for="title" class="form-label">제목</label> <input type="text"
			name="title" class="form-control" id="title" placeholder="Title"
			value="${bvo.title }" readonly="readonly">
	</div>

	<div class="mb-3">
		<label for="writer" class="form-label">작성자</label> <input type="text"
			name="writer" class="form-control" id="writer" placeholder="Wirter"
			value="${bvo.writer }" readonly="readonly">
	</div>
	<div class="mb-3">
		<label for="content" class="form-label">등록일 </label> <input
			type="text" name="writer" class="form-control" id="writer"
			placeholder="Wirter" value="${bvo.regAt }" readonly="readonly">
	</div>
	<div class="mb-3">
		<label for="readCount" class="form-label">조회수 </label> <input
			type="text" name="readCount" class="form-control" id="readCount"
			placeholder="Wirter" value="${bvo.readCount }" readonly="readonly">
	</div>
	<div class="mb-3">
		<label for="content" class="form-label">내용</label>
		<textarea class="form-control" name="content" id="content" rows="3"
			readonly="readonly">${bvo.content }</textarea>
	</div>

	<!-- 댓글 등록 라인 -->
	<div class="input-group mb-3">
		<span class="input-group-text" id="cmtWriter">tester</span>
		<input type="text" id="cmtText" placeholder="댓글 작성.." class="form-control" 
		aria-label="Recipient's username" aria-describedby="button-addon2">
		<button type="submit" class="btn btn-outline-success" id="cmtAddBtn">등록</button>
	</div>
	
		<!-- 댓글 표시 라인 -->
	<div class="accordion" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseOne"
					aria-expanded="true" aria-controls="collapseOne">cno,
					writer, reg_date</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>댓글</strong>
				</div>
			</div>
		</div>
	</div>


	<br> <a href="/board/list">
		<button type="button" class="btn btn-secondary">List</button>
	</a> <a href="/board/modify/${bvo.bno }">
		<button type="button" class="btn btn-success">수정 페이지로 이동</button>
	</a>
	
	
</div>

<script>
	let bnoVal = `<c:out value="${bvo.bno}"/>`;
</script>

<script type="text/javascript">
	const isMod = `<c:out value = "${isMod}"/>`;
	if (isMod == 1) {
		alert("수정 성공")
	}
</script>



<script type="text/javascript" src="/resources/js/boardComment.js"></script>









<jsp:include page="../layout/footer.jsp"></jsp:include>