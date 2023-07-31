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

	<h1 class="text-center mt-5 mb-3 ms-3">UPDATE</h1>
	
	<form action="./update" method="post" class="mx-3">
		<input type="hidden" name="num" value="${notice.num}"><br>
		<!-- post일 때, hidden으로 넘겨줘야함 보안이 필요할때 -->
		제목<input type="text" name="subject" class="form-control" value="${notice.subject}"><br>
		작성자<input type="text" readonly name="name" class="form-control" value="${notice.name}"><br>
		내용 <textarea rows="" cols="" name="contents" class="form-control" value="${notice.contents}"></textarea><br>

		<button class="btn btn-outline-danger">수정</button> <!-- 버튼도 타입이 있음 기본은 서브밋 -->
		<input class="btn btn-outline-danger" type="reset" value="reset">

	</form>

</body>
</html>