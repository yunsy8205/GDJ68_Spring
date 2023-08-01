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
		<h1 class="mb-3 text-center">${board} List</h1>
		<table class="table">
			<thead class="table-dark">
				<th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th>
			</thead>
			<tbody class="table-light">
				<c:forEach items="${requestScope.list}" var="d" varStatus="i">
				<!--list의 크기만큼 반복실행 / d는 변수명 여기서는 전달된 DTO객체 이다.-->
					<tr class="table-light">
						<td>${d.num}</td>
						
						<td><a href="./detail?num=${d.num}" style="text-decoration:none; color:black;">
						<c:catch>
						<c:forEach begin="1" end="${d.depth}">--</c:forEach>
						</c:catch>
						${d.subject}</a></td>
					
						<td>${d.name}</td>
						<td>${d.createDate}</td>
						<td>${d.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">

		    <li class="page-item ${pager.pre?'':'disabled'}">
		      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
		</c:forEach>
			<c:if test="${pager.next}">
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
			</c:if>
		  </ul>
		</nav>
		
		<div class="input-group mb-3">
		<form action="./list" method="get">
		  <select name="kind" class="form-select" aria-label="Default select example">
			  <option value="title">Title</option>
			  <option value="name">Name</option>
			  <option value="contents">Contents</option>
		  </select>
		  <input type="text" name="search" class="form-control" aria-label="Amount (to the nearest dollar)">
		  <div class="col-auto">
		  	<button type="submit" class="btn btn-primary mb-3">검색</button>
		  </div>
		  </form>
		</div>
		<c:if test ="${not empty member}">
			<a class="btn btn-outline-danger" href="./add">게시물 등록</a>
		</c:if>
	</section>

</body>
</html>