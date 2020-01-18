<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>
<c:if test="${3>4 }">
이 내용은 화면 앙ㄴ나옴
</c:if>
<c:if test="${param.type eq 'guest' }">
회원님 방문을 환영
</c:if>
</body>
</html>