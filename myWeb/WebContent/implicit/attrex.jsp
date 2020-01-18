<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("pageAttribute", "김인용");
request.setAttribute("requestAttribute", "010-41651655454");
session.setAttribute("sessionAttribute", "dlsdyd@");
application.setAttribute("allpicationAttribute", "KG");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Example</title>
</head>
<body>
<ul>
	<li>이름 : <%=pageContext.getAttribute("pageAttribute") %></li>
</ul>
</body>
</html>