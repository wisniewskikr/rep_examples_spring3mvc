<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>


<head>
	<title>Hello World</title>
	<base href="${pageContext.request.contextPath}/">
	<script type="text/javascript" src="js/script.js"></script>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>


<body>
<form name="form" method="post" action="input/handle-button-ok">

	<table align="center" frame="border" class="mainTable">
		<tr>
			<td>
				<h2>Hello World</h2>
				<h3>Page: <b>Hello</b></h3>
			</td>
		</tr>
		<tr>
			<td>Type your name:	<input type="text" placeholder="First Name" id="name" name="name" value="${command.name}" size="10"/></td>
		</tr>
		<tr>
			<td><input type="submit" id="ok" name="ok" value="OK"/></td>
		</tr>		
	</table>

</form>
</body>


</html>