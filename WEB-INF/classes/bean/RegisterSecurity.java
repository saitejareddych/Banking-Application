package bean;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;


public class RegisterSecurity {
	


	
	public boolean register(int cid,String pwd,String ques1, String ans1,String ques2, String ans2)
	{
		
		boolean flag = false;
		try
		{
			Connection con=GetConnection.connection();PreparedStatement		pstmt = con.prepareStatement("update LOGINTABLE set SECURITY1 =?,ANSWER1=?, SECURITY2 =?,ANSWER2=? where CID="+cid);
			
			
			pstmt.setString(1, ques1);
			pstmt.setString(2, ans1);
			pstmt.setString(3, ques2);
			pstmt.setString(4, ans2);
			
			pstmt.executeUpdate();
			flag  = true;
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public void update(int cid,String pass){
		try {
			Connection con=GetConnection.connection();
			PreparedStatement pstmt = con.prepareStatement("update LOGINTABLE set FLAG=?,PASSWORD=? where CID="+cid);
		pstmt.setInt(1,1);
	
		pstmt.setString(2,pass);
		pstmt.execute();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


