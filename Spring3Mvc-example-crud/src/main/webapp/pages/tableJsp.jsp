<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>	
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

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
<spring:form modelAttribute="command">

	<div class="page">
		<div class="title"><h2>Hello World</h2></div>
		<div class="subtitle"><h3>Page: <b>Table</b></h3></div>
		<div class="content">
		
			<spring:errors path="*" cssClass="errorblock" element="div" />
			
			<div class="listHeader">
				<ul>
					<li class="listHeaderTitle">User List</li>
				</ul>
			</div>
		
			<div class="listActions">
				<ul>
					<li>
						<a href="javascript:sendWithModel('table/handle-table-action/create', 'command');">Create</a>
					</li>
					<li>
						<a href="javascript:sendWithModel('table/handle-table-action/view', 'command');">View</a>
					</li>
					<li>
						<a href="javascript:sendWithModel('table/handle-table-action/edit', 'command');">Edit</a>
					</li>
					<li>
						<a href="javascript:sendWithModel('table/handle-table-action/delete', 'command');">Delete</a>
					</li>
				</ul>		
			</div>
			
			<div class="listItems">
				<c:choose>
					<c:when test="${command.users == null || 
									empty command.users}">
						<span>No Data</span>			
					</c:when>
					<c:otherwise>
						<spring:checkboxes element="div" items="${command.users}" itemLabel="name" itemValue="id" path="selectedUsersIds"/>
					</c:otherwise>
				</c:choose>	
			</div>
			
			
		</div>
		
	</div>		

</spring:form>
</body>
</html>