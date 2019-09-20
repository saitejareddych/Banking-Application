<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action="security" method="post">
<div class="container" style="margin-top:5%;">
 <div class="form-group">
 		 
  		
 		
  		
  		<div class="form-group">
      		<label for="securityQuestion1">Security Question1(select one):</label>
      		<select class="form-control" id="securityQuestion1" name=SecQ1>
        		<option>First laptop brand?</option>
        		<option>First mobile brand?</option>
        		<option>Name of first school?</option>
        		<option>Childhood dream?</option>
      		</select>
      	</div>
      	<div class="form-group">
  			 <label for="securityAnswer1">Security Answer</label>
   			 <input type="text" class="form-control" id="securityAnswer1" name=SecA1 placeholder="Security Answer1" required>
  		</div>
  		<div class="form-group">
      		<label for="securityQuestion2">Security Question2(select one):</label>
      		<select class="form-control" name=SecQ2 id="securityQuestion2">
        		<option>What is the name of your favorite pet?</option>
        		<option>What high school did you attend?</option>
        		<option>What is your mother's maiden name?</option>
        		<option>What is your father's middle name?</option>
      		</select>
      	</div>
      	<div class="form-group">
  			 <label for="securityAnswer2">Security Answer</label>
   			 <input type="text" class="form-control" id="securityAnswer2" name=SecA2 placeholder="Security Answer2" required>
  		</div>
  		
  		<button type="submit" class="btn btn-default" >Submit</button>
 </form>	
</body>
</html>