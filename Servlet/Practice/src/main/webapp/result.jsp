<!-- JSP: Java Server Page: HTML에서 자바를 사용하기 위한 서버사이드 템플릿엔진  -->

<!-- jstl 적용하기 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 지시자(@): 태그에 JSP의 환경을 설정해주며 아래의 코드는 인코딩 방식을 지정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 스크립틀릿: 태그 사이에 Java 코드를 직접 삽입할 수 있도록 해주는 방법 -->    
<% 
	String orderName = (String)request.getAttribute("orderName");
	int sum = 0;
	for(int i=0; i<10; i++){
		sum += i;
	}
%>

<!-- 선언문(!): 태그 사이에 변수 또는 메소드를 선언하여 사용할 수 있도록 해주는 방법 -->
<%! 
	int num1 = 5;
	int num2 = 10;
	public int method(int num1, int num2){
		return num1 + num2;
	}
%>    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> <%=method(num1, num2)%></p>
	
	<!-- 표현식 -->
	<p> 주문자 이름: <%=orderName%> </p>
	<p> <%=sum%> </p>
	
	<!-- jstl -->
	<c:set var="num1" value="1" />
	<c:if test = "${num1 == 1} })">
		<p> num1은 1입니다. </p>
	</c:if>
</body>
</html>