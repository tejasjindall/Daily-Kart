<%@page import="gimtt.com.modelas.ProductModel"%>
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
    background-color: 	#FFFAF0;
}
</style>
<body>
<h1><center><i>Daily Kart</i></center></h1>
<h2><center><i>Products</i></center></h2>

<%

ProductModel models [] =(ProductModel[]) session.getAttribute("PRODUCTS");
out.print("<table>");

out.print("<Tr><td>Name </td><td>Brand </td> <td>price </td><td>Qty </td>  </tr>");

 
for(int i=0; i<models.length; i ++){ %>
	<form action ="./" method ="post">
	<%
	
	out.print("<tr>");
	
	out.print("<td>");
	ProductModel m= models[i];
	out.print(m.getName());
	//out.print("<a href=\"./?choice=5&cat=");
	
	//out.print(m.getId());
	//out.print("\">"+ "</td>"); 
	
	out.print("<td>");
	out.print(m.getBrand());
	out.print("</td>");
	out.print("<td>");
	out.print(m.getPrice());
	out.print("</td>");
	out.print("<td>" );
	out.print("<input type=\"input\" name=\"qchoice\" />");
	out.print("<input type=\"hidden\" name=\"choice\" value =\"7\" /> ");
	out.print("<input type=\"hidden\" name=\"itemid\" value = "+models[i].getId()+" />" );
 
	out.print("</td>" );	
	

	out.print("<td>" );
	out.print("<input type=\"submit\" value=\"Add to cart\">");
	out.print("</td>" );
	out.print("</form>");
	out.print("</tr>");	
%>
	
	<%out.print("</td>");
	 
}
out.print("</table>");


	


%>
<form action="./" method ="post">

<input type="hidden" name="choice" value ="showcart" />
   
   <input type="submit" value="submit">
</form>


</body>
</html>