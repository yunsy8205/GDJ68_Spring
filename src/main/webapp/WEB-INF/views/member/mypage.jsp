<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	<h1>My Page</h1>
	<div>
		<p>
			<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
		</p>
		<p>
			${member.id} : ${sessionScope.member.name}
		</p>
		<p>
			${member.email}
		</p>
		<p>
			${member.birth}
		</p>
	</div>
	
	<a class="btn btn-primary" href="./memberUpdate">회원수정</a>
	
	<div id="productList">
	
	</div>
	
<script>
	// const productList = document.getElementById("productList");
	//let page=1;
	
	// getList(1);
	
	// productList.addEventListener("click", function(event){
	// 	if(event.target.classList.contains("move")){
	// 		page = event.target.getAttribute("data-num");
			
	// 		getList(page);
			
	// 	}
	// })
	
	// function getList(page){
		
	// fetch("../bookaccount/list?page="+page, {
	// 	method:"get"
	// })
	// .then((response)=>{return response.text()
	// })//응답받음
	// .then((r)=>{
		
	// 	productList.innerHTML=r;
	// });
	// }
	getList(1);

	$('#productList').on("click", ".move", function(){
		let page = $(this).attr("data-num");
		getList(page);
	})

	function getList(page){

		$.ajax({
			type:'GET',
			url: "../bookaccount/list",
			data:{
				page:page
			},
			success:function(response){
				$('#productList').html(response.trim());
			},error:function(){
				alert('관리자에게 문의');
			}
		});
	}
	
</script>
</body>
</html>