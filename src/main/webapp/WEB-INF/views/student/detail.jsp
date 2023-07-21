
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
	<%--jsp 주석 --%>
	<h1 class="text-center">Detail Page</h1>
	
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째 글자를 소문자로 바꾼 것 (변수명과 동일)-->
	<!-- 형변환도 알아서 해서 출력해줌 -->
	<h1>${requestScope.dto.bookName}</h1>
	<div>
		${dto.bookContents}
	</div>
	<h1>${dto.bookRate}</h1>
	<!-- requestScope는 생략가능 (같은 이름을 가진경우 안될 수도 있다.)-->
	
	<c:choose>
		<c:when test="${dto.bookSale eq 1} }">
			<h1>판매중</h1>
		</c:when>
		<c:otherwise>
			<h1>판매종료</h1>
		</c:otherwise>
	</c:choose>
	
	<a class="btn btn-danger" href="./update?bookNum=${dto.bookNum}">수정</a>
	<a class="btn btn-danger" href="./delete?bookNum=${dto.bookNum}">삭제</a>
	<!-- 서브릿으로 이동 -->
	
</body>
</html>