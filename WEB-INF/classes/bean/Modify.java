package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modify {
public boolean phone(int cid,long phone)
{
	boolean flag=false;
	try {
		Connection con=GetConnection.connection();	PreparedStatement ps=con.prepareStatement("update customerdb set phonenumber=? where cid=?");
		ps.setLong(1,phone);
		ps.setInt(2,cid);
		ps.execute();
		flag=true;
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}
public boolean email(int cid,String email)
{
	boolean flag =false;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
		PreparedStatement ps=con.prepareStatement("update customerdb set email=? where cid=?");
		ps.setString(1,email);
		ps.setInt(2,cid);
		ps.execute();
		flag=true;
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return flag;
}
public boolean name(int cid)
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	boolean flag=false;
	return flag;
}
}
