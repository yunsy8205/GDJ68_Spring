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

	<h1 class="text-center mt-5 mb-3 ms-3">Add Page</h1>
	
	<form action="./add" method="post" class="mx-3" enctype="multipart/form-data" id="frm">
		제목<input type="text" name="subject" class="form-control" id="subject"><br>
		<input type="hidden" name="name" value="${sessionScope.member.id}" class="form-control">
		내용 <textarea rows="" cols="" name="contents" class="form-control"></textarea><br>

		<div>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		<label for="pic">사진첨부</label>
		<input type="file" name="photos" id="pic" class="form-control"><br>
		</div>
		
		<button type="button" id="btn" class="btn btn-outline-danger">등록</button> 
		<!-- 버튼타입이어야 자바스크립트 돌아가고 서브밋되도록 할 수 있다. -->
		<input class="btn-outline-danger" type="reset" value="reset">
	</form>
	<script>

		const btn =document.getElementById("btn");
		const subject=document.getElementById("subject");
		const frm = document.getElementById("frm");

		btn.addEventListener("click", function(){
			console.log(subject.value=="");
			console.log(subject.value.length==0);
			if(subject.value==""){
				alert('제목은 필수입니다.');
				subject.focus();
			}
		})
		
    // 제목의 밸류 값이 있는 지 확인!
	</script>
</body>
</html>