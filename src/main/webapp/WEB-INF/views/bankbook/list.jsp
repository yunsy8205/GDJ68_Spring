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
		<h1 class="mb-3">BankBook List</h1>
		<table class="table table-dark table-striped">
			<thead>
				<th>상품명</th><th>이자율</th>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d" varStatus="i">
				<!--list의 크기만큼 반복실행 / d는 변수명 여기서는 전달된 DTO객체 이다.-->
			<tr>
				<td><a href="./detail.do?bookNum=${d.bookNum}">${d.bookName}</a></td>
				<!--같은 폴더면 같은 위치
				파라미터 : 클라이언트에서 서버로 보내는 데이타 -->
				<td>${d.bookRate} ${i.index}</td>
			</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<a class="btn btn-danger" href="./add">상품등록</a>
	</section>
	
	<%--<c:forEach begin="1" end="10" step="2" var="num">
		<h1>${num}</h1>
	</c:forEach> --%>

</body>
</html>