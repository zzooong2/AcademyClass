<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@ include file="../common/head.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>

	<section>
		<div class="signup-form">
			<h2>회원가입</h2>
			<form action="/member/register.do" method="POST">
				<div class="input-container"></div>
				<div class="input-container">
					<label for="new-username">이름:</label> <input type="text" id="new-username" name="memberName" onkeyup="" required>
					<span id="msg-username"></span>
				</div>

				<div class="input-container">
					<label for="new-userid">아이디:</label> <input type="text" id="new-userid" name="memberId" onkeyup="checkId()" required>
					<span id="msg-userid"></span>
				</div>
				<div class="input-container">
					<label for="new-password">비밀번호:</label> <input type="password" id="new-password" name="memberPassword" onkeyup="" required> 
					<span id="msg-password"></span>
				</div>

				<div class="input-container">
					<label for="confirm-password">비밀번호 확인:</label> 
					<input type="password" id="confirm-password" name="confirmPassword" onkeyup="" required> 
					<span id="msg-password-check"></span>
				</div>

				<button type="submit">회원가입</button>
			</form>
		</div>
	</section>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>

<script>
	function checkId(){
		const id = document.getElementById("new-userid").value;
		
		$.ajax({
			type:"post",
			url:"/member/checkId.do",
			data: {memberId : id},
			success: function(res){
				if(res === "true") {
					console.log("사용 가능한 아이디입니다.")
				} else {
					console.log("중복된 아이디입니다.")
				}
			},
			error: function(err){
				
			}
		})
	}
</script>
