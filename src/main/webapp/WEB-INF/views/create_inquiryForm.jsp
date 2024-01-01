<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inquiry Form</title>
</head>
<body>
<h2>Inquiry Form</h2>

<form action="inqForm" method="post">

<pre>
Name:<input type="text" name="name" />
Email:<input type="text" name="email" />
Date:<input type="date" name="date" />
Inquiry Table:<input type="text"  name="inqTable" />
Inquiry Description:<input type="text" name="inqDesc" />
<input type="submit" value="save"> 

</pre>

</form>

<%
if(request.getAttribute("msg")!=null){
out.println(request.getAttribute("msg"));
}
%>
</body>
</html>