<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<jsp:useBean id="objt" class="bean.UserExists"></jsp:useBean>
  		<jsp:useBean id="obj" class="bean.VerifyBean"/>  
  				<%
  		int cid= Integer.parseInt(request.getParameter("CID"));
  		String pwd=request.getParameter("pwd");
  		
     

  		
  		boolean status=objt.verify(cid,pwd);
  	  	boolean accstatus=obj.verify(cid, pwd);
  		if(status){
  		%>
  		session.setAttribute("CID",new Integer(cid));
     session.setAttribute("pwd",pwd);
    
  		<jsp:forward page="customerHome.jsp"></jsp:forward>
  		<%
  		}
  		else{ 
  			if(accstatus){
  			%>
  			session.setAttribute("CID",new Integer(cid));
     session.setAttribute("pwd",pwd);
   
     session.setAttribute("DATE",d);
      
  			<jsp:forward page="verifyreg.jsp"></jsp:forward>
  			<%
  		}
  		else{
  		%>
  		<jsp:forward page="index.html"></jsp:forward>
  		<%
  		}
  		}
  		%>
  		
  		
</body>
</html>