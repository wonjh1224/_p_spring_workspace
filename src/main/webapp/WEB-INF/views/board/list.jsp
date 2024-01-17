
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
a {
	text-decoration: none;
}
</style>

<jsp:include page="../layout/header.jsp"></jsp:include>
<br>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">조회수</th>
			<th scope="col">등록일</th>
		</tr>
	</thead>
	<c:forEach items="${list }" var="bvo">
		<tr>
			<th scope="row">${bvo.bno }</th>
			<td><a href="/board/detail/${bvo.bno }">${bvo.title } </a></td>
			<td>${bvo.writer }</td>
			<td>${bvo.readCount }</td>
			<td>${bvo.regAt }</td>
		</tr>
	</c:forEach>
	</tbody>

</table>

<!-- 페이지네이션 -->
<div style="margin: 0 auto; width: 700px;">
	<nav aria-label="Page navigation example">
		<ul class="pagination">

			<!-- 이전 -->
			<li class="page-item ${(ph.prev eq false)? 'disabled' : ''}"><a
				class="page-link" href="/board/list?pageNo=${ph.startPage-1 }"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>

			<!-- 페이지 번호 -->
			<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
				<li class="page-item ${ph.pgvo.pageNo == i ? 'active' : '' }"><a
					class="page-link" href="/board/list?pageNo=${i }">
					${i }</a></li>
			</c:forEach>

			<!-- 다음 -->
			<li class="page-item ${(ph.next eq false)? 'disabled' : ''}"><a
				class="page-link" href="/board/list?pageNo=${ph.endPage+1 }"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>

			<li class="page-item"><a class="page-link" href="/board/list">전체보기</a></li>

		</ul>
	</nav>
</div>

<script type="text/javascript">
const isDel = `<c:out value = "${isDel}"/>`
if(isDel == 1){
	alert("게시물 삭제 성공");
}
</script>








<jsp:include page="../layout/footer.jsp"></jsp:include>