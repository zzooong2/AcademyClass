<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<!-- bootStrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<%@ include file="../../common/head.jsp"%>
</head>

<body>
	<%@ include file="../../common/header.jsp"%>
	<%@ include file="../../common/nav.jsp"%>

<%-- 	<section class="container mt-4" style="height: 70vh">
		<div class="card text-center" style="height: 100%">
			<form action="/news/edit.do" method="POST">
				<div class="card-header">
					<input type="hidden" name="boardNo" value="${param.boardNo}"/>
					<input type="text" name="boardTitle" value="${detail.boardTitle}" />
				</div>
				<div class="card-body">
					<div class="d-flex justify-content-center mb-3">
						<div class="mx-3">
							작성자: <span id="fb-writer">${detail.memberName}</span>
						</div>
						<div class="mx-3">
							작성일: <span id="fb-date">${detail.boardIndate}</span>
						</div>
						<div class="mx-3">
							조회수: <span id="fb-views">${detail.boardViews}</span>
						</div>
					</div>
					<hr>
					<textarea name="boardContent" style="height: 300px">${detail.boardContent}</textarea>

				</div>
				<div class="card-footer d-flex justify-content-center">
					<button class="btn btn-secondary mx-2" onclick="window.history.back()">뒤로가기</button>
					<button type="submit" class="btn btn-primary mx-2">수정</button>
				</div>
			</form>
		</div>
	</section> --%>
	
		<section class="container mt-4" style="height: 70vh">
		<div class="card text-center" style="height: 100%">
			<form action="/news/edit.do" method="POST" enctype="multipart/form-data">
				<div class="card-header">
					<input type="text" name="boardTitle" value="${detail.boardTitle}" />
					<input type="hidden" name="boardNo" value="${param.boardNo}"/>
					<input type="hidden" name="memberNo" value="${detail.memberNo}"/>
				</div>
				<div class="card-body">
					<div class="d-flex justify-content-center mb-3">
						<div class="mx-3">
							작성자: <span id="fb-writer">${detail.memberName}</span>
						</div>
						<div class="mx-3">
							작성일: <span id="fb-date">${detail.boardIndate}</span>
						</div>
						<div class="mx-3">
							조회수: <span id="fb-views">${detail.boardViews}</span>
						</div>
					</div>
					<hr>
					<div style="margin-top: 20px; margin-bottom: 20px;">
						<c:if test="${detail.uploadPath != null}">
							<img src="${detail.uploadPath}${detail.uploadName}" width="300px" height="300px">
						</c:if>
						<textarea name="boardContent" style="height: 300px">${detail.boardContent}</textarea>
						<%-- <p class="card-text">${detail.boardContent}</p> --%>
					</div>
					<input type="file" name="upload" />
				</div>
				
				
				<div class="card-footer d-flex justify-content-center">
					<button type="button" class="btn btn-secondary mx-2" onclick="window.history.back()">뒤로가기</button>
					<c:if test="${detail.memberName == sessionScope.memberName}">
						<button type="submit" class="btn btn-primary mx-2">수정</button>
					</c:if>
				</div>

			</form>
		</div>
	</section>


	<%@ include file="../../common/footer.jsp"%>
</body>
</html>
