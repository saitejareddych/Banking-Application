package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

public class AddPayee {
	public boolean addPayee(long accNo,String nickName,int cid)
	{
		boolean flag=false;
		boolean flag2=false;
		try {
			Connection con=GetConnection.connection();	Statement stm=con.createStatement();
			
			
			ResultSet rs=stm.executeQuery("select accno from customeracc");
			while(rs.next())
			{
				if(accNo==(rs.getInt(1)))
				{
					flag2=true;
		    	}
			}
			if(flag2){
			PreparedStatement pstmt = con.prepareStatement("insert into payeedb values(?,?,?)");
			pstmt.setString(1,nickName);
			pstmt.setLong(2,accNo);
			pstmt.setInt(3,cid);
			pstmt.execute();
			flag=true;
			}
			else
			{
				return flag2;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
