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
</style>
</head>
<body>
<%@page import="java.sql.*,packon.*" %>
<form name="frm" action="Update">
<table border=1>
<%
try{
	String sid=request.getParameter("pid");
	session=request.getSession();
	session.setAttribute("pid",sid);
	Connection cn=GetConnection.getCn();
	PreparedStatement ps=cn.prepareStatement("select size,cost from Pizza where pid=?");
	ps.setString(1, sid);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
%>
<tr>
<td>Modify Pizza Name</td><td><input type="text" name="Pizza" value=<%=rs.getString(1) %>></td></tr>
<tr>
<td>Modify Pizza Cost</td><td><input type="text" name="cost" value=<%=rs.getString(2) %>></td>
</tr>
<%}else{ %>
<tr><td>
<font color="red">Sorry Pizza not found</font><br>
<a href="update.html">Back</a>
</td></tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
<tr><td colspan="2"><input type="submit" value="Update"></td></tr>
</table>
</form>
</body>
</html>