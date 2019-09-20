<%@page import="bean.TransferFundAccountSelect"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
<title>Insert title here</title>
</head>
<body>

<div id="main" class="container" class="page-header" >
 <img id="img1" src="bank.png">
	<div id="statement" class="container" class="form-group" >
<% 
int cid=(Integer)session.getAttribute("CID");
bean.TransferFundAccountSelect  tf=new TransferFundAccountSelect();
ResultSet rs=tf.account(cid);
ResultSet rs2=tf.payeeDisplay(cid);
while(rs2.next()){ %>
<form action="deletePayee1" method="post">
<tr>
<td>

<input type="radio" name="radio1" value=<%=rs2.getInt(2)%>><%=rs2.getInt(2)%><br><br>

</td>
</tr>
<%}%>
<button type="submit" name="delete" class="btn btn-default">Delete account</button>
</form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>