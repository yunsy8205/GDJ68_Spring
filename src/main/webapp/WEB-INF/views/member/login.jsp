<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootstrap.jsp"></c:import>
<c:import url="../temp/header.jsp"></c:import>
</head>
<body>
<section class="container mt-5">
	<h1 class="text-center my-3">Login</h1>
	<form action="./login.do" method="post" class="mx-5 mt-5">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" class="form-control"><br>
	<label for="pw">비밀번호</label>
	<input type="password" name="pw" id="pw" class="form-control"><br>
	
	<button class="mt-5 btn btn-primary">로그인</button>		
	</form>

</section>	
</body>
</html>