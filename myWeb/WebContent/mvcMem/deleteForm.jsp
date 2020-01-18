<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원탈퇴</title>
<script type="text/javascript">
function checkIt() {
	if(!document.myform.pass.value) {
		alert("비밀번호를 입력하지 않았습니다");
		document.myform.pass.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body onload="javascript:document.myform.pass.focus();">
	<form action="member.mdo?cmd=deleteProc" name="myForm" method="post" onsubmit="return checkIt()"></form>
	<table width="260" border="1" align="center">
	<tr>
		<td colspan="2" align="center"><b>회원탈퇴</b>
	</tr>
	<tr>
		<td width="150"><b>비밀번호 입력</b>
		<td width="110">
		<input type="password" name="pass" size="15"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="회원탈퇴">
		<input type="button" value="취소" onclick="javascript:window.location.href='member.mdo?cmd=login'"></td>
	</tr>
	</table>
</body>
</html>