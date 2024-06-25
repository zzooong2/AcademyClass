<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@ include file="../common/head.jsp"%>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>

	<section>
		<div class="login-form">
			<h2>로그인</h2>
			<form>
				<label for="username">아이디:</label> <input type="text" id="username"
					name="username" required> <label for="password">비밀번호:</label>
				<input type="password" id="password" name="password" required>

				<button type="submit">로그인</button>
			</form>
		</div>
	</section>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>
