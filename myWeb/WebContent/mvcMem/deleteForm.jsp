<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ��Ż��</title>
<script type="text/javascript">
function checkIt() {
	if(!document.myform.pass.value) {
		alert("��й�ȣ�� �Է����� �ʾҽ��ϴ�");
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
		<td colspan="2" align="center"><b>ȸ��Ż��</b>
	</tr>
	<tr>
		<td width="150"><b>��й�ȣ �Է�</b>
		<td width="110">
		<input type="password" name="pass" size="15"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="ȸ��Ż��">
		<input type="button" value="���" onclick="javascript:window.location.href='member.mdo?cmd=login'"></td>
	</tr>
	</table>
</body>
</html>