<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <header>
		<nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
			<div class="container-fluid">
    			<a class="navbar-brand" href="#">Navbar</a>
   			 	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      				<span class="navbar-toggler-icon"></span>
    			</button>
    		<div class="collapse navbar-collapse" id="navbarSupportedContent">
      		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
        		<li class="nav-item">
          			<a class="nav-link active" aria-current="page" href="/index.do">Home</a>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link active" href="/bankbook/list">BankProduct</a>
        		</li>
        		<li class="nav-item dropdown">
          			<a a class="nav-link active" href="#">Dropdown</a>
			     </li>
			        <li class="nav-item">
			          <a class="nav-link disabled">Disabled</a>
			        </li>
     			 </ul>
     			
     			 <nav>
     				<ul class="nav">
     					<c:if test ="${not empty member}">
     					<li class="nav-item text-white me-3"><a href="/member/logout.do">로그아웃</a></li>
     					<li class="nav-item text-white me-3"><a href="/member/mypage.do">마이페이지</a></li>
     					</c:if>
     					<c:if test ="${empty member}">
     					<li class="nav-item text-white me-3"><a href="/member/login.do">로그인</a></li>
     					<li class="nav-item text-white me-3"><a href="/member/join.do">회원가입</a></li>
     					</c:if>
     				</ul>
     			 </nav>
<!--       <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form> -->
    </div>
  </div>
		</nav>
	</header>