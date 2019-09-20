<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.sql.*"%>
          <%@page import="javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
<title>Insert title here</title>
<SCRIPT LANGUAGE="JavaScript">
	function validDate(date)
	{
	    var matches = /^(\d{2})[-\/](\d{2})[-\/](\d{4})$/.exec(date);
	    if (matches == null) return false;
	    var d = matches[1];
	    var m = matches[2]-1;
	    var y = matches[3];
	    var composedDate = new java.util.Date(d, m, y);
	    return composedDate.getDate() == d &&
	           composedDate.getMonth() == m &&
	           composedDate.getFullYear() == y;
	}


// separate function to accommodate IE timing problem


</SCRIPT>
</head>
<body>
<div id="main" class="container" class="page-header" >
 <img id="img1" src="bank.png">
 <div id="statement" class="container" class="form-group" >
<form action=statementPeriod method="post">
<jsp:useBean id="objt" class="bean.UserExists"></jsp:useBean>
    		<a href=customerHome.jsp >Home</a><br><br>

<label>Select account:</label>
<br>
<% 		
     	int cid= (Integer)session.getAttribute("CID");
		try{
		ResultSet rs=bean.UserExists.getAcc(cid);
        while(rs.next())
             {
        	 %>
            	<input type="radio" value="<%=rs.getString(1)%>" name="rad2"><%=rs.getString(1)%>
            	<br>
          	 <%
          	}
		}
		catch(Exception e) 
      	{ 
      		out.println(e); 
      		} 
             %>

<br><br>  
<label>From Date:</label> <INPUT TYPE="text" NAME="fromdate" 
    onChange="validDate(this)" class="form-control" placeholder="MM-DD-YYYY">
<label>To  Date:</label><INPUT TYPE="text" NAME="todate" 
    onChange="validDate(this)" class="form-control" placeholder="MM-DD-YYYY"><br>
<button type="submit" name="GetStatement" class="btn btn-default" >Get Statement</button>
</form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>