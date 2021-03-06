<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
	<%@include file ="../head.jsp" %>
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
						<li><a href="${path}">Home</a></li>
						<li><a href="${path}/freeboard/index.do">Freeboard</a></li>
						<li class="active"><a href="${path}/member/index.do">Member</a></li>
					</ul>
				</div>
			</nav>
		</div>	
<!--  banner -->
		<div class="row">
			<div class="jumbotron">
				<h1>글작성하기</h1>
				<p>글작성을 할수있습니다.</p>
			</div>
		</div>
<!-- body  -->
		<div class="row">
			<form action="${path}/freeboard/boardUpdate.do" method="get">
				<h2>게시판 목록</h2>
				<input type="hidden" name="writer" value="${bdView.writer}">
				<input type="hidden" name="boardIdx" value="${bdView.boardIdx}">
				<div class="row">
					<div class="col-sm-12">
						<p>글번호</p>
						<p>${bdView.boardIdx}</p>
					</div>
					<div class="col-sm-12">
						<p>제목</p>
						<p>${bdView.boardTitle}</p>
					</div>
					<div class="col-sm-12">
						<p>작성자</p>
						<p>${bdView.writer}</p>
					</div>
					<div class="col-sm-12">
						<p>조회수</p>
						<p>${bdView.hitView}</p>
					</div>
					<div class="col-sm-12">
						<p>날짜</p>
						<p>${bdView.rgDate}</p>
					</div>
					<div class="col-sm-12">
						<p>내용</p>
						<p>${bdView.boardContent}</p>
					</div>
				</div>
				<div class="col-sm-1">
					<a class="btn btn-primary" href="${path}/freeboard/index.do">목록으로</a>
				</div>
				<c:set var="ssId" value="${user.userId}"/>
				<c:set var="wtId" value="${bdView.writer}"/>
				<c:if test="${ssId == wtId}">
					<div class="col-sm-1">
						<input type="submit" class="btn btn-primary" value="수정하기">
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary" onclick="location.href='${path}/freeboard/boardDelete.do?writer=${bdView.writer}&boardIdx=${bdView.boardIdx}'">삭제하기</button>
					</div>
				</c:if>
			</form>
		</div>
		<div class="row">
		<h1>덧글</h1>
			<ul>
				<c:forEach items="${cmtList}" var="cmtList">
					<li>
						<p>작성자 : ${cmtList.writer}</p>
						<p>작성 날짜 : ${cmtList.rgDate}</p>
						<p>내용</p>
						<p>${cmtList.cmtContent}</p>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="row">
			<form action="${path}/freeboard/cmtWriteProc.do" method="post">
				<input type="hidden" name="boardIdx" value="${bdView.boardIdx}">
				<p>작성자</p>
				<input type="text" name="writer" value="${user.userId}" readonly="readonly">
				<p>덧글내용</p>
				<input type="text" name="cmtContent">
				<input type="submit" value="작성하기">
			</form>
		</div>
	</div>
</body>
</html>
