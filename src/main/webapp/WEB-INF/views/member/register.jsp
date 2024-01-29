<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/header.jsp"></jsp:include>

<!-- email pwd nick_name -->
<div class="container-md">
	<h2>Register</h2>
	<br>

	<form action="/member/register" method="post" enctype="multipart/form-data">

		email
		<br>
		<div class="mb-3" style="display: flex">
			<label for="email" class="form-label"></label> 
			<input type="text" name="email" class="form-control" id="email"placeholder="example@naver.com">
			
			<input type="hidden" name="email" class="form-control" id="hiddenEmail" placeholder="example@naver.com">
			
			<button type="button" class="btn btn-outline-success" id="checkBtn">check</button>
		</div>
		
		<div class="mb-3">
			<label for="pwd" class="form-label">pwd</label> 
			<input type="password" name="pwd" class="form-control" id="pwd"placeholder="password">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">pwd check</label> 
			<input type="password" name="" class="form-control" id="pwdCheck"placeholder="password">
		</div>
		
		<div class="mb-3">
			<label for="nickName name" class="form-label">nickName</label> 
			<input type="text" name="nickName" class="form-control" id="nickName"placeholder="nickName">
		</div>
		
		<button type="button" class="btn btn-success" id="change" >change</button>
		<button type="submit" class="btn btn-success" id="regBtn" disabled="disabled">Register</button>

	</form>
</div>

<script type="text/javascript" src="/resources/js/memberRegister.js"></script>

<jsp:include page="../layout/footer.jsp"></jsp:include>
