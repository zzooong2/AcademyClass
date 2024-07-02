<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../common/head.jsp"%>
<style>
.page-item {
	margin-right: 0px;
}
</style>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>
	<section class="container mt-4" style="height: 1250px">
		<div class="row">
			<div class="col-12">
				<div class="input-group mb-3" style="width: 100%; margin-top: 40px">
					<form action="" method="GET" class="d-flex">
						<select class="form-select" id="inputGroupSelect02" name="category" style="width: 100px; height: 46px;">
							<option value="nb_title" selected>제목</option>
							<option value="nb_content">내용</option>
						</select> 
						<input type="text" class="form-control" name="searchText" placeholder="검색어를 입력해주세요." style="width: 500px;">
						<button class="btn btn-outline-secondary" type="submit" id="button-addon2" style="height: 46px;">검색</button>
					</form>
					<c:if test="${sessionScope.memberNo > 0}">
						<button type="button" onclick="window.location.href = '/news/enrollForm.do'" style="position: absolute; right: 4%;">등록</button>
					</c:if>
				</div>
			</div>
			
			<div class="row">
			<c:forEach var="news" items="${list}">
				<div class="col-12 col-md-6 col-lg-2 mb-4">
					<div class="card">
						<img src="${news.uploadPath}${news.uploadName}" class="card-img-top" alt="뉴스 이미지" />
						<div class="card-body">
							<h5 class="card-title">${news.boardTitle}</h5>
							<p class="card-text">${news.boardContent}</p>
							<a href="/news/detail.do?boardNo=${news.boardNo}" class="btn btn-primary">더 보기</a>
						</div>
					</div>
				</div>
				<c:set var="row" value="${row-1}" />
			</c:forEach>
				
				
			<!-- 페이지 네비게이션 -->
			<div class="row mt-4">
				<nav aria-label="Page navigation example" style="background-color: white;">
					<ul class="pagination" style="justify-content: center;">
						<!-- 왼쪽 버튼 -->
						<c:choose>
							<c:when test="${pi.cpage == 1}">
								<li class="page-item">
									<a class="page-link" href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a class="page-link" href="/news/list.do?cpage=${pi.cpage-1}&category=${param.category}&searchText=${param.searchText}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
							</c:otherwise>
						</c:choose>
						
						<!-- 페이지 숫자 버튼 -->
						<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
							<li class="page-item"><a class="page-link" href="/news/list.do?cpage=${page}&category=${param.category}&searchText=${param.searchText}">${page}</a></li>
						</c:forEach>
						
						<!-- 오른쪽 버튼 -->
						<c:choose>
							<c:when test="${pi.cpage == pi.maxPage}">
								<li class="page-item">
									<a class="page-link" href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a class="page-link" href="/news/list.do?cpage=${pi.cpage+1}&category=${param.category}&searchText=${param.searchText}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:otherwise>
						</c:choose>							
					</ul>
				</nav>
			</div>
	</section>
	<%@ include file="../../common/footer.jsp"%>
</body>
</html>
