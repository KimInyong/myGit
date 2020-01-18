<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.*, jdbc.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ConnectionPool pool = ConnectionPool.getInstance();
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id = "",
			passwd = "",
			name = "",
			men_num1 = "",
			men_num2 = "",
			e_mail = "",
			phone = "",
			zipcode = "",
			address = "",
			job = "";
	int counter = 0;
	try {								  
		conn = pool.getConnection();
				//DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","dlsdyd1245","tmxk5313");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from tempmember");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP에서 데이터베이스 연동</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgclor="#FFFFCC">
<h2>JSP 스크립틀릿에서 데이터베이스 연동 예제입니다.</h2><br></br>
<h3>회원정보</h3>
<table bordercolor="#0000fff" border="1">
<tr>
	<td><strong>id</strong></td>
	<td><strong>passwd</strong></td>
	<td><strong>name</strong></td>
	<td><strong>men_num1</strong></td>
	<td><strong>men_num2</strong></td>
	<td><strong>e_mail</strong></td>
	<td><strong>phone</strong></td>
	<td><strong>zipcode/address</strong></td>
	<td><strong>job</strong></td>
</tr>
<%
	if(rs!=null) {
		while(rs.next()) {
			id = rs.getString("id");
			passwd = rs.getString("passwd");
			name = rs.getString("name");
			men_num1 = rs.getString("men_num1");
			men_num2 = rs.getString("men_num2");
			e_mail = rs.getString("e_mail");
			phone = rs.getString("phone");
			zipcode = rs.getString("zipcode");
			address = rs.getString("address");
			job = rs.getString("job");
%>
<tr>
<td><%= id %></td>
<td><%= passwd %></td>
<td><%= name %></td>
<td><%= men_num1 %></td>
<td><%= men_num2 %></td>
<td><%= e_mail %></td>
<td><%= phone %></td>
<td><%= zipcode %></td>
<td><%= job %></td>
<%
	counter++;
		}//end while
	}//end if
%>
</tr>
</table><br></br>
total records : <%= counter %>
<%
	}catch(SQLException sqle) {
		System.out.println("sql exception");
	}catch(Exception e) {
		System.out.println("exception");
	}finally {
		if(rs != null) 
			try {rs.close(); }
			catch(SQLException ex) {}
		if( stmt != null)
			try {stmt.close(); }
			catch(SQLException ex) {}
		if( conn != null)
			try{ 
				pool.releaseConnection(conn);
				//conn.close();
				}
			catch(Exception ex) {}
	}
%>

</body>
</html>