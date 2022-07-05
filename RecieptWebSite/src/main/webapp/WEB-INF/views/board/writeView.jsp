<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기는 글쓰기 창</title>
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

				<label>제목</label>
				<input type="text" name="title" /><br /> 
				
				<label>내용</label>
				<textarea cols="50" rows="5" name="content"></textarea><br />
				<label>작성자</label>
				<input type="text" name="writer" /><br /> 
				<button type="submit">작성</button>

			</form>
		</section>
		<hr />
	</div>
</body>
</html>