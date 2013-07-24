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
	<script type="text/javascript">
		$(function() {
	    	$( document ).tooltip();
	  	});
	</script>	
</head>


<body>
<spring:form method="post" action="input/handle-button-ok" commandName="command">

	<div class="page">
		<div class="title"><h2>Hello World</h2></div>
		<div class="subtitle"><h3>Page: <b>Hello</b></h3></div>
		<div class="content">
			<div class="contentElement">
				<div class="text">Name * <spring:errors path="name" cssClass="error" /> </div>
				<div class="input"><input type="text" id="name" name="name" value="${name}" title="Type your name here"/></div>
				<div class="description">Type your name here</div>
			</div>
			
		</div>
		<div class="buttons">
			<input type="submit" id="ok" name="ok" value="OK"/>
		</div>
	</div>		

</spring:form>
</body>


</html>