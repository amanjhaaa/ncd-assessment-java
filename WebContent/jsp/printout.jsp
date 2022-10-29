<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= session.getAttribute("age") %>
<%= session.getAttribute("smoke") %>
<%= session.getAttribute("alcohol") %>
<%= session.getAttribute("measurement") %>
<%= session.getAttribute("physical") %>
<%= session.getAttribute("history") %>
</body>
</html>