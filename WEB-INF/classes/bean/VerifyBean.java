package bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VerifyBean {
	
	public boolean verify(int id, String pwd)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Connection con=GetConnection.connection();	Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select  cid,password from logintable");
			while(rs.next())
			{
				if((rs.getInt(1)==id) && rs.getString(2).equals(pwd))
				{
					
					return true;
				}
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
