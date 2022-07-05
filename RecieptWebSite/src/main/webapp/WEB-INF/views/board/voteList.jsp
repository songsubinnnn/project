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
<style type="text/css">

	li {
	list-style: none; float: left; padding: 6px;
	}
			
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topMenu.jsp" />

<div class="table_wrap">
	<!-- 게시판 -->
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td><c:out value="${row.boardNo}" /></td>
				<td><a href="/main/vote/contentView/${row.boardNo}">${row.title}</a></td>
				<td><c:out value="${row.writer}" /></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${row.regdate}" /></td>
				<td><c:out value="${row.viewcnt}" /></td>

			</tr>
		</c:forEach>
	</table>
	

	<!-- 페이지 버튼  -->	
	<div>
  <ul id="pageInfo">
    <c:if test="${paging.prev}">
    	<li><a href="/main/vote/list/${paging.startPage - 1 }">이전</a></li>
    </c:if> 
    
	
	 <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
	    <span>
	     <a href="/main/vote/list/${num}">${num}</a>
	  </span>
	 </c:forEach>
	

    <c:if test="${paging.next && paging.endPage > 0}">
    	<a href="/main/vote/list/${paging.endPage + 1 }">다음</a>
    </c:if> 
  </ul>
</div>

	

	<%-- <form id="move">
		<input type="hidden" name="currentPage" value="${ paging.criteria.currentPage }" />
		<input type="hidden" name="perPage" value="${ paging.criteria.perPage }" />
	</form> --%>

	<!-- 검색 부분 -->
	<form action="/main/vote/search" method="post">
		<select id="select" name="selectType">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
		</select> 
		<input type="text" id="keyword" name="keyword" /> 
		<input type="submit" value="검색">
	</form>
</div>

<a href="/main/vote/write">글 쓰기</a>


</body>
<script>
	let result = '<c:out value="${result}"/>';
	
	checkAlert(result);
	
	function checkAlert(result){
		if(result === ''){
			return;
		}
		if(result === "delete success"){
			alert("게시글이 삭제 되었습니다.");
		}
	}

</script>

</html>