<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Customers</title>
</head>
<body>

<form method="post" action="details">
Enter Customer ID:<input type="text" name="cid">
Enter Customer Name:<input type="text" name="cname">
Enter Customer Email Address:<input type="email" name="cemail">
<input type="submit" value="Submit">
<a href="http://localhost:8080/getdetails">Click here for the details</a>
</form>
</body>
</html>