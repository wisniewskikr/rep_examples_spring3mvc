<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<base href="${pageContext.request.contextPath}/">
</head>

<body>
<form action="input/handle-button-ok" method="post">
<div style="width: 400px; font-family: Arial; font-size: 9pt;">
	<table>
		<tr>
			<td colspan="2" style="padding-bottom: 10px;">
				<h2>Hello World</h2>
				<h3>Page: <b>Input</b></h3>
			</td>
		</tr>
		<tr>
			<td>Type your name:</td>
			<td><input type="text" id="name" name="name" value="${command.name}" size="10"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" id="ok" name="ok" value="OK"/>
			</td>
		</tr>		
	</table>
</div>
</form>
</body>

</html>