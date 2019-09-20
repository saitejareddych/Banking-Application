package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForgotPasswordController(){
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Sorry invalid Access</h1>");
		out.println("<h2>Please Login first <a href='index.html'>Login Page</h2>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CID=Integer.parseInt(request.getParameter("CID"));
		String Q1 = request.getParameter("SecQ1");
		String A1 = request.getParameter("SecA1");
		String Q2 = request.getParameter("SecQ2");
		String A2 = request.getParameter("SecA2");
		HttpSession session=request.getSession();
		session.setAttribute("CID",CID);
		PrintWriter out=response.getWriter();
		int  flag=0;
		try  
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe","system","admin");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from LOGINTABLE where CID="+CID);
		while(rs.next()){
		if(Q1.equals(rs.getString(3))){
			if(A1.equals(rs.getString(4))){
				if(Q2.equals(rs.getString(5))){
					if(A2.equals(rs.getString(6))){
						flag = 1;
					}
				}
			}
		}
		}
		if(flag==1)
		{
			 RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.html");
			 rd.forward(request,response);
		}
		else
		{
			out.println("<html><body onload=\"alert('Invalid Security Questions/Answers')\"></body></html>");
			RequestDispatcher rd1=request.getRequestDispatcher("forgotpassword.html");		
			rd1.include(request,response);
		}	
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
