<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복체크</title>
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<b>${id }</b>
<c:if test="${check eq true }">
는 이미 존재하는 ID입니다.<br>
</c:if>
<c:if test="${check eq false }">
는 사용 가능합니다
</c:if>
</body>
</html>