<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학년/학기별 이수 총 학점</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<table class="formtable2">
	<thead>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수 학점</th>
			<th>상세 보기</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="offer" items="${offers}">
			<tr>
				<td><c:out value="${offer.year}"></c:out></td>
				<td><c:out value="${offer.semester}"></c:out></td>
				<td><c:out value="${offer.credit}"></c:out></td>
				<td><a
					href="${pageContext.request.contextPath}/suboffers?year=${offer.year}&semester=${offer.semester}">링크</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</html>