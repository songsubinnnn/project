<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topMenu.jsp" />

	<!-- 게시판 -->
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${keyword}">
			<tr>
				<td>${row.boardNo}</td>
				<td><a href="" />${row.title}</td>
				<td>${row.writer}</td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${row.regdate}"/></td>
				<td>${row.viewcnt}</td>

			</tr>
		</c:forEach>
	</table>
	
		<form action="/main/vote/search" method="post">
		<select id="select" name="selectType">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" id="keyword" name="keyword"/> <!--id로 usr값 넘김 -->
		<input type="submit" value="검색" />
	</form>
</body>
</html>