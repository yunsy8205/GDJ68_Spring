
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
				<td>${notice.subject}</td>
	
			</tr>
			<tr>
				<th class="table-dark">NO</th>
				<td>${notice.num}</td>
			</tr>
			<tr>
				<th class="table-dark">NAME</th>
				<td>${notice.name}</td>
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

		<c:forEach items="${notice.fileDTOs}" var="f">
			<img alt="" src="../../resources/upload/${board}/${f.fileName}">
		</c:forEach>
		
		<form id="frm">
			<input type="hidden" name="num" value="${notice.num}">
			<!-- <button id="del" data-delete-name="num" data-delete-num="${notice.num}">삭제</button> -->
			<button data-url="delete" class="c1" id="del">삭제</button>
			<!-- <a class="btn btn-outline-danger" href="./update?num=${notice.num}">수정</a> -->
			<button data-url="update" class="c1" id="update">수정</button>
			<c:if test="${board ne 'notice'}">
				<!-- <a class="btn btn-outline-danger" href="./reply?num=${notice.num}">답글</a> -->
				<button data-url="reply" class="c1" id="reply">답글</button>
			</c:if><!-- 서브릿으로 이동 -->
		</form>
		
		<div id ="comment">
		
		</div>
	</section>
	<script src="../resources/js/delete.js"></script>
	
</body>
</html>