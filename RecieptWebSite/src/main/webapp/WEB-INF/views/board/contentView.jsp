<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topMenu.jsp" />
	<div id="root">
		<header>
			<h1>살까 말까</h1>
		</header>
		<hr />

		<section id="container">
			<form method="post">
				<label>제목 </label>${board.title} <br />				
				<label>내용 </label>${board.content} <br />
				<label>작성자 </label>${board.writer} <br />
				<div>
				<a href="/main/vote/modify/${board.boardNo}">수정</a>
				</div>
				<div>
				<a href="/main/vote/delete/${board.boardNo}">삭제</a>
				</div>
			</form>
			
		</section>
		<hr />
	</div>
</body>

</html>