<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, jdbc.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beans를 사용한 데이터베이스 연동예제입니다.</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
<h2>Beans를 사용한 데이터베이스 연동 예제입니다</h2>
<br></br>
<h3>회원정보</h3>
<table bordercolor="#0000ff" border="1">
<tr>
	<td><strong>ID</strong></td>
	<td><strong>PASSWD</strong></td>
	<td><strong>NAME</strong></td>
	<td><strong>MEN_num1</strong></td>
	<td><strong>MEN_num2</strong></td>
	<td><strong>E_MAIL</strong></td>
	<td><strong>PHONE</strong></td>
	<td><strong>ZIPCODE</strong></td>
	<td><strong>JOB</strong></td>
</tr>
<jsp:useBean id="dao" class="jdbc.TempMemberDAO" scope="page" /> <%-- 이거하나로 객체로써 들고다니는게 가능해짐(코딩량이 반으로 줄었음) --%>
<%
Vector<TempMemberVO> vlist = dao.getMemberList(); //vlist에 셋팅한값 넣어준다
int counter = vlist.size();
for(int i=0; i<vlist.size(); i++) {
	TempMemberVO vo = vlist.elementAt(i);
%>
<tr>
<td><%=vo.getId() %></td>
<td><%=vo.getPasswd() %></td>
<td><%=vo.getName() %></td>
<td><%=vo.getMem_num1() %></td>
<td><%=vo.getMem_num2() %></td>
<td><%=vo.getEmail() %></td>
<td><%=vo.getPhone() %></td>
<td><%=vo.getZipcode() %>/<%=vo.getAddress() %></td>
<td><%=vo.getJob() %></td>
<%
	}
%>
</tr>
</table>
<br></br>
total records : <%= counter %>
</body>
</html>