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
<spring:form id="form" name="form" method="post" commandName="command">

	<div class="list">
	
	
	
	
	
	
	
		
		<div id="secPageHeader">
			<ul>
				<li class="secPageTitle">Article List</li>
			</ul>
		</div>
		
		
		<div id="secPageActions">
			<ul>
				<li class="secPageAction">
					<a href="javascript:send('table/create-button');">Create</a>
				</li>
				<li class="secPageAction">
					<a href="javascript:send('secured/handle-article-list/view-article', 'command');">View</a>
				</li>
				<li class="secPageAction">
					<a href="javascript:send('secured/handle-article-list/edit-article', 'command');">Edit</a>
				</li>
				<li class="secPageAction">
					<a href="javascript:send('secured/handle-article-list/delete-article', 'command');">Delete</a>
				</li>
			</ul>		
		</div>
		
		
		<div id="secPageContent">
		
			<table class="secPageContentTable">			
				<c:choose>
					
							
					<c:when test="${command.users == null || 
									empty command.users}">
									
						<tr><td id="secPageContentTableNoData">No data</td></tr>
						
					</c:when>
					
					
					<c:otherwise>
						<c:forEach items="${command.users}" var="user">
						
						<tr class="secPageContentRow">
							<td class="secPageContentColumnPoint">
								<span class="secPageContentPoint"></span>
							</td>
							<td class="secPageContentColumnCheckbox">
								<input id="${user.id}" class="secPageContentCheckbox" type="checkbox"/>
							</td>
							<td class="secPageContentColumnText">
								<div class="secPageContentTitle"><a href="secured/view-article/${user.id}">${user.name}</a></div>
							</td>							
						</tr>
						
						</c:forEach>
					</c:otherwise>
					
					
				</c:choose>						
			</table>	
	
		</div>
		
		
		
		
		
		
		
		
	</div>		

</spring:form>
</body>


</html>