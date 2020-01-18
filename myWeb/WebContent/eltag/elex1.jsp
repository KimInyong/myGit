<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="actiontag.Customer, java.util.HashMap" %>
<%
	Customer customer = new Customer();
	customer.setName("손오공");
	customer.setEmail("ads@nasdf.adf");
	customer.setPhone("010-1234-1234");
	request.setAttribute("customer", customer);
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("name", "소나타");
	map.put("maker", "현대자동차");
	request.setAttribute("car", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el</title>
</head>
<body>
<ul>
	<li>이름 : ${customer.name }</li>
	<li>${customer.email }</li>
	<li>${customer.phone }</li>
</ul>
<br>
<ul>
	<li>${car.name }</li>
	<li>${car.maker }</li>
</ul>
</body>
</html>