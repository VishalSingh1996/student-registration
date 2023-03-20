<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Menu_3.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ALL Reg</title>
</head>
<body>
<%
HttpSession s=request.getSession(false);
if(s.getAttribute("email")!=null){
%>
<h2>All Registration</h2>
<table>
<tr>
<th>Name</th>
<th>Email</th>
<th>City</th>
<th>Mobile</th>
<th>Delete</th>
<th>Update</th>
</tr>

<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next()){
%>
<tr>
<td><%=result.getString(1) %></td>
<td><%=result.getString(2) %></td>
<td><%=result.getString(3) %></td>
<td><%=result.getString(4) %></td>
<td><a href="delete?email=<%=result.getString(2)%>">delete</a></td>
<td><a href="update?email=<%=result.getString(2)%>&mobile=<%=result.getString(4)%>">update</a></td>
</tr>
<%} %>

</table>
<%} else{
	RequestDispatcher rd = request.getRequestDispatcher("login_1.jsp");
	rd.forward(request, response);
	}
	%>

</body>
</html>