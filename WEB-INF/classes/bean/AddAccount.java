package bean;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddAccount {
	static long number2;
	static String line;
	static int n=1;
	public boolean checkCid(int addCid,String accType,int balance)
	{
		boolean flag=false;
		boolean flag2=false;
		ResultSet rs1=null,rs=null;
		long accNo=account();
		try 
		{
			
			Connection con=GetConnection.connection();	
			Statement stmt =con.createStatement();
			Statement stmt1=con.createStatement();
			rs =stmt.executeQuery("select * from customeracc where CID="+addCid);
            rs1=stmt1.executeQuery("select count(*) from customeracc where  CID="+addCid+" and acctype='"+accType+"'");
			if(rs.next())
			{
				
				if(rs1.next() && rs1.getInt(1)<5)
				{	
					
					if(addCid==(rs.getInt(5)))
					{
						flag=true;
			    	}
					if(flag)
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
						PreparedStatement pstmt = con1.prepareStatement("insert into customeracc values(?,?,?,?,?,?)");
						pstmt.setLong(1,accNo);
						pstmt.setString(2,accType);
						pstmt.setInt(3,balance);
						pstmt.setDate(4,getCurrentDate());
						pstmt.setInt(5,addCid);
						pstmt.setInt(6,0);
						pstmt.execute();
						flag2=true;		
					}
					else
					{
						return flag;
					}
    		   } 
				else
				{
			          

				}
		  }
		}		
			catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag2;
	}
//----------------------------------------------------------------------------------------------------- account no creation
public long account()
{
	 try
	  {
   	      PrintWriter pw=new PrintWriter(System.out);
  		  RandomAccessFile raf = new RandomAccessFile("randomaccounts.txt", "rw");
		  fun2(raf);
		  raf.seek(0);
		 raf.writeBytes(number2+"");
		  raf.close();
		  
      }		  
	   catch(Exception e)
	   {
			  System.out.println("Exception:"+e);
	   } 
     return number2;
}	
public void fun2(RandomAccessFile raf) throws IOException
{
		
	File f = new File("randomaccounts.txt");
	
	line = raf.readLine();
	  
      if(line!=null)
      { 	  
         number2=Integer.parseInt(line);
         number2++;    
       
         return;
      }   
      number2= (int) (1*Math.pow(10.0,9.0) + 6* Math.pow(10.0,8.0) + 1*Math.pow(10.0,6.0) + (double)n) ;
      System.out.println(number2);
}
//----------s--------------------------------------
public java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}

}
