<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- head.jsp 파일에 선언해둔 내용으로 head 대체 -->
<%@ include file="views/common/head.jsp" %>
</head>

<body>
	<!-- header.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="views/common/header.jsp" %>

	<!-- nav.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="views/common/nav.jsp" %>

  <section>
    <h2>홈</h2>
    <p>안녕하세요! 홈페이지에 오신 것을 환영합니다.</p>
  </section>

	<!-- footer.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="views/common/footer.jsp" %>
</body>
</html>