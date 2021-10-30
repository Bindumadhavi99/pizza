<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="MyStyle.css">
</head>
<body>
<%@page import="java.sql.*,packon.*" %>
<table>
<tr>
<td>
<ul>
<li><a href="index.html">Home</a></li>
<li><a href="Register.html">User registration</a></li>
<li><a href="LOGIN.html">User Login</a></li>
<li><a href="Pizzainfo.jsp">PIZZA Information</a></li>
<li><a href="contact.html">Contact Us</a></li>
<li><a href="AboutUs.html">About Us</a></li>
</ul>
</td>
</tr>
</table>
<table border="2">
<tr><th>Pizza Name</th><th>Cost</th><th>Status</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	PreparedStatement ps=cn.prepareStatement("Select Name,cost,status from Pizza");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>

</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>
</body>
</html>