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
<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>

	<h1 class="text-center mt-5 mb-3 ms-3">Add Page</h1>
	
	<form action="./add" method="post" class="mx-3" enctype="multipart/form-data" id="frm">
		제목<input type="text" name="subject" class="form-control" id="subject"><br>
		<input type="hidden" name="name" value="${sessionScope.member.id}" class="form-control">
		내용 <textarea rows="" cols="" id="contents" name="contents" class="form-control"></textarea><br>

		<div id="fileList" class="my-5">

		</div>
		<div>
			<button type="button" id="btn2" class="btn btn-outline-danger my-3">File 추가</button>
		</div>

		
		<button type="button" id="btn" class="btn btn-outline-danger">등록</button> 
		<!-- 버튼타입이어야 자바스크립트 돌아가고 서브밋되도록 할 수 있다. -->
		<input class="btn-outline-danger" type="reset" value="reset">
	</form>
	<script src="../resources/js/file.js"></script>
	<script>
		$('#contents').summernote({
			height: 400,
		callbacks:{
			onImageUpload: function(files){
				// summernote의 이미지 input한 파일의 모음(배열)
				
				let formData = new FormData();
				//<form></form>이 만들어진것 (폼 객체를 만듬)
				formData.append("files", files[0]);
				//<input type="file" name="files">를 집어 넣음
				$.ajax({
					type:'post',
					url:'./setContentsImg',
					data: formData,//{}객체형식으로 넣는데 객체 자체를 넣어도 됨
					enctype: 'multipart/form-data',
					cache:false,
					contentType : false,
					processData : false,
					success:function(result){
						$('#contents').summernote('insertImage',result.trim());

					},
					error:function(){
						console.log('error');
					}
				});
				
			},
			onMediaDelete:function(files){
				//폴더에서 삭제하기
				let path = $(files[0]).attr("src");// /resources/upload/notice/파일명
				$.ajax({
					type:'post',
					url:'./setContentsImgDelete',
					data:{
						path:path
					},
					success:function(result){
						console.log(result);
					},
					error:function(){
						console.log('error');
					}
				})
			
			}
		}
			});
		const btn =document.getElementById("btn");
		const subject=document.getElementById("subject");
		const frm = document.getElementById("frm");

		btn.addEventListener("click", function(){
			console.log(subject.value=="");
			console.log(subject.value.length==0);
			if(subject.value==""){
				alert('제목은 필수입니다.');
				subject.focus();
				return;
			}
			frm.submit();
		})
		
    // 제목의 밸류 값이 있는 지 확인!
	</script>
</body>
</html>