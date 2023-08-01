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

	<h1 class="text-center mt-5 mb-3 ms-3">답글</h1>
	
	<form action="./reply" method="post" class="mx-3" enctype="multipart/form-data">
		제목<input type="text" name="subject" class="form-control"><br>
		<input type="hidden" name="name" value="${sessionScope.member.id}" class="form-control">
		<input type="hidden" name="num" value="${num}" class="form-control">
		내용 <textarea rows="" cols="" name="contents" class="form-control"></textarea><br>

		<div>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		</div>
		
		<button class="btn btn-outline-danger">등록</button> <!-- 버튼도 타입이 있음 기본은 서브밋 -->
		<input class="btn btn-outline-danger" type="reset" value="reset">
	</form>

</body>
</html>