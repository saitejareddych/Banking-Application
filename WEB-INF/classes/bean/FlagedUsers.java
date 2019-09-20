package bean;

import java.sql.*;

public class FlagedUsers {
public ResultSet showFlaged()
{
	ResultSet rs=null;
	try {
		Connection con=GetConnection.connection();	Statement stmt=con.createStatement();
		rs=stmt.executeQuery("select cid,accno,acctype,transdate from customeracc inner join transactiondb on customeracc.accno=transactiondb.accountno where flag=1");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}
}
