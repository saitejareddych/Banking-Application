package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetConnection {
	static Connection  con=null;
	public static Connection connection(){ 
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
		
 	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	return con;
	}
}

