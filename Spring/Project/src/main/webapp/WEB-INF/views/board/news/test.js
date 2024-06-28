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