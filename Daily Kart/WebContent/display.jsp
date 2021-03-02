<%@page import="gimtt.com.modelas.ShopModel"%>
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
    background-color: #FFF5EE;
}
</style>
<body>
<h1><center><i>Daily Kart</i></center></h1>
<center>
<img alt="kart" src="https://www.greenhopeessences.com/cart_icon.png" width="100" height="100">
</center>
<h2>Welcome to Shops</h2>


<%
ShopModel models [] = (ShopModel[])request.getAttribute("SHOPS");

for(int i =0; i<models.length; i++){
	out.print("<li>");
	ShopModel m= models[i];
	out.print("<a href=\"./?choice=5&cat=");
	
	out.print(m.getId());
	out.print("\">");
	out.print(m.getName());
	out.print("</a>");
	out.print("</li>");
}


%>
</body>
</html>