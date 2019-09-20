<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="refresh" CONTENT="300; URL=error.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://www.w3schools.com/lib/w3.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
 
</head>
<body>
<% response.setHeader("Refresh", session.getMaxInactiveInterval()+";URL=error.jsp"); %>
<div id="chmain" class="container" >
 <img id="img1" src="bank.png">
  <ul class="nav nav-tabs ">
    <li class="active tab0"><a data-toggle="tab" href="#fundTransfer">Fund Transfer</a></li>
    <li class="tab1"><a data-toggle="tab" href="#Statement">Statement</a></li>
    <li class="tab3"><a data-toggle="tab" href="#Profile">Profile</a></li>
     
   </ul> 
   </li>
  </ul>
  <div class="tab-content">
  <div id="fundTransfer" class="tab-pane fade in active">
  <jsp:include page="TransferFund.jsp"/>
  </div>
  <div id="Statement" class="tab-pane fade ">
  <div id="statement">
  <jsp:include page="Statement.jsp"/>
  </div>
  </div>
  
  <div id="Profile" class="tab-pane fade ">
  <div id="statement">
  				<li><a href="ChangePassword.html">Change password</a></li>
                <li><a href="ViewCustomerProfile.jsp">View profile</a></li>
                <li><a href="logout">Logout</a></li> 
                </div>
  </div>
  </div>
 </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>