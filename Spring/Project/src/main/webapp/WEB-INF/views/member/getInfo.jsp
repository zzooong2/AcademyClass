<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
<head>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
   <input type="text" id="getId" placeholder="아이디를 입력해주세요." onkeyup="getInfo()">
   <script>
      function getInfo() {
         const getId = document.getElementById("getId").value;
         
         $.ajax({
            type: "GET",
            url: "/api/member/"+getId,
            contentType:"application/json",
            success: function(res) {
               console.log(res);
            },
            error: function(err) {
            }
         })
      }
   </script>
   
   <br>
   <hr>
   
   <input type="text" id="deleteId" placeholder="삭제할 아이디를 입력하세요"/>
   <button type="button" id="deleteBtn" onclick="deleteMember()">회원 삭제</button>
   <span id="deleteResult"></span>
   
   <!-- 
   		1. 사용자로부터 아이디를 입력받음
   		2. 삭제 버튼을 누르면 비동기 통신으로 삭제 요청
   		3. /api/member/사용자가입력한ID
   		4. HTTP Method는 DELETE 이용
    -->
   
   <script>
   		function deleteMember() {
   			const getId = document.getElementById("deleteId").value;
   			const resultMsg = document.getElementById("deleteResult");
   			
   			$.ajax({
   			  type: "DELETE",
   			  url: "/api/member/"+getId,
   			  contentType: "application/json; charset=utf-8",
   			  success: function(res) {
   				  if(res === "success"){
	   				  resultMsg.innerHTML = "삭제 성공";
   				  } else {
   					  resultMsg.innerHTML = "삭제 실패";
   				  }
   			  },
   			  error: function(err){
   				  console.log(err);
   			  }
   			});
   		}
   </script>
   
   
   <br>
   <hr>
   
   <input type="text" id="memberId" placeholder="아이디" />
   <input type="text" id="memberName" placeholder="이름" />
   <input type="password" id="memberPassword" placeholder="비밀번호" />
   <button type="button" onclick="jsonSubmit()">제출</button>
   
	<script>
		function jsonSubmit(){
			const id = document.getElementById("memberId").value;
			const name = document.getElementById("memberName").value;
			const pwd = document.getElementById("memberPassword").value;
			
			$.ajax({
				type: "PUT",
				url: "/api/member",
				contentType: "application/json",
				data: JSON.stringify({
					memberId:id,
					memberName:name,
					memberPassword:pwd
				}),
				success: function(res){
					
				},
				error: function(err) {
					
				}
			});
		}
	</script>   
   
</body>
</html>
