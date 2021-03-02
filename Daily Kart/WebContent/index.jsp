<%@page import="gimtt.com.modelas.CategoryModels"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    background-color: #F0F8FF;
}
</style>
</head>
<body>
<h1><center><i>Daily Kart</i></center></h1>
<center>
<img alt="kart" src="https://www.greenhopeessences.com/cart_icon.png" width="100" height="100">
</center>
<p>
<table>
<tr>
<td>
<form action="./" method ="post">
<input type="submit" value="HOME">
</form>
</td>
<td>
<form action="./?choice=about" method ="post">
<input type="submit" value="ABOUT US">
</form>
</td>
<td>
<form action="./?choice=2" method ="post">
<input type="submit" value="CONTACT US">
</form>
</td>
</tr>
</table>
</p> 
<h2>Product Categories</h2>
<ul>
<%
CategoryModels[] models = (CategoryModels[])request.getAttribute("CATMODELS");

for(int i =0; i<models.length; i++){
	out.print("<li>");
	CategoryModels m= models[i];
	out.print("<a href=\"./?choice=4&cat=");
	
	out.print(m.getId());
	out.print("\">");
	out.print(m.getProduct_type());
	out.print("</a>");
	out.print("</li>");
}


%>
</ul>
</body>
</html>