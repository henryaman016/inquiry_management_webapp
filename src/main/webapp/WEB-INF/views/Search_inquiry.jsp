<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Inquiries</title>
</head>
<body>
<h2>Inquiries</h2>
<table>
<tr>
<th>Name:</th>
<th>Email:</th>
<th>Date:</th>
<th>Inquiry Table</th>
<th>Inquiry Description</th>
</tr>


<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next()){
%>

<tr>
<td><%=result.getString(1)%></td>
<th><%=result.getString(2)%></th>
<th><%=result.getString(3)%></th>
<th><%=result.getString(4)%></th>
<th><%=result.getString(5)%></th>
</tr>


<%
}
%>





</table>

</body>
</html>