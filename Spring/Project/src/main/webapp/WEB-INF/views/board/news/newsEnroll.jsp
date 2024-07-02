<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@ include file="../../common/head.jsp"%>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>

	<section id="post-form">
		<h2>새 글 작성</h2>
		<form action="/news/enroll.do" method="POST" enctype="multipart/form-data">
			<label for="boardTitle">제목:</label> 
			<input type="text" id="title" name="boardTitle" required> 
			
			<label for="memberName">글쓴이:</label> 
			<input type="text" id="author" name="memberName" value="${sessionScope.memberName}" disabled>
			 
			<label for="boardContent">내용:</label>
			<textarea name="boardContent"></textarea>
			
			<input type="file" name="upload" />
			
			<button type="submit">작성</button>
		</form>
	</section>


	<%@ include file="../../common/footer.jsp"%>
</body>
</html>
