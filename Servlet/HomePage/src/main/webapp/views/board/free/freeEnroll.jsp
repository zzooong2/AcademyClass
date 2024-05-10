<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<!-- head.jsp 파일에 선언해둔 내용으로 head 대체 -->
<%@ include file="/views/common/head.jsp"%>
</head>

<body>
	<!-- header.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="/views/common/header.jsp"%>

	<!-- nav.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="/views/common/nav.jsp"%>

	<section id="post-form">
		<h2>새 글 작성</h2>
		<form action="/freeBoard/enroll.do" method="POST">
			<!-- type을 hidden 으로 설정하여 사용자에게는 보이지 않는 고객번호를 전달 -->
			<%-- <input type="hidden" name="member-no" value="${sessionScope.userNo}"> --%>
		
			<label for="title">제목:</label> 
			<input type="text" id="title" name="title" required>
			 
			<label for="author">글쓴이:</label>
			<input type="text" id="author" value="${sessionScope.userName}" disabled>
			
			<label for="content">내용:</label>
			<textarea id="content" name="content" rows="4" required></textarea>

			<button type="submit">작성</button>
		</form>
	</section>

	<!-- footer.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>