<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>	

<html>


<head>
	<title>Hello World</title>
	<base href="${pageContext.request.contextPath}/">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/jquery-ui-1.10.3/smoothness/jquery-ui-1.10.3.custom.css">
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.js"></script>
	<script type="text/javascript" src="js/script.js"></script>	
</head>


<body>
<spring:form id="form" name="form" method="post" commandName="command">

	<div class="page">
		<div class="title"><h2>Hello World</h2></div>
		<div class="subtitle"><h3>Page: <b>View</b></h3></div>
		<div class="content">
			<div class="contentElement">
				<div class="text">Selected name is: </div>
				<div class="input"><input type="text" id="userName" name="userName" value="${command.userName}" disabled="disabled"/></div>
				<div class="description">You can not edit name here</div>
			</div>
			
		</div>
		<div class="buttons">
			<input type="button" id="cancel" name="cancel" value="Cancel" onclick="send('delete/cancel-button');" title="Go back to list of users"/>
		</div>
	</div>		

</spring:form>
</body>


</html>