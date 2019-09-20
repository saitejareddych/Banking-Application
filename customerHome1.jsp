<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://www.w3schools.com/lib/w3.js"></script>

<link rel="stylesheet" type="text/css" href="mystyle.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="main" class="container" class="page-header">
<img src="bank.png" style="height:100px;width:200px">
  <ul class="nav nav-tabs ">
    <li class="active tab0"><a data-toggle="tab" href="#fundTransfer">Fund Transfer</a></li>
    <li class="tab1"><a data-toggle="tab" href="#statement">Statement</a></li>
    <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Profile <b class="caret"></b></a>
   <ul class="dropdown-menu">
                <li><a href="ChangePassword.html">Change password</a></li>
                <li><a href="#">View profile</a></li>
                <li><a href="#">Something else here</a></li>
   </ul> 
   </li>
  </ul>
  <div class="tab-content">
  <div id="fundTransfer" class="tab-pane fade in active">
  <jsp:include page="TransferFund.jsp"/>
  </div>
  </div>
   	
 </div>
</body>
</html>