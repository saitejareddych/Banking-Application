package bean;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Transdate
{
	public String day()  
	{
		String day=null;
		try
		{
		   DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		   Date today = Calendar.getInstance().getTime();        
	
		   String reportDate = df.format(today);
	
		   StringTokenizer st=new StringTokenizer(reportDate,"/, ");
		   int count=0;
		   while(st.hasMoreTokens())
		   {
			   String monthstr;
			   String arr[]={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
			   int monthint=Integer.parseInt(st.nextToken());
			   monthstr=arr[monthint-1];
			   String date=st.nextToken();
			   String year=Integer.toString(Integer.parseInt((st.nextToken()))-2000);
			   day=date+ "-" + monthstr +"-"+year;
		   }
    	}
        catch(Exception e)
        {
        	//System.out.println(e);
        }
		return day;
    }
}
