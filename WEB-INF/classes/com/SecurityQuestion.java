package com;


import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.RegisterSecurity;

/**
 * Servlet implementation class SecurityQuestion
 */
public class SecurityQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecurityQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Sorry invalid Access</h1>");
		out.println("<h2>Please Login first <a href='index.html'>Login Page</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Affiliate af=new Affiliate();
		response.setContentType("text/html");
		boolean flag=false;
				try
		{
			int t=0,m = 0,c=0;
			
			 
			
			String Sec1 = request.getParameter("SecQ1");
			String Ans1 = request.getParameter("SecA1");
			String Sec2 = request.getParameter("SecQ2");
			String Ans2 = request.getParameter("SecA2");
			
			HttpSession session = request.getSession();
			int sid = (Integer)session.getAttribute("CID");
			System.out.println(sid);
			String pwd=(String) session.getAttribute("pwd");  
			bean.RegisterSecurity res=new RegisterSecurity();
			flag=res.register(sid,pwd,Sec1,Ans1,Sec2,Ans2);
			if(flag==true){
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.html");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request,response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}


}
