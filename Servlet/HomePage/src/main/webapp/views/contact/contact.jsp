<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

	<section id="contact">
		<h2>연락하기</h2>
		<p>문의사항이나 연락하고 싶은 내용을 작성하세요.</p>
		<form>
			<label for="name">이름:</label> <input type="text" id="name" name="name" required> <label for="email">이메일:</label> 
			<input type="email" id="email" name="email" required> 
			<label for="message">메시지:</label>
			<textarea id="message" name="message" rows="4" required></textarea>

			<p id="charCounter">0/500</p>

			<button type="submit">전송</button>
		</form>
	</section>

	<!-- footer.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>