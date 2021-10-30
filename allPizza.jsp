<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
table{
margin-left: auto;
margin-right: auto;
}
ul{
list-style-type: none;
margin: 0;
padding: 0;
overflow: hidden;
background-color: red;
}
li{
float: left;
}
li a {
display: block;
color: yellow;
text-align:Neon Green;
padding: 14px 16px;
text-decoration: none;
}
li a:hover {
	background-color: black;
}
</style>
 </head>
<body bgcolor="yellow">
<table>
<tr>
<td>
<ul>
<li><a href="adminhome.html">Home</a></li>
<li><a href="add.html">Add Pizza </a></li>
<li><a href="update.html">Modify Pizza</a></li>
<li><a href="delete.html">Delete Pizza</a></li>
<li><a href="UpDated menuCard.jsp">Menu Card</a></li>
<li><a href="allcust.jsp">Customer Info</a></li>
<li><a href="adminlogin.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<%@page import="java.sql.*,packon.*" %>
<table border="5">
<tr><th>Pizza ID</th><th>Pizza Name</th><th>Cost</th><th>Status</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	PreparedStatement ps=cn.prepareStatement("Select * from Pizza");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>

</body>
</html>   