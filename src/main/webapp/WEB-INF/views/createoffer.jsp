<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="offer">
		<table class="formtable">
			<tr>
				<td class="label">Year:</td>
				<td><sf:input class="control" type="text" path="year" /> <br>
					<sf:errors path="year" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Semester:</td>
				<td><sf:input class="control" type="text" path="semester" /> <br>
					<sf:errors path="semester" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Course_id:</td>
				<td><sf:input class="control" type="text" path="course_id" /> <br>
					<sf:errors path="course_id" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Title:</td>
				<td><sf:input class="control" type="text" path="title" /> <br>
					<sf:errors path="title" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Division:</td>
				<td><sf:input class="control" type="text" path="division" /> <br>
					<sf:errors path="division" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Credit:</td>
				<td><sf:input class="control" type="text" path="credit" /> <br>
					<sf:errors path="credit" class="error" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="수강 신청">
				</td>
			</tr>
		</table>

	</sf:form>

</body>
</html>