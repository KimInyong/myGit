<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>delete process</title>
</head>
<body>
<c:set var="result" value="${result }" />
<c:if test="${result eq 0 }"><script type="text/javascript">alert("비밀번호가 틀렸습니다.");</script></c:if>
회원 정보가 삭제되었습니다.

</body>
</html>