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

<li><a href="OrderPage">Order the Pizza</a></li>
<li><a href="OrderDetails.jsp">Order Details</a></li>
<li><a href="index.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<form action="OrderPage">
<table style="background-color: cyan">
<tr><th colspan="3">Order the Pizza</th></tr>
<tr><th>Pizza Name</th><th>Cost</th><th>Select</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	session=request.getSession(false);
	String cid=(String)session.getAttribute("cid");
	PreparedStatement ps=cn.prepareStatement("Select pid,Name,cost from Pizza where status='free'");
	
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>

<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>

<td><input type="radio" name="spc" value=<%=rs.getString(1) %>></td>

</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
<tr><td colspan="2"><input type="submit" value="Order" ></td></tr>
</table>
</form>
</body>
</html>