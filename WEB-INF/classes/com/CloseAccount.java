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

import bean.UserExists;
import bean.VerifyBean;

/**
 * Servlet implementation class CloseAccount
 */
public class CloseAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAccount() {
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
		bean.UserExists objt=new UserExists();
		HttpSession session=request.getSession();
		int cid=Integer.parseInt(request.getParameter("deletecid"));
		response.setContentType("text/html");
	  				PrintWriter out=response.getWriter();
	  		session.setAttribute("CID",cid);
	  		String pwd=request.getParameter("pwd");
	  		
	     

	  		
	  		boolean status=objt.verify(cid);
	  		if(status){
	  			ResultSet rs=UserExists.getAccDetails(cid);
	  			session.setAttribute("delete", rs);
	  			RequestDispatcher rd=request.getRequestDispatcher("DeletingAccount.jsp");
	  			rd.forward(request, response);
	  		}
	  		else{
	  			out.println("cid doesnt exists");
	  		}
	
	}

}
