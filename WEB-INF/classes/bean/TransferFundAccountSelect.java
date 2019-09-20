package bean;
import java.sql.*;

public class TransferFundAccountSelect {
	public ResultSet account(int cid){
		ResultSet rs=null;
		try {
			Connection con=GetConnection.connection();Statement stmt =con.createStatement();
			rs =stmt.executeQuery("select * from CUSTOMERACC where  CID="+cid);		//Here the acc no of the customer is being searched in CUSTOMERDB
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}
	public ResultSet payeeDisplay(int cid)
	{
		ResultSet rs2=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
			Statement stmt =con.createStatement();
			rs2 =stmt.executeQuery("select * from PAYEEDB where  CID="+cid);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs2;
	}

}
