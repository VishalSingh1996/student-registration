<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Menu_3.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new</title>
</head>
<body>
<h2>New Registration</h2>
<form action="newReg" method="post">
<pre>
Name <input type="text" name="name"/>
Email <input type="text" name="email"/>
City <input type="text" name="city"/>
Mobile <input type="text" name="mobile"/>
<input type="submit" value="save"/>
</pre>
</form>
<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
}
%>
</body>
</html>