<%@page import="bean.TransferFundAccountSelect"%>
<%@page import="java.sql.*"%>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
<title>Transfer Fund</title>

</head>
<body>
<%

int cid=(Integer)session.getAttribute("CID");
bean.TransferFundAccountSelect  tf=new TransferFundAccountSelect();
ResultSet rs=tf.account(cid);
ResultSet rs2=tf.payeeDisplay(cid);
%><h4>Select Account</h4><%
%>
<table>
<thead>
<tr>
<th>Account Number &ensp;&ensp;</th>
  <th>Account type &ensp;&ensp; </th>
  <th>Balance  </th>
  </tr>
  </thead>
</table><%
while(rs.next()){ %>

<form  action="beginController" method="post">



<div class=form-group >
<input type="radio" id="radio1" name="radio1" value=<%=rs.getInt(1)%>><td><%=rs.getString(1)%></td>       &ensp;&ensp;<td>                   <%=rs.getString(2)%></td>        &ensp;&ensp;<td>$<%=rs.getInt(3)%></td><br>
</div>

</tr>
<%}%>
<h4>Select Payees</h4>
<%
while(rs2.next()){ %>
<tr>
<td>
<div class=form-group>
<h5>Account number</h5><input type="radio" id="radio" name="radio" value=<%=rs2.getInt(2)%>><%=rs2.getInt(2)%><br>
</td>
Nick name:<%=rs2.getString(1)%>
</div>
</tr>
<%}%>
<table style="border-spacing:10px;">
<tr>
<td >
<div class=form-group >
<button type="submit"  class="btn btn-default" name="begin" value="Begin Payment">Begin Payment</button>
</div>

</td>
<td >
</form>
<form action="addPayee.html" method="post">
<div class=form-group >
<button type="submit"  class="btn btn-default" name="add" value="Add Payee">Add Payee</button>
</div>
</form>
</td>
<td>
<form action=deletePayee.jsp method="post">
<div class=form-group >
<button type="submit"  class="btn btn-default" name="remove" value="Delete Payee">Remove Payee</button>
</div>
</form>
</td>
</tr>
</table>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>