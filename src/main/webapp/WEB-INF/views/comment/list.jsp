<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:import url="../temp/bootstrap.jsp"></c:import>
	<section class="container mt-5">
		<h1 class="mb-3 text-center">댓글</h1>
		<!-- <table class="table"> -->
			<!-- <thead class="table-dark">
				<th>ID</th><th>COMMENT</th><th>DATE</th>
			</thead> -->
			<tbody class="table-light">
				<c:forEach items="${requestScope.list}" var="d" varStatus="i">
				<!--list의 크기만큼 반복실행 / d는 변수명 여기서는 전달된 DTO객체 이다.-->
					<tr class="table-light">
						<td>${d.id}</td>
						<td>${d.contents}</td>
						<td>${d.commentDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		<!-- </table> -->
		
<!-- 		<nav aria-label="Page navigation example">
		  <ul class="pagination">

		    <li class="page-item ${pager.pre?'':'disabled'}">
		      <a class="page-link move" href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
		</c:forEach>
			<c:if test="${pager.next}">
		    <li class="page-item">
		      <a class="page-link move" href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
			</c:if>
		  </ul>
		</nav> -->
		
	</section>

