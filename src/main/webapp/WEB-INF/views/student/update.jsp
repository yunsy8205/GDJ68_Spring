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
	<h1>Update Page</h1>
	
	<form action="./update" method="post" >
	<!-- disable는 보여주는 데 수정이 불가능하고 파라미터로 넘길수 없다. readonly는 보여주는 데 수정이 불가능하고 파라미터로 넘길수 있다. 
	     hidden은 보이지 않지만 파라미터로 넘어감-->
		학생번호<input type="hidden" name="studNum" class="form-control" value="${dto.studNum}"><br>
		학생이름<input type="text" name="studName" class="form-control" value="${dto.studName}"><br>
		국어점수<input type="text" name="studKor" class="form-control" value="${dto.studKor}"><br>
		영어점수<input type="text" name="studEng" class="form-control" value="${dto.studEng}"><br>
		수학점수<input type="text" name="studMath" class="form-control" value="${dto.studMath}"><br>

		<button>수정</button> <!-- 버튼도 타입이 있음 기본은 서브밋 -->
		<input type="submit" value="수정">
		<input type="reset" value="초기화">

	</form>
	
</body>
</html>