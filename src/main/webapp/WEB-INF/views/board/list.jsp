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
		      <a class="page-link move" href="" data-num="${pager.startNum-1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
		</c:forEach>
			<c:if test="${pager.next}">
		    <li class="page-item">
		      <a class="page-link move" href="" data-num="${pager.lastNum+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
			</c:if>
		  </ul>
		</nav>
		
		<div class="input-group mb-3">
		<form action="./list" method="get" id="frm">
			<input type="hidden" value="${pager.page}" id="page" name="page">
			<!-- page 추가 -->
		  <select name="kind" class="form-select" id="k" data-kind="${pager.kind}" aria-label="Default select example">
			  <option class="kind" value="title">Title</option>
			  <option class="kind" value="name">Name</option>
			  <option class="kind" value="contents">Contents</option>
		  </select>
		  <input type="text" name="search" value="${pager.search}" class="form-control" aria-label="Amount (to the nearest dollar)">
		  <div class="col-auto">
		  	<button type="submit" class="btn btn-primary mb-3">검색</button>
		  </div>
		  </form>
		</div>
		<c:if test ="${not empty member}">
			<a class="btn btn-outline-danger" href="./add">게시물 등록</a>
		</c:if>
	</section>
	<script src="/resources/js/list.js"></script>
	<!-- <script>
		setData('${pager.kind}'); 
		//홑따옴표나 쌍따옴표를 넣어줘야 문자열로 인식 아님 변수로 인식
		//숫자는 그냥 넣어도됨
	</script> -->
	<!-- 절대경로 -->

</body>
</html>