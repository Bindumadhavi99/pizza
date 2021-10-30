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
<li><a href="OrderPage.jsp">Order the Pizza</a></li>
<li><a href="OrderDetails.jsp">Order Details</a></li>
<li><a href="index.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<table style="background-color: cyan">
<tr><th colspan="6">Personal Info</th></tr>
<tr><th>Customer ID</th><th>Password</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	session=request.getSession(false);
	String cid=(String)session.getAttribute("cid");
	PreparedStatement ps=cn.prepareStatement("Select * from customer where cid=?");
	ps.setString(1, cid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>
<br><br>
<table style="background-color: cyan">
<tr><th colspan="6">Odering Details</th></tr>
<tr><th>Pizza Name</th><th>Date of Order </th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	session=request.getSession(false);
	String cid=(String)session.getAttribute("cid");
	PreparedStatement ps=cn.prepareStatement("Select sid,dte from book where cid=?");
	ps.setString(1, cid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>

</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>

</body>
</html>