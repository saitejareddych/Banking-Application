package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Literal;

/**
 * Servlet implementation class StatementPeriod
 */
public class StatementPeriod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementPeriod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Sorry invalid Access</h1>");
		out.println("<h2>Please Login first <a href='index.html'>Login Page</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int acc=Integer.parseInt(request.getParameter("rad2"));
		String from = request.getParameter("fromdate");
		
        String to = request.getParameter("todate");
        System.out.println(from+" hello "+to);
		StringTokenizer st=new StringTokenizer(from,"-");
		StringTokenizer str=new StringTokenizer(to,"-");
		  String fmt = null,tmt = null;
	         String fm=st.nextToken();
	         int fmd=Integer.parseInt(fm);
	         int fd=Integer.parseInt((String)st.nextToken());
	         switch( fmd){
	         case 1:	fmt=new String("JAN");
	         			break;
	         case 2:	fmt=new String("FEB");
  			break;
	         case 3:	fmt=new String("MAR");
  			break;
	         case 4:	fmt=new String("APR");
  			break;
	         case 5:	fmt=new String("MAY");
  			break;
	         case 6:	fmt=new String("JUN");
  			break;
	         case 7:	fmt=new String("JUL");
  			break;
	         case 8:	fmt=new String("AUG");
  			break;
	         case 9:	fmt=new String("SEP");
  			break;
	         case 10:	fmt=new String("OCT");
  			break;
	         case 11:	fmt=new String("NOV");
  			break;
	         case 12:	fmt=new String("DEC");
  			break;
	         }
	         String fy=st.nextToken();  
	         String tm=str.nextToken();
	         int tmd=Integer.parseInt(fm);
	         int td=Integer.parseInt((String)str.nextToken());
	         switch(tmd){
	         case 1:	tmt=new String("JAN");
	         			break;
	         case 2:	tmt=new String("FEB");
  			break;
	         case 3:	tmt=new String("MAR");
  			break;
	         case 4:	tmt=new String("APR");
  			break;
	         case 5:	tmt=new String("MAY");
  			break;
	         case 6:	tmt=new String("JUN");
  			break;
	         case 7:	tmt=new String("JUL");
  			break;
	         case 8:	tmt=new String("AUG");
  			break;
	         case 9:	tmt=new String("SEP");
  			break;
	         case 10:	tmt=new String("OCT");
  			break;
	         case 11:	tmt=new String("NOV");
  			break;
	         case 12:	tmt=new String("DEC");
  			break;
	         }
	         String ty=str.nextToken();  
	         String datefrom=fd+fmt+fy;
	         String dateto=td+tmt+ty;
	
			
 		
		System.out.println(from+"hello"+to);
		ResultSet rs=bean.UserExists.getPeriodTrans(acc,datefrom,dateto);
		request.setAttribute("result",rs);
		request.setAttribute("accNo",acc);
		RequestDispatcher rd=request.getRequestDispatcher("DisplayPeriod.jsp");
		rd.forward(
				request, response);
		
	
		
	
	}
	
	
	

}
