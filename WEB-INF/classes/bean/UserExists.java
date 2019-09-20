package bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserExists {
	static Connection con=null;
	public static Connection connection(){ 
		try{
			con=GetConnection.connection();
	 	}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
		}
	public boolean verify(int id, String pwd)
	{
	try
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		con=GetConnection.connection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select  cid,password,flag from logintable");
		while(rs.next())
		{
			if((rs.getInt(1)==id) && (rs.getString(2).equals(pwd)) && (rs.getInt(3)==1))
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
	public boolean verify(int id)
	{
	try
	{
		
		con=GetConnection.connection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select  cid from logintable");
		while(rs.next())
		{
			if((rs.getInt(1)==id))
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
	public boolean delete(int accno,int cid) {
		// TODO Auto-generated method stub
		try
		{
			
			con=GetConnection.connection();Statement stmt = con.createStatement();
			int id=0,acc1=0;
			String name=null;
			String email=null;
			ResultSet rs=stmt.executeQuery("select balance from customeracc where accno="+accno);
			ResultSet rs1=null,rs2=null,rs3=null;
			if(rs.next()){
				System.out.println(rs.getInt(1));
			if(rs.getInt(1)==0){
				 
				 acc1=accno;
					
				 System.out.println(id+" "+name+" "+email);
		
			 int p=stmt.executeUpdate("update customeracc set accstatus=1 where accno="+accno);
			 rs3=stmt.executeQuery("select count(*) from customeracc where accstatus=0 and cid="+cid);
			 if(rs3.next()){
				 int cnt=rs3.getInt(1);
				 if(cnt==0){
					 int k=stmt.executeUpdate("delete from logintable where cid ="+cid );
				 }
			 }
			 PreparedStatement ps=con.prepareStatement("insert into deletedb values(?,?,?,?)");
			 ps.setInt(1,id);
			 ps.setString(2, name);
			 ps.setString(3,email);
			 ps.setInt(4,acc1);
			 ps.execute();
			 
			return true;
			}
			}
			else{
				return false;
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
		
	}


	
	public static ResultSet getAcc(int cid) {
		   
		  ResultSet rs = null;
	    try {
	    	 
	    	con=GetConnection.connection();try {
	        	PreparedStatement ps;
	            ps=con.prepareStatement("select accno from customeracc where CID="+cid);
	           
	         rs=ps.executeQuery();
	         
	        
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	      return rs;
	}
	public static ResultSet getTrans(long acc,int n) {
		   
		 
		  ResultSet rs = null;
	    try {
	    	 
	    	con=GetConnection.connection();	Statement stmt=con.createStatement();
	        try {
	        	
	            
	           
	         //rs=stmt.executeQuery("select count(refid) from transactiondb where accountno="+acc);
	        
	        
	        rs=stmt.executeQuery("select * from "+"(select * from transactiondb where accountno="+acc+" )"+"where ROWNUM<="+(n));
	        System.out.println("executed");
	 
	        }catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	   
	      return rs;
	}
	public static ResultSet getPeriodTrans(int acc,String datefrom,String dateto){
	
		
		  ResultSet rs = null;
		    try {
		    	 
		    	con=GetConnection.connection();	Statement stmt=con.createStatement();
		        try {
	
		     System.out.println(datefrom);
		     System.out.println(dateto);
		         //rs=stmt.executeQuery("select count(refid) from transactiondb where accountno="+acc);
		        
		        
		        rs=stmt.executeQuery("select * from "+"(select * from transactiondb where accountno="+acc+" )"+"where transdate between '"+datefrom +"' and '"+dateto+"'");
		        System.out.println("executed");
		      
		        }catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		  
		      return rs;
	}
	public static ResultSet getAccDetails(int cid) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
	    try {
	    	 
	    	con=GetConnection.connection(); try {
	        	PreparedStatement ps;
	            ps=con.prepareStatement("select accno,acctype from customeracc where CID="+cid);
	           
	         rs=ps.executeQuery();
	         
	        
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	      return rs;
	}

}
