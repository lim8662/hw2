<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body onload='document.f.username.focus();'>
	<h3>Custom Login with Username and Password</h3>
	
	<c:if test="${not empty logoutMsg}"/>
			<div style="color:#0000ff"> <h3>${logoutMsg}</h3></div>	
	
	<form name='f' action="<c:url value="/login"/>" method='POST'>
	
		<c:if test="${not empty errorMsg}"/>
			<div style="color:#ff0000"> <h3>${errorMsg}</h3></div>	
		<table class="formtable">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</table>
	</form>
</body>
</html>