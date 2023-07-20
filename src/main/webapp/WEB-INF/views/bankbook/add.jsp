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

	<h1 class="mt-5 mb-3 ms-3">Add Page</h1>
	
	<form action="./add" method="post" class="mx-3">
		상품명<input type="text" name="bookName" class="form-control"><br>
		상세설명 <textarea rows="" cols="" name="bookContents" class="form-control"></textarea><br>
		<!-- 셋터의 이름을 네임으로 써야함 -->
		이자율<input type="text" name="bookRate" class="form-control"><br>
		<p>
			판매가능 <input type="radio" value="1" checked name="bookSale" class="form-check-input"><br>
			판매중지 <input type="radio" value="0" name="bookSale" class="form-check-input"><br>
		</p>
		
		<p>
			축구 <input type="checkbox" value="football" checked name="sports" class="form-check-input"><br>
			농구 <input type="checkbox" value="basketball" name="sports" class="form-check-input"><br>
			배구 <input type="checkbox" value="volley" name="sports" class="form-check-input"><br>
			야구 <input type="checkbox" value="baseball" name="sports" class="form-check-input"><br>
		</p>
	
	<!--<p>
			<select name="bookSale">
				<option selected value="1">판매가능</option>
				<option value="0">판매중지</option>
			</select>
		</p>-->
		
		<button class="btn btn-danger">등록</button> <!-- 버튼도 타입이 있음 기본은 서브밋 -->
		<input class="btn btn-danger" type="submit" value="ADD">
		<input class="btn btn-danger" type="reset" value="reset">
		<input class="btn btn-danger" type="button" value ="ADD">
	</form>

</body>
</html>