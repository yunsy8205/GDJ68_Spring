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

	<h1 class="mt-5 mb-3 ms-3">Add Page</h1>
	
	<form action="./add" method="post" class="mx-3">

		학생이름<input type="text" name="studName" class="form-control"><br>
		국어점수<input type="text" name="studKor" class="form-control"><br>
		영어점수<input type="text" name="studEng" class="form-control"><br>
		수학점수<input type="text" name="studMath" class="form-control"><br>
		
		<button class="btn btn-danger">등록</button> <!-- 버튼도 타입이 있음 기본은 서브밋 -->
		<input class="btn btn-danger" type="reset" value="reset">

	</form>

</body>
</html>