<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test = '${param.c== "skyblue" }'>
			<h1 style = "color:pink;">Hello JSTL!!</h1>
		</c:when>
		<c:when test = '${param.c== "pink" }'>
			<h1 style = "color:pink;">Hello JSTL!!</h1>
		</c:when>
		<c:when test = '${param.c== "maroon" }'>
			<h1 style = "color:maroon;">Hello JSTL!!</h1>
		</c:when>
		<c:otherwise>
			<h1 style = "color:silver;">Hello JSTL!!</h1>
		</c:otherwise>
	</c:choose>
	<!--  
	<h1 style = "color:skyblue">Hello JSTL!!</h1>
	<h1 style = "color:green">Hello JSTL!!</h1>
	<h1 style = "color:pink">Hello JSTL!!</h1>
	<h1>Hello JSTL!!</h1>
	-->
</body>
</html>