package bean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.*;
import java.util.Random;
public class Register {
	static int number1;
	static int number,n=1;
	static long number2;
	static String line;
public boolean RegisterCustomer(int ssn, String fname,float balance, String email, String address, String state,
		String country, long phone, String accType,int pin,String gender) {
	boolean flag=false;	
	boolean flagSSN=false;
	boolean flagScore=false;
	int score=0;
	int ssn2=0;
	int numberCid=CustomerID();
		String numberPwd=password();
		long numberAcc=account();
		String nCid=Integer.toString(numberCid);
		String acc=Long.toString(numberAcc);
			try {
				Connection con=GetConnection.connection();Statement stm=con.createStatement();
				ResultSet r=stm.executeQuery("select ssn from idproof where ssn="+ssn);
				while(r.next())
				{
					ssn2=r.getInt(1);
					flagSSN=true;
				}
				if(flagSSN)
				{
					ResultSet s=stm.executeQuery("select creditscore from idproof where ssn="+ssn2);
					while(s.next())
					{
						score=s.getInt(1);
						if(score>=550)
						{
							bean.Transdate a=new Transdate();
							String getCurrentDate=a.day();
							
							PreparedStatement pstmt = con.prepareStatement("insert into customerdb values(?,?,?,?,?,?,?,?,?,?,?)");
							PreparedStatement pstmt1 = con.prepareStatement("insert into logintable values(?,?,?,?,?,?,?)");
							PreparedStatement pstmt2 = con.prepareStatement("insert into customeracc values(?,?,?,?,?,?)");
							System.out.println("connected");
							System.out.println(ssn);
							pstmt.setInt(1,ssn);
							pstmt.setInt(2, numberCid);
							pstmt.setString(3,fname);
							pstmt.setString(4,gender);
							pstmt.setDate(5,getCurrentDate());
							pstmt.setString(6,address);
							pstmt.setString(7,state);
							pstmt.setString(8,country);
							pstmt.setInt(9,pin);
							pstmt.setLong(10,phone);
							pstmt.setString(11,email);
							pstmt1.setInt(1, numberCid);
							pstmt1.setString(2,numberPwd);
							pstmt1.setString(3,null);
							pstmt1.setString(4,null);
							pstmt1.setString(5,null);
							pstmt1.setString(6,null);
							pstmt1.setInt(7,0);
							pstmt2.setLong(1,numberAcc);
							pstmt2.setString(2,accType);
							pstmt2.setFloat(3,balance);
							pstmt2.setDate(4,getCurrentDate());
							pstmt2.setInt(5,numberCid);
							pstmt2.setInt(6,0);
							pstmt.execute();
							pstmt1.execute();
							pstmt2.execute();
							flag=true;
						}
						else
						{
							return false;
						}
					}
				}
			} 
			catch (SQLIntegrityConstraintViolationException e) {
				return false;
			}
			catch (SQLException e) {
				
				return false;
			}
			if(flag==true){
			bean.Email e=new Email();
			e.approve(acc,nCid,numberPwd,email);
			}
			else{
				return false;
			}
				return flag;
}

public void fun(RandomAccessFile raf) throws IOException
{
		
	File f = new File("num.txt");
	
	line = raf.readLine();
	  
      if(line!=null)
      { 	  
         number=Integer.parseInt(line);
         number++;    
       
         return;
      }   
      number= (int) (2*Math.pow(10.0,7.0) + 0 + Math.pow(10.0,5.0) + 7*Math.pow(10.0,4.0) + (double)n) ;
      System.out.println(number);
}
public int CustomerID()
{
      try
	  {
    		PrintWriter pw=new PrintWriter(System.out);
    		
   		  RandomAccessFile raf = new RandomAccessFile("num.txt", "rw");
		  fun(raf);
		  raf.seek(0);
		 raf.writeBytes(number+"");
		  raf.close();
		  
       }		  
	   catch(Exception e)
	   {
			  System.out.println("Exception:"+e);
	   } 
      return number;
  }	
//--------------------------------------------------------------------
static char getUppercase()
{
   Random random = new Random();
   char x = (char)(random.nextInt(26)+65);
   return x;
}  
static char getLowercase()
{
   Random random = new Random();
   char x = (char)(random.nextInt(26)+97);
   return x;
}  
static char getSpecialChar()
{
	Random random = new Random();
	char x = (char)(random.nextInt(16)+32);
	return x;
}
static int getNumber()
{
	Random random = new Random();
	int x = random.nextInt(90000000)+10000000;
	return x;
}
public String password()
{
   String str="";
               
   str=str+getUppercase()+getLowercase()+getSpecialChar()+getNumber();
   
  System.out.println(str);
  return str;
}		
public java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
//-----------------------------------------------------------random account number
public long account()
{
    try
	  {
		  
		  PrintWriter pw=new PrintWriter(System.out);
		  PrintWriter pw1=new PrintWriter(new FileOutputStream("RandomAccounts.txt",true));       
		  BufferedReader br = new BufferedReader(new FileReader("RandomAccounts.txt"));
		  fun2(br);
		  
		    pw1.println(number2);		
		     pw1.flush();
		     pw1.close();
		  
     }		  
		  catch(Exception e)
		  {
			  System.out.println("Exception:"+e);
		  } 
    
    return number2;
}	
static void fun2(BufferedReader br)
{
	  boolean flag = false;
	  String lin = null;
	  long num = 0;
	  try
	  {
			  num=getint2();
           while((lin=br.readLine())!=null)
  		 {
          	 int n = Integer.parseInt(lin);
          	 if(n==num)
          		 flag = true;
			 }
           if(!flag)
           {
          	 number2 = num;
          	 System.out.println(number2);
           }
    }
    catch(Exception e)
    {
       System.out.println(e);
    }
	
 }
static long getint2()
{
   Random random = new Random();
   long x = random.nextInt(900000000)+1000000000;
   return x;
}
}
