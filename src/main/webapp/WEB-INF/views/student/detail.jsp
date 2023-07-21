
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
	<!-- requestScope는 생략가능 (같은 이름을 가진경우 안될 수도 있다.)-->
	<h1>번호 : ${dto.studNum}</h1>
	<h1>이름 : ${dto.studName}</h1>
	<h1>국어점수 : ${dto.studKor}</h1>
	<h1>영어점수 : ${dto.studEng}</h1>
	<h1>수학점수 : ${dto.studMath}</h1>
	<h1>합계 : ${dto.studTotal}</h1>
	<h1>평균 : ${dto.studAvg}</h1>
		
	<a class="btn btn-danger" href="./update?studNum=${dto.studNum}">수정</a>
	<a class="btn btn-danger" href="./delete?studNum=${dto.studNum}">삭제</a>
	<!-- 서브릿으로 이동 -->
	
</body>
</html>