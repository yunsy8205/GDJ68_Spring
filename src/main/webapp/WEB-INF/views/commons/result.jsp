<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result gt 0}">
		<h1>성공</h1>
	</c:if>
		<c:if test="${result le 0}">
		<h1>실패</h1>
	</c:if>

</body>
</html>