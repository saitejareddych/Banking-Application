<%@ page errorPage="error.jsp" %>  
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
</head>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs-3.3.7/jqc-1.12.4/dt-1.10.15/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs-3.3.7/jqc-1.12.4/dt-1.10.15/datatables.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function() {
	    $('#display').DataTable();
	} );</script>



<body>
<div id="main" class="container" class="page-header" >
 <img id="img1" src="bank.png">
 <div id="statement">
     		<a href=customerHome.jsp >Home</a><br><br>
 
<table border="1" id="display">
<thead>
 <tr>
        <th>Transaction ID</th>
        <th>Credit/Debit</th>
        <th>Details</th>
        <th>Amount</th>
        <th>Account Number</th>
         <th>Date of Transaction</th>
   </tr>
   </thead>
<% ResultSet rs=(ResultSet)request.getAttribute("result");


	try {
		%>
		<tbody>
	<% 	
		while(rs.next()){
			%>
			<tr>
			<td><%out.println(rs.getInt(1)); %></td>
			<td><%out.println(rs.getString(2)); %></td>
			
			<td><%out.println(rs.getString(3)); %></td>
			<td><%out.println(rs.getFloat(4)); %></td>
			<td><%out.println(rs.getInt(5)); %></td>
			<td><%out.println(rs.getDate(6)); %></td>
			</tr>
			<%
		}
	%>
		</tbody>
<%
	
	} 
	catch (SQLException e) {
		
		e.printStackTrace();
	}

%>
</table>
<form action="pdfController" method="post">
<input type=hidden value=<%=request.getAttribute("accNo") %> name=accNo>
<input type="submit" value="Print All PDF">
</form>
</div>
</div>
</body>
</html>