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
	<h1 class="text-center my-3">상품가입 Page</h1>
	<form action="./add" method="post" id="frm" class="mx-5 mt-5">
	<input type="hidden" name="bookNum" value="${dto.bookNum}">
	<div>
	<label for="pw">비밀번호</label>
	<input type="password" name="accountPassword" id="pw" class="form-control"><br>
	<div id="out"></div>
	</div>
	<button type="button" id="btn" class="mt-5 btn btn-primary">상품가입</button>		
	</form>

</section>	
<script type="text/javascript">
	const pw = document.getElementById("pw");
	const btn = document.getElementById("btn")

	btn.addEventListener("click", function(){
		if(pw.value.length==4 && Number.isInteger(pw.value*1)){
			frm.submit();               // isInteger은 정수인지 아닌지 확인해 준다.
		}else{
			alert("비번 4글자로 또는 숫자로만 작성");
		}
	})
</script>
</body>
</html>