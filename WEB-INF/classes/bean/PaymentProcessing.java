package bean;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class PaymentProcessing {
	boolean flag=false;
	static int number1;
	public boolean pay(String senderAccNo,String receiverAccNo,String notes,int amount,int cid){
		int ref=refId();
		int ref2=refId();
		long senderNo=Integer.parseInt(senderAccNo);
		long receiverNo=Integer.parseInt(receiverAccNo);
		ResultSet rs;
		int balance=0;
		String emailSender=null;
		String emailReceiver=null;
		
		int balanceR=0;
		try {
			Connection con=GetConnection.connection();
			Statement stmt =con.createStatement();
			rs =stmt.executeQuery("select balance from customeracc where  accno="+senderNo);
			while(rs.next()){
			balance=rs.getInt(1);
			}
		
			ResultSet rs2 =stmt.executeQuery("select balance from customeracc where  accno="+receiverNo);
			while(rs2.next()){
				balanceR=rs2.getInt(1);
				}
			if(amount>balance)
			{
				return false;
			}
			else
			{
				int senderB=(balance-amount);
				int receiverB=(balanceR+amount);
				System.out.println(balance);
				System.out.println("rec"+balanceR);
				System.out.println(amount);
				System.out.println(senderB);
				System.out.println("rec"+receiverB);
			PreparedStatement pstmt = con.prepareStatement("insert into transactiondb values(?,?,?,?,?,?,?)");
			pstmt.setInt(1,ref);
			pstmt.setString(2,"DR");
			pstmt.setString(3,notes);
			pstmt.setInt(4,amount);
			pstmt.setLong(5,senderNo);
			pstmt.setDate(6,getCurrentDate());
			pstmt.setInt(7,0);
			//---------------------------------------
			PreparedStatement pstmt1 = con.prepareStatement("insert into transactiondb values(?,?,?,?,?,?,?)");
			pstmt1.setInt(1,ref2);
			pstmt1.setString(2,"CR");
			pstmt1.setString(3,notes);
			pstmt1.setInt(4,amount);
			pstmt1.setLong(5,receiverNo);
			pstmt1.setDate(6,getCurrentDate());
			pstmt1.setInt(7,0);
			pstmt.execute();
			pstmt1.execute();
			Statement pstmt2 = con.createStatement();
			pstmt2.addBatch("update customeracc set balance="+senderB+" where accno="+senderNo);
			
			pstmt2.addBatch("update customeracc set balance="+receiverB+" where accno="+receiverNo);
		
			pstmt2.executeBatch();
			flag=true;
			
			
			
			ResultSet rs0=null,rs1=null,r2=null,rs3=null,rs4=null;
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
			Statement stmt0 =con1.createStatement();
			Statement stmt1=con1.createStatement();
			Statement stmt2=con1.createStatement();
			Statement stmt3=con1.createStatement();
			Statement stmt4=con1.createStatement();
		    bean.Transdate a=new Transdate();
			String getCurrentDate=a.day();
			rs1=stmt1.executeQuery("select sum(amount) from transactiondb where accountno in(select accno from customeracc where cid="+cid+"and transdate='"+getCurrentDate+"' and CRDR='DR')"); 
			 r2=stmt2.executeQuery("select cid from customeracc where accno="+receiverAccNo);
			if(r2.next())
			{
				cid=r2.getInt(1);
			}
			rs3=stmt3.executeQuery("select sum(amount) from transactiondb where accountno in(select accno from customeracc where cid="+cid+"and transdate='"+getCurrentDate+"' and CRDR='CR')");
			rs0 =stmt0.executeQuery("select * from transactiondb where accountno="+senderAccNo);
			rs4 =stmt4.executeQuery("select * from transactiondb where accountno="+receiverAccNo);
			if(rs1.next())
			{	
				if(rs1.getInt(1)>=10000)
				{	
			    	while(rs0.next())
				    {
					    stmt0.executeUpdate("update transactiondb set flag=1");
				    }
			   
				}
			
			}
			if(rs3.next())
			{
				if(rs3.getInt(1)>=10000){
					while(rs4.next())
			    	{
			    		stmt0.executeUpdate("update transactiondb set flag=1");
			    	}
				}
			}
			
			if(flag)
			{
				Statement tmt=con.createStatement();
				ResultSet r=tmt.executeQuery("select email from customerdb where cid=(select cid from customeracc where accno="+senderNo+")");
				while(r.next())
				{
					emailSender=r.getString(1);
					System.out.println(emailSender);
				}
				Statement tmt1=con.createStatement();
				ResultSet r1=tmt.executeQuery("select email from customerdb where cid=(select cid from customeracc where accno="+receiverNo+")");
				while(r1.next())
				{
					emailReceiver=r1.getString(1);
					System.out.println(emailReceiver);
				}
				bean.SenderEmail s=new SenderEmail();
				s.approve(emailSender, amount,senderNo);
				bean.ReceiverEmail rec=new ReceiverEmail();
				rec.approve(emailReceiver, amount,receiverNo);
			
			}
			con.close();
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	public int refId()
	{
	    try
		  {
			  
			  PrintWriter pw=new PrintWriter(System.out);
			  PrintWriter pw1=new PrintWriter(new FileOutputStream("RandomRefid.txt",true));       
			  BufferedReader br = new BufferedReader(new FileReader("RandomRefid.txt"));
			  fun1(br);
			  
			    pw1.println(number1);		
			     pw1.flush();
			     pw1.close();
			  
	     }		  
			  catch(Exception e)
			  {
				  System.out.println("Exception:"+e);
			  } 
	    
	    return number1;
	}	
	static void fun1(BufferedReader br)
	{
		  boolean flag = false;
		  String lin = null;
		  int num = 0;
		  try
		  {
				  num=getint();
	           while((lin=br.readLine())!=null)
	  		 {
	          	 int n = Integer.parseInt(lin);
	          	 if(n==num)
	          		 flag = true;
				 }
	           if(!flag)
	           {
	          	 number1 = num;
	           }
	    }
	    catch(Exception e)
	    {
	       System.out.println(e);
	    }
		
	 }
	static int getint()
	{
	   Random random = new Random();
	   int x = random.nextInt(90000000)+10000000;
	   return x;
	}  
	//------------------------------------------------------------------
	public java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	//---------------------------------------------------------------------
	
}
