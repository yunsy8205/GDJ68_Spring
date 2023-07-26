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
		<h1 class="mb-3 text-center">NOTICE</h1>
		<table class="table">
			<thead class="table-dark">
				<th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th>
			</thead>
			<tbody class="table-light">
				<c:forEach items="${list}" var="d" varStatus="i">
				<!--list의 크기만큼 반복실행 / d는 변수명 여기서는 전달된 DTO객체 이다.-->
					<tr class="table-light">
						<td>${d.num}</td>
						<td><a href="./detail?num=${d.num}" style="text-decoration:none; color:black;">${d.title}</a></td>
						<!--같은 폴더면 같은 위치
						파라미터 : 클라이언트에서 서버로 보내는 데이타 -->
						<td>${d.writer}</td>
						<td>${d.createDate}</td>
						<td>${d.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">

		    <li class="page-item ${pager.pre?'':'disabled'}">
		      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
		</c:forEach>

		    <li class="page-item ${pager.pre?'':'disabled'}">
		      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>

		  </ul>
		</nav><br><br>
	
		<a class="btn btn-outline-danger" href="./add">게시물 등록</a>
	</section>

</body>
</html>