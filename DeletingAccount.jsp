<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="mystyle.css"/>
</head>
<body>
<div id="main" class="container" class="page-header" >
 <img id="img1" src="bank.png">
<form action=finalClose method="post">
<div id=statement>
<% ResultSet rs=(ResultSet)session.getAttribute("delete"); 
%>
<table>
<tr>
<th>Account Number &ensp;</th>
  <th>Account type  </th>
</table>

<%
	try {
		
		while(rs.next()){
			%>
			<tr>
			<input type=hidden name=cid value=<%=session.getAttribute("CID") %>>
			
			<input type="radio" value="<%=rs.getString(1)%>" name="rad1"><td><%=rs.getString(1)%></td>  &ensp;<td><%=rs.getString(2)%></td>
			<br><br>
			</tr>
			<%
		}
		
	} 
	catch (SQLException e) {
		
		e.printStackTrace();
	}


%>

<button type="submit" class="btn btn-default">Delete</button>
</div>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>