<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration | TO DO LIST TASK</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">

</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-danger">

		<form action="RegisterUser" method="post" class="border border-primary border-4 rounded bg-success p-4 shadow">
		<h1 class="text-center">Welcome to Registration  page</h1>
		<h2 class="text-center">REGISTRATION</h2>
		<p>If you enter some wrong data the page will not move forward</p>
		<label for="fname"  class="form-label">Enter your  name:</label>
		<input  class="form-control" type="text" id="fname"  name="name" placeholder="Enter your name" required>
		
		<label for="surname" class="form-label">Enter your caste :</label>
		<input class="form-control" type="text" id="surname"  name="caste" placeholder="Enter your caste" required>
		
	
		<label for="username" class="form-label">Enter your Email :</label>
		<input class="form-control type="email" name="email" id="username" placeholder="enter your email" required>
				
		<label for="birthDay" class="form-label">Enter your date of birth :</label>
		<input class="form-control" type="date" name="dob" id="birthDay" placeholder="Your date of Birth" required> 
		
		<label for="pin" class="form-label">Enter password :</label>
		<input  type="password" name="password" id="pin" class="form-control" placeholder="Set the Strong Password" required>

		<label for="cfmpin" class="form-label">Confirm  password :</label>
		<input  type="password" name="cfmPassword" id="cfmpin" class="form-control" placeholder="Confirm Password" required>
		
		<input class="btn btn-info w-100 mt-4" type="submit" value="Register">
		
		</form>
</body>
</html>
