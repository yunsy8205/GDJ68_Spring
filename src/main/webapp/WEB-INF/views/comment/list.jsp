<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:import url="../temp/bootstrap.jsp"></c:import>
	<section class="container mt-5">

		<table>
				<!-- 내부에 있으면 이상하므로 <div style="display:none;">${pager.totalPage}</div> -->
				<c:forEach items="${requestScope.list}" var="d" varStatus="i">
				<!--list의 크기만큼 반복실행 / d는 변수명 여기서는 전달된 DTO객체 이다.-->
					<c:choose>
						<c:when test="${i.first}">
							<tr id="totalpage" data-totalPage="${pager.totalPage}">
						</c:when>
						<c:otherwise>
							<tr>
						</c:otherwise>
					</c:choose>
						<td>${d.id}</td>
						<td>${d.contents}</td>
						<td>${d.commentDate}</td>
					</tr>
				</c:forEach>
		</table>

		
	</section>

