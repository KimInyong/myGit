<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
	request.setAttribute("name", "김인용");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
요청 URI : ${pageContext.request.requestURI}<br></br>
request의 name 속성 : ${requestScope.name}<br></br>
code 파라미터 : ${param.code}<br></br>
</body>
</html>