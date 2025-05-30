<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.toDoListModel.*" %>
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
<body>
			
			<%
					TasksEntity entity = (TasksEntity)session.getAttribute("result");
			
			String email = entity.getUser().getEmail();
			String title = entity.getTitle();
			String dic = entity.getDiscription();
			Date dueDate = entity.getDueDate();
			
			int id =  Integer.parseInt(request.getParameter("id"));
			%>
		
<div class=" d-flex justify-content-center align-items-center vh-100 bg-success">
		
			<form action="EditTasks?id=<%= id %>" method="post"  class="bg-info p-4 border border-primary border-4  rounded">
				<label class="form-label" for="title">Edit title:</label>
				<input class="form-control" id="title" placeholder="Text" type="text" name="title" value="<%= title %>">
				<br>
					<label class="form-label" for="dics">Edit Discription:</label>
					<br>
					<textarea class="form-control" rows="5" cols="60" id="dics" name="discription">
					<%= dic %>
					</textarea>
				<br>
				
				<label class="form-label" for="dues">Edit Your Date:</label>
				<input class="form-control" id="dues" placeholder="Text" type="date"  name="due" value="<%= dueDate %>">
				<br>
				
				<input class="form-control btn btn-primary" type="submit" value="Update" id="button-1"/>
			</form>
			</div>
</body>
</html>