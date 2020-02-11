<%@page import="com.douzone.guestbook.dao.GuestBookDao"%>
<%@page import="com.douzone.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	Long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setNo(no);
	vo.setPassword(password);
	
	
	Boolean result = new GuestBookDao().delete(vo);

	if(result){
		response.sendRedirect("/guestbook01");		
	} else {
		response.sendRedirect("/guestbook01/deleteform.jsp?no="+no);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>삭제확인 폼입니다.</h1>
</body>
</html>