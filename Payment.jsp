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
	String senderAccNo=(String)request.getAttribute("senderAccNo");
String receiverAccNo=(String)request.getAttribute("receiverAccNo");
%>
<h4><%=senderAccNo %>&emsp;TO&emsp;<%=receiverAccNo %></h4>
<form action="paymetController" method=post>
<input type=hidden name=senderNo value=<%=senderAccNo %>>
<input type=hidden name=receiverNo value=<%=receiverAccNo %>>
<label>Comments</label>
<input type=text name='notes' class="form-control" required>
<label>Payment amount</label>
<input type=text name='amount' class="form-control" pattern=[1-9][0-9]{0,9} title="Invalid amount Entered"  required><br>
<button type="submit"  class="btn btn-default" name="ConfirmPayment">Confirm Payment</button>
</form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>