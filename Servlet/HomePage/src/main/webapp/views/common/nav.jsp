<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="/resources/css/main.css">

<nav>
	<ul>
		<li><a href="/">홈</a></li>
		<li><a href="introduce.html">소개</a></li>
		<li><a href="portfolio.html">포트폴리오</a></li>
		<li class="menu-item">
			<a href="#">게시판</a>
			<div class="submenu">
				<a href="news.html">뉴스 게시판</a>
				<!-- ?cpage=1: 페이지네이션 중, 1페이지 -->
				<a href="/freeBoard/list.do?cPage=1">자유 게시판</a>
			</div>
		</li>
		<li><a href="contact.html">연락하기</a></li>
	</ul>
</nav>