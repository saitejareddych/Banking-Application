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
<%
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe","system","admin");
	Statement stmt = con.createStatement();

	ResultSet rs = stmt.executeQuery("select * from customerreqdeleteacc");
	
	while(rs.next())
	{
	%>
	<form action="close.jsp" >
	<tr>
	<td>
	<div id="statement" class=form-group>
	<% out.println("Customer ID :            "+rs.getInt(1));%><br>
	<% out.println("Account Type :           "+rs.getString(2));%><br>
	<% out.println("Account Number :         "+rs.getInt(3));%><br><br>
	<%
	
		PreparedStatement pstmt = con.prepareStatement("insert into DELETEDB values(?,?,?)");
	
		pstmt.setInt(1,rs.getInt(1));
		pstmt.setInt(2,rs.getInt(3));
		pstmt.setString(3,rs.getString(2));
		pstmt.execute();
		pstmt.close();
	}
		//ResultSet rs2 = stmt.executeQuery("select * from customeracc where ACCNO="+AccNo);
		//rs2.updateInt(6,1);
		stmt.executeQuery("delete from customerreqdeleteacc");
		con.close();
		%>
		</div>
		</td>
		</tr>
		<button type="submit" class="btn btn-default">Close Account(s)</button>
		<%
	}
	
catch(Exception e)
{
	out.println(e);
}
%>
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>