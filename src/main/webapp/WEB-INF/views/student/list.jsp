<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<sytle>

</sytle>
<c:import url="../temp/bootstrap.jsp"></c:import>
<c:import url="../temp/header.jsp"></c:import>
</head>
<body>

<section class="container mt-5">
	<h1 class="mb-3 text-center">Student List</h1>
	<table class="table table-dark table-striped">
		<thead>
			<th>이름</th><th>점수평균</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto" varStatus="i">
			<!--list의 크기만큼 반복실행 / dto는 변수명 여기서는 전달된 DTO객체 이다.-->
			<tr>
				<td><a href="./detail?studNum=${dto.studNum}">${dto.studName}</a></td>
				<td>${dto.studAvg}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a class="btn btn-danger" href="./add">정보등록</a>
</section>
	
</body>
</html>