
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
		<h1 class="text-center mt-5 mb-3 ms-3">DETAIL</h1>
		<!-- requestScope는 생략가능 (같은 이름을 가진경우 안될 수도 있다.)-->
		<table class="table my-5">
			<tr>
				<th class="table-dark">TITLE</th>
				<td>${notice.title}</td>
	
			</tr>
			<tr>
				<th class="table-dark">NO</th>
				<td>${notice.num}</td>
			</tr>
			<tr>
				<th class="table-dark">NAME</th>
				<td>${notice.writer}</td>
			</tr>
			<tr>
				<th class="table-dark">CONTENTS</th>
				<td>${notice.contents}</td>
			</tr>
			<tr>
				<th class="table-dark">DATE</th>
				<td>${notice.createDate}</td>
			</tr>
			<tr>
				<th class="table-dark">HIT</th>
				<td>${notice.hit}</td>
			</tr>
		</table>
		<a class="btn btn-outline-danger" href="./update?num=${notice.num}">수정</a>
		<a class="btn btn-outline-danger" href="./delete?num=${notice.num}">삭제</a>
		<!-- 서브릿으로 이동 -->
	</section>
	
</body>
</html>