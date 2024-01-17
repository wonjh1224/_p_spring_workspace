<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../layout/header.jsp"></jsp:include>

<style type="text/css">
a {
	text-decoration: none;
}
</style>

<form action="/board/modify" method="post">
	<div class="container-md">
		<h2>수정 게시판</h2>
		<br>
		<c:set value="${bvo }" var="bvo" />

		<div class="mb-3">
			<label for="bno" class="form-label">bno</label> <input type="text"
				name="bno" class="form-control" id="title" placeholder="Title"
				value="${bvo.bno }" readonly="readonly" style="background-color: gray;">
		</div>
		
		<div class="mb-3">
			<label for="title" class="form-label">제목</label> <input type="text"
				name="title" class="form-control" id="title" placeholder="Title"
				value="${bvo.title }">
		</div>

		<div class="mb-3">
			<label for="writer" class="form-label">작성자</label> <input type="text"
				name="writer" class="form-control" id="writer" placeholder="Writer"
				value="${bvo.writer }" readonly="readonly" style="background-color: gray;">
		</div>
		<div class="mb-3">
			<label for="regAt" class="form-label">등록일</label>
			<input type="text" name="regAt" class="form-control" id="regAt"
				placeholder="Wirter" value="${bvo.regAt }" readonly="readonly" style="background-color: gray;">
		</div>
		<div class="mb-3">
			<label for="readCount" class="form-label">조회수</label>
			<input type="text" name="readCount" class="form-control" id="readCount"
				placeholder="Wirter" value=" ${bvo.readCount }" readonly="readonly" style="background-color: gray;">
		</div>
		
		<div class="mb-3">
			<label for="content" class="form-label">내용</label>
			<textarea class="form-control" name="content" id="content" rows="3">${bvo.content }</textarea>
		</div>
		
		<a href="/board/list">
			<button type="button" class="btn btn-secondary">List</button>
		</a>

		<button type="submit" class="btn btn-success">modify</button>

		<a href="/board/remove/${bvo.bno }">
			<button type="button" class="btn btn-danger">remove</button>
		</a>
		
		

	</div>
</form>









<jsp:include page="../layout/footer.jsp"></jsp:include>