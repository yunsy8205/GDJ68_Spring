<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<c:import url="../temp/bootstrap.jsp"></c:import>
<c:import url="../temp/header.jsp"></c:import>
</head>
<body>
<section class="container mt-5">
	<h1 class="text-center my-3">회원 수정</h1>
	<form action="./memberUpdate"  method="post" class="mx-5 mt-5">

		<label for="pw">비밀번호</label>
		<input type="password" value="${member.pw}" name="pw" id="pw" class="form-control"><br>
		<label for="name">이름</label>
		<input type="text" value="${member.name}" name="name" id="name" class="form-control"><br>
		<label for="email">e-mail</label>
		<input type="email" value="${member.email}" name="email" id="email" class="form-control"><br>
		<label for="birth">생년월일</label>
		<input type="date" value="${member.birth}" name="birth" id="birth" class="form-control"><br>
		
		<button class="mt-5 btn btn-primary">수정</button>
		
	</form>
</section>
</body>
</html>