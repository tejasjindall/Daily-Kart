<%@page import="gimtt.com.CartModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
    background-color: 	#F8F8FF;
}
</style>
<body>
<h1>Ordered Items</h1>


<%

ArrayList ar =(ArrayList) session.getAttribute("CART");

for ( Iterator it = ar.iterator(); it.hasNext();){
	
	CartModel model =(CartModel) it.next();
out.print(model.getItemid()+ model.getItemName()+ model.getPrice() +" " +model.getQty()+" " + model.getTotalAmount());

}

%>
<br>

<form action="./?choice=checkout" method ="post">
<input type="submit" value="PROCEED">
</form>

</body>
</html>