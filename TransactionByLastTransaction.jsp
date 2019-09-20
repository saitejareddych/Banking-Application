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
</head>
<body>
<div id="main" class="container" class="page-header" >
 <img id="img1" src="bank.png">
 <div id="statement" class="container" class="form-group" >
<form action=genStatement method="post" >
<jsp:useBean id="obj" class="bean.UserExists"></jsp:useBean>
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
            	<input type="radio" value="<%=rs.getString(1)%>" name="rad1"><%=rs.getString(1)%>
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
<label> Enter last 'n' number of transactions</label>
<input type="text" name="noofdays" class="form-control"><br>
 
<button type="submit" name="GetStatement" class="btn btn-default" >Get Statement</button>
</form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>