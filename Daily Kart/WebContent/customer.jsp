<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
    background-color: #F0FFF0;
}
</style>
<body>
<h1><center><i>Daily Kart</i></center></h1>
<center>
<h2>Enter Your Details Here</h2>
<img alt="kart" src="https://www.greenhopeessences.com/cart_icon.png" width="100" height="100">
</center>
<form action="./"  method ="get">
 Name<input type="text" name="name"> <br>
 <br>
Email_ID<input type="text" name="emailid">	<br>
<br>
Phone_No<input type="int" name="phone"><br>
<br>
Address<input type="text" name="address">	<br>
<input type="hidden" name="choice" value ="place_order">	<br>

<br><br>
<input type="Submit" name="action" value="Place Order">

</body>
</html>