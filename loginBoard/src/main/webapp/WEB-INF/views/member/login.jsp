<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<%@include file="../head.jsp"%>
</head>
<body>
	<div class="container">
		<!--  menu -->
		<div class="row">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">신입개발자</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="${path}">Home</a></li>
						<li><a href="${path}/freeboard/index.do">Freeboard</a></li>
						<li><a href="${path}/member/index.do">Member</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<!--  광고 -->
		<div class="row">
			<div class="jumbotron">
				<h1>로그인페이지</h1>
				<p>회원가입후 로그인해주세요.</p>
			</div>
		</div>

		<!-- body  -->
		<div class="row">
			<form action="${path}/member/loginProc.do" method="post">
				<p>아이디</p>
				<input type="text" name="userId">
				<p>비밀번호</p>
				<input type="password" name="userPw">
				<input type="submit" value="로그인하기">
			</form>
		</div>
	</div>
</body>
</html>