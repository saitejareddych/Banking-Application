<%@page import="bean.FlagedUsers"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
FlagedUsers f=new FlagedUsers();
ResultSet rs=f.showFlaged();
while(rs.next()){ %>
<tr>
<td>
<div class=form-group>
<label>CID:  </label><label><%=rs.getInt(1)%></label><br>
<label>Account No:  </label><label><%=rs.getLong(2)%></label><br>
<label>Account Type:  </label><label><%=rs.getString(3)%></label><br>
<label>Flagged date:  </label><label><%=rs.getDate(4)%></label><br>
<hr>
</div>
</td>
</tr>
<%}%>

</body>
</html>