<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<div class="container">
<h1>Register New User</h1>
<p class="message">${ message }</p>
<form action="/user-conf" method="post">
<label>Username:</label> <input class="inputbox" required name="username" pattern="[A-Za-z0-9]{3,10}"/>
<label>Password:</label> <input class="inputbox" required name="password" pattern="[A-Za-z0-9]{8,32}"/>
<label>Confirm Password:</label> <input class="inputbox" required name="passwordConf" pattern="[A-Za-z0-9]{8,32}"/>
<label>Email:</label> <input class="inputbox" name="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/>
<label>Full Name:</label> <input class="inputbox" required name="fullName" pattern="[A-Za-z]*[\s]*[A-Za-z]{2,80}"/>

<button type="submit" value="Submit">Submit</button>
</form>
</div>
</body>
</html>