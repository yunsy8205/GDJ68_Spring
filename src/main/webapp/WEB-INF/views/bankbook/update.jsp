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
		<input type="hidden" name="bookNum" value="${dto.bookNum}"><br>
		상품명<input type="text" name="bookName" value="${dto.bookName}"><br>
		내용 <textarea rows="" cols="" name="bookContents">${dto.bookContents}</textarea><br>
		이자율<input type="text" name="bookRate" value="${dto.bookRate}"><br>
		<p>
			판매가능 <input type="radio" value="1" checked name="bookSale"><br>
			판매중지 <input type="radio" value="0" name="bookSale"><br>
		</p>
	
	<!--<p>
			<select name="bookSale">
				<option selected value="1">판매가능</option>
				<option value="0">판매중지</option>
			</select>
		</p>-->
		
		<button>수정</button> <!-- 버튼도 타입이 있음 기본은 서브밋 -->
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value ="수정">
	</form>
	
</body>
</html>