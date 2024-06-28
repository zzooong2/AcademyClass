<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<h1>나의 홈페이지</h1>
	<div class="login-signup">
		<c:choose>
			<c:when test="${sessionScope.memberNo > 0 }">
				<a href="/member/logout.do">로그아웃</a>
				<a href="#">${sessionScope.memberName}님!</a>
			</c:when>
			<c:otherwise>
				<a href="/member/loginForm.do">로그인</a>
				<a href="/member/registerForm.do">회원가입</a>
			</c:otherwise>
		</c:choose>
	</div>
</header>