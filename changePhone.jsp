<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="mystyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="main" class="container" class="page-header" >
 <img id="img1" src="bank.png">
<div id=statement>
<form action=phoneController method=post>
<label>Enter new phone number</label><input type=text class=form-control name=phone pattern="[2-9][0-9][0-9][2-9][0-9][0-9][0-9][0-9][0-9][0-9]" title="Enter a valid 10 digit US phone number" required><br>
<input type=hidden name=cid value=<%=request.getAttribute("CID") %>>
<button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>