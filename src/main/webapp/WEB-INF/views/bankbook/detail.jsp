
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
	<h1>Detail Page</h1>
	
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
	
	<c:forEach items="${dto.fileDTOs}" var="f">
		<img alt="" src="../../resources/upload/bankbook/${f.fileName}">
	</c:forEach>
	
	<a class="btn btn-danger" href="./update?bookNum=${dto.bookNum}">수정</a>
	<a class="btn btn-danger" href="./delete?bookNum=${dto.bookNum}">삭제</a>
	<button id="update" >수정</button>
	<button id="del" data-delete-name="bookNum" data-delete-num="${dto.bookNum}">삭제</button>
	<!-- 사용자 정의 속성 사용! -->
	<a class="btn btn-danger" href="../bookaccount/add?bookNum=${dto.bookNum}">상품가입</a>
	<button class="btn btn-danger" id="add">상품가입</button>

	<div id="productList"></div>

		<div class="alert alert-light" role="alert">
			<input type="text" id="contents">
		  </div>
	<button class="btn btn-danger" type="button" id="commentbtn">댓글입력</button>
	
	<script src="../resources/js/delete.js"></script>
	<script type="text/javascript">
		setBookNum(${dto.bookNum});
	
		// 스크립트 코드가 아니라서 에러가 발생하지만 무시
		const add = document.getElementById("add");
		const productList = document.getElementById("productList");
		const commentbtn = document.getElementById("commentbtn");
		const contents = document.getElementById("contents");

		bookComment();

		commentbtn.addEventListener("click", function(){
			fetch("../comment/add?bookNum="+bookNum+"&contents="+contents.value, {method:"get"})
			.then((response)=>{return response.text()
			})//응답받음
			.then((r)=>{
				
				if(r==1){
					bookComment();
				}
			});
		})

		function bookComment(){
			fetch("../comment/list?bookNum="+bookNum, {
				method:"get"
			})
			.then((response)=>{return response.text()
			})//응답받음
			.then((r)=>{
				
				productList.innerHTML=r;
			});

		}

		add.addEventListener("click", function(){
			//자바스크립트에는 폼태그가 없다. 부트스트랩 모달이용
			let bookNum=add.getAttribute("data-add-num");
			let pw = document.getElementById("pw").value;

			//1.
			let xhttp = new XMLHttpRequest();
			
			//2. 요청정보
			xhttp.open("post", "../bookaccount/add")

			//요청 header 정보
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			//요청 발생(post일 경우 파라미터 작성 key=값&key2=값2 ...)
			xhttp.send("bookNum="+bookNum+"&accountPassword="+pw);

			//응답 처리
			xhttp.onreadystatechange=function(){
				if(this.readyState==4&&this.status==200){
					console.log(this.responseText);
				}
			}
		});



	</script>

</body>
</html>