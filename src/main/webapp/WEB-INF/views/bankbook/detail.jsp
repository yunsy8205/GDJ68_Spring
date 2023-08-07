
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
	<a class="btn btn-danger" href="../bookaccount/add?bookNum=${dto.bookNum}">상품가입</a>
	<!-- 사용자 정의 속성 사용! -->
	<button id="update" data-bs-toggle="modal" data-bs-target="#exampleModal">가입</button>
	
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호를 입력하세요</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
	    <div>
		<input type="password" name="accountPassword" id="pw" class="form-control"><br>
		<div id="out"></div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id="close" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="add" data-add-num="${dto.bookNum}">상품가입</button>
      </div>
    </div>
  </div>
</div>
	
	<script src="../resources/js/delete.js"></script>
	<script type="text/javascript">
		setBookNum(${dto.bookNum});
		// 스크립트 코드가 아니라서 에러가 발생하지만 무시
		const add = document.getElementById("add");

		add.addEventListener("click", function(){
			//자바스크립트에는 폼태그가 없다. 부트스트랩 모달이용
			let bookNum=add.getAttribute("data-add-num");
			let pw = document.getElementById("pw").value;
			//ajax1(bookNum, pw);
			ajax2(bookNum,pw);
		});
		
		function ajax2(bookNum,pw){
			// 1번은 옛날 과정이고 요즘은 fetch를 쓴다.
			fetch("../bookaccount/add", {
				method:"post",
				body:"bookNum="+bookNum+"&accountPassword="+pw,
				//파라미터명 : 매개변수명
				//JSON 타입을 문자열로 바꿔달라는 의미
				headers:{
					"Content-type":"application/x-www-form-urlencoded"
				}
			}) //응답을 쓸때 화살표 함수 사용
			.then((response)=>{//response라는 객체에 응답을 모두 저장하고 function에 이용
				return response.text();
			})
			.then((r)=>{//r에 위에서 리턴한 값이 들어감
				if(r>0){
					alert("가입 완료");
				}else{
					alert("가입 실패");
				}
			
			location.href="../";
			});
		}
		
		function ajax1(bookNum, pw){
			//1.
			let xhttp = new XMLHttpRequest();
			
			//2. 요청정보
			xhttp.open("post", "../bookaccount/add");

			//요청 header 정보
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			//요청 발생(post일 경우 파라미터 작성 key=값&key2=값2 ...)
			xhttp.send("bookNum="+bookNum+"&accountPassword="+pw);

			//응답 처리
			xhttp.onreadystatechange=function(){
				if(this.readyState==4&&this.status==200){//4번응답후 200번 상태일때
					let r = this.responseText.trim(); //응답결과 문자열을 변수에 저장
					console.log(r);
					if(r>0){
						alert("가입성공");
					}else{
						alert("가입실패");
					}
					document.getElementById("close").click();//강제로 닫아줌
					location.href="../";// 루트로 보내줌
				}
			}
			
		}


	</script>

</body>
</html>