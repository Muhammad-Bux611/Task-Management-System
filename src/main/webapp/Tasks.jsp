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
<body>

<div class=" d-flex justify-content-center align-items-center vh-100 bg-success">	
		<form action="InsertTask" method="post" class="bg-info p-4 border border-primary border-4  rounded">
		<h1 class="text-center">Task</h1>
		
		<label class="form-label" for="topic">Enter Title</label>
		<br>
		<input class="form-control" type="text" name="title" id="topic" placeholder="Title" required>
		<br>
		
		<label class="form-label" for="discript">
		Enter the Discription
		</label>
		<br>
		<textarea class="form-control" rows="5" cols="50" name="discription" placeholder="Enter discription" id="discript" required></textarea>
		<br>
		<label class="form-label" for="dueDate">
		Enter due date of the Task:
		
		</label>
		
		<br>
		<input class="form-control" type="date" name="due" id="dueDate" placeholder="Select Due Data">
		<br>
		<input class="form-control btn btn-success" type="submit" value="Add Task">
		</form>
		</div>
		
</body>
</html>
