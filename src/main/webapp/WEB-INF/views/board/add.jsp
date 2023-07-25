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

	<h1 class="text-center mt-5 mb-3 ms-3">Add Page</h1>
	
	<form action="./add" method="post" class="mx-3">
		제목<input type="text" name="title" class="form-control"><br>
		작성자<input type="text" name="writer" class="form-control"><br>
		내용 <textarea rows="" cols="" name="contents" class="form-control"></textarea><br>

		<button class="btn btn-outline-danger">등록</button> <!-- 버튼도 타입이 있음 기본은 서브밋 -->
		<input class="btn btn-outline-danger" type="reset" value="reset">

	</form>

</body>
</html>