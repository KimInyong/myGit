<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>
<b>request.getParameter() 메서드사용</b><br>
name 파라미터 = <%= request.getParameter("name") %><br>
address 파라미터= <%= request.getParameter("address") %><br>
<br></br>
<b>request.getParameterValues() 메서드 사용</b><br>
<%
	String[] values = request.getParameterValues("pet"); //펫을 받아와서 배열로 값을 받아옴
	if (values != null) {
		for (int i=0; i<values.length; i++) {
%>			
	<%= values[i] %>
<% 	
		}
	}
%>
<br>
<b>request.getParameterNames() 메서드 사용</b><br>
<%
	Enumeration<String> enumData = request.getParameterNames(); //값이 아닌 변수명을 받아옴
	while(enumData.hasMoreElements()) {
		String enumName= (String)enumData.nextElement(); //enumName값은 변수명임 값이 아니다
		Map parameterMap = request.getParameterMap();
		String [] nameParam = (String[])parameterMap.get(enumName);
		if(nameParam != null) {
%>		
	<%= enumName %><br>
	<%= nameParam[0] %>
	
	
	
<%	
	}
	}
%>
<br>
<b>request.getParameterMap() 메서드 사용</b><br>
<%
	
			
%>
	
<%
	
	
%>
</body>
</html>