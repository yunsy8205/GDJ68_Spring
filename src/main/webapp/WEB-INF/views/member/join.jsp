<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:import url="../temp/bootstrap.jsp"></c:import>
<style>
	.f{
		color:red;
	}

	.s{
		color: blue;
	}
</style>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
<section class="container mt-5">
	<h1 class="text-center my-3">Join</h1>
	<form action="./join" id="frm" method="post" class="mx-5 mt-5" enctype="multipart/form-data">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" class="form-control"><br>
		<div id="out"></div>
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" id="pw" class="form-control"><br>
		<div id="out2"></div>
		<label for="pw">비밀번호</label>
		<input type="password" name="pw2" id="pw2" class="form-control"><br>
		<div id="out3"></div>
		<label for="name">이름</label>
		<input type="text" name="name" id="name" class="form-control"><br>
		<div id="out4"></div>
		<label for="email">e-mail</label>
		<input type="email" name="email" id="email" class="form-control"><br>
		<div id="out5"></div>
		<label for="birth">생년월일</label>
		<input type="date" name="birth" id="birth" class="form-control"><br>
		<div id="out6"></div>
		<label for="pic">사진첨부</label>
		<input type="file" name="pic" id="pic" class="form-control"><br>
		
		<button type="button" id="btn" class="mt-5 btn btn-primary">회원가입</button>
		
	</form>
</section>
<script src="/resources/js/member.js"></script>
</body>
</html>