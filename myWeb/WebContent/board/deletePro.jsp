<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==1}">
	<meta http-equiv="Refresh" content=0;url=/myWeb/board/list.do?pageNum=${pageNum }">
</c:if>
<c:if test="${check==0 }">
��й�ȣ�� �ٸ��ϴ�.<br><br>
<a href="javascript:history.go(-1)">�ۻ��� ������ ���ư���</a>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>