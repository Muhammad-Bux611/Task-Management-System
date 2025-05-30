<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LogIn | TO DO LIST TASK </title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
        
        </head>
        
<body class="   bg-info">

<div class=" d-flex justify-content-center align-items-center vh-100 bg-success">


<form action="LoginUser" method="post" class="bg-info p-4 border border-primary border-4  rounded">
		
		<h1 class="text-center bg-primary">Welcome, TO DO LIST PAGE</h1>
		<h2 class="text-center ">LOGIN</h2>
		
		<label  for="username" class="form-label">Enter your Email:</label>
		<br>
		<input type="email" name="mail" id="username" class="form-control" placeholder="Enter your username">
		<br>
		Enter your Password:
		<br>
		<input type="password" class="form-control" name="password" placeholder="Enter your password">
		<br>
		<input type="submit" class="btn btn-primary text-center w-100" value="Sign In">
		
		
		<div class="d-flex justify-content-center">
		 <label > SignUp? <a href="Registration.jsp">Register</a></label>
		 </div>
		</form>
		
		</div>
</body>
</html>
