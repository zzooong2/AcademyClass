<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<!-- head.jsp 파일에 선언해둔 내용으로 head 대체 -->
<%@ include file="/views/common/head.jsp"%>
</head>

<body>
	<!-- header.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="/views/common/header.jsp"%>

	<!-- nav.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="/views/common/nav.jsp"%>

	<section style="height: 70vh">
		<h1>자유 게시판</h1>
		<hr>
		<div class="input-group mb-3" style="width: 100%; margin-top: 40px">
			<select class="form-select" id="inputGroupSelect02" name="category"
				style="width: 100px; height: 46px; flex: 0 0 auto;">
				<option value="category-title" selected>제목</option>
				<option value="category-content">내용</option>
				<option value="category-writer">작성자</option>
			</select> 
			<input type="text" style="width: 500px; flex: 0 0 auto;"
				class="form-control" name="serach-text" placeholder="검색어를 입력해주세요."
				aria-label="Recipient's username" aria-describedby="button-addon2">
			<button class="btn btn-outline-secondary" type="button"
				id="button-addon2" style="height: 46px;">검색</button>
	
			<!-- 로그인 안하면 등록버튼 안보이게 설정 -->
			<c:if test="${sessionScope.userName != null}">
				<button onclick="window.location.href = '/form/enrollForm.do'" style="position:absolute; right: 0;">등록</button>
			</c:if>
		</div>
		<div class="table-container">
			<table class="table table-hover" style="margin-top: 10px;">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					<!-- list 객체에 담긴 배열을 하나씩 꺼내서 명시해주기 -->
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="5">등록된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="item" items="${list}">						
								<tr onclick="location.href='/freeBoard/detail.do?boardNumber=${item.boardNo}'">
									<td scope="row">${row}</td>
									<td>${item.boardTitle}</td>
									<td>${item.memberName}</td>
									<td>${item.boardIndate}</td>
									<td>${item.boardViews}</td>
								</tr>
								<c:set var="row" value="${row-1}" />
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>

		<nav aria-label="Page navigation example" style="background-color: white;">
			<ul class="pagination" style="justify-content: center;">
				<!-- 왼쪽 버튼 -->
				<c:choose>
					<c:when test="${pi.cPage == 1}"> 
						<li class="page-item" style="margin-right: 0px">
							<a class="page-link" href="#" aria-label="Previous">
								 <span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item" style="margin-right: 0px">
							<a class="page-link" href="/freeBoard/list.do?cPage=${pi.cPage -1}" aria-label="Previous">
								 <span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:otherwise>
				</c:choose>
				
				<!-- 페이지 버튼 -->
				<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">				
					<li class="page-item" style="margin-right: 0px">
						<a class="page-link" href="/freeBoard/list.do?cPage=${page}">${page}</a>
					</li>
				</c:forEach>
				
				<!-- 오른쪽 버튼 -->
				<c:choose>
					<c:when test="${pi.cPage == pi.maxPage}">
						<li class="page-item" style="margin-right: 0px">
							<a class="page-link" href="#" aria-label="Next"> 
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item" style="margin-right: 0px">
							<a class="page-link" href="/freeBoard/list.do?cPage=${pi.cPage+1}" aria-label="Next"> 
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</section>

	<!-- footer.jsp 파일에 선언해둔 내용으로 head 대체 -->
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>