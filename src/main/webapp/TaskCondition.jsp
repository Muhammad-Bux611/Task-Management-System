<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
        
</head>
<body >

	<%
	String name = (String)session.getAttribute("email");

	%>	
	<div class="d-flex justify-content-center align-items-center vh-100 bg-success ">
	<div class="container">
	<div class="row" >
	<h3 class="text-center" >Either You can Add some more Tasks  OR View Tasks</h3>
	</div>
	<div class="row">
	<div class="col offset-3">
	<a class="btn btn-primary"  href="Tasks.jsp">Add Some Task</a>
	</div>
	
	<div class="col">
	<a href="SeeTask?email=<%= name %>" class="btn btn-info">View Tasks</a>
	</div>
	
	</div>
	
	</div>
	</div>
	</body>
</html>