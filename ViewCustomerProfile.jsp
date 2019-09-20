<%@ page import="java.io.IOException,java.io.PrintWriter,java.sql.*,java.io.*,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.SQLException,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse" language="java" contentType="text/html; charset=ISO-8859-1"
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
 </div>
 
<%
	try
		{
		int CID =(Integer)session.getAttribute("CID");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("select * from customerdb where CID="+CID);
		while(rs.next())
			{
%>
		<div id="statement" class="container" class="form-group"  >
		<a href=customerHome.jsp >Home</a><br><br>
		<table class="table-striped" style="width:500px">
			<tr>
			<td  ><%out.print("SSN");%></td> <td><%out.println(rs.getInt(1));%></td>
			</tr>
			<tr>
			<td><%out.print("USERNAME");%></td> <td><%out.println(rs.getString(3));%></td>
			</tr>
			<tr>
			<td><%out.print("ADDRESS");%></td> <td><%out.println(rs.getString(6));%></td>
			</tr>
			<tr>
			<td><%out.print("STATE");%></td><td><%out.println(rs.getString(7));%></td>
			</tr>
			<tr>
			<td><%out.print("COUNTRY");%></td><td><%out.println(rs.getString(8));%></td>
			</tr>
			<tr>
			<td><%out.print("PINCODE");%></td> <td><%out.println(rs.getInt(9));%></td>
			</tr>
			<tr>
			<td><%out.print("PHONE NO.");%></td><td><%out.println(rs.getInt(10));%></td>
			</tr>
			<tr>
			<td><%out.print("EMAIL");%></td> <td><%out.println(rs.getString(11));%></td>
			</tr>
			</table>
		</div>
		<% 
			}
		con.close();
		}
		catch(Exception e)
		{
		out.println(e);
		}%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

</body>
</html>