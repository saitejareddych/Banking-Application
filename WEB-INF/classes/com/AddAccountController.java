package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddAccount;

public class AddAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAccountController() {
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
		int addCid=Integer.parseInt(request.getParameter("addCid"));
		String accType=request.getParameter("accType");
		int balance=Integer.parseInt(request.getParameter("balance"));
		bean.AddAccount a=new AddAccount();
		boolean flag=a.checkCid(addCid,accType,balance);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(flag)
		{
			out.println("<html><body onload=\"alert('Added Account Successfully')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("bankerHomePage.html");  
	        rd.include(request, response); 
		}
		else
		{
			out.println("<html><body onload=\"alert('Selected CID Does Not Exist/Crossed limit on number of Accounts')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("bankerHomePage.html");  
	        rd.include(request, response);
		}
		
	}

}
