<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<html>


<head>
	<title>Hello World - Delete</title>
	<base href="${pageContext.request.contextPath}/">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/jquery-ui-1.10.3/smoothness/jquery-ui-1.10.3.custom.css">
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.js"></script>
	<script type="text/javascript" src="js/script.js"></script>	
</head>


<body>
<form:form id="form" name="form" method="post" commandName="command">
<input type="hidden" id="id" name="id" value="${command.id}"/>

	<div class="page">
		<div id="title" class="title"><h2 id="titleText">Hello World</h2></div>
		<div id="subtitle" class="subtitle"><h3 id="subtitleText">Page: <b>Delete</b></h3></div>
		<div class="content">
			<div class="contentElement">
				</br>
				<div id="confirmationText" class="text">Do you really want delete user: ${command.name}?</div>
			</div>
			
		</div>
		<div class="buttons">
			<input type="button" id="delete" name="delete" value="Delete" onclick="send('delete/delete-button');" title="Delete user"/>
			<input type="button" id="back" name="back" value="Back" onclick="send('delete/back-button');" title="Go back to list of users"/>
		</div>
	</div>		

</form:form>
</body>


</html>