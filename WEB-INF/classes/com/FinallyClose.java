package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserExists;

/**
 * Servlet implementation class Finallyclose
 */
public class FinallyClose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinallyClose() {
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
		response.setContentType("text/html");
	  				PrintWriter out=response.getWriter();
	  				int cid=Integer.parseInt(request.getParameter("cid"));
	  		int  accno=Integer.parseInt((String)request.getParameter("rad1"));
	  		
	     
	  		out.println(accno);
	  		
	  		boolean status=objt.delete(accno,cid);
	  		if(status){
	  			out.println("<html><body><h3>DELETED SUCCESSFULLY</h3></body></html>");
	  			RequestDispatcher rd=request.getRequestDispatcher("DeleteAccount.jsp");
	  			rd.include(request, response);
;	  			
	  		}
	  		else{
	  			out.println("<html><body><h3>YOUR BALANCE DOES NOT HAVE ZERO BALANCE</h3></body></html>");
	  			RequestDispatcher rd=request.getRequestDispatcher("DeleteAccount.jsp");
	  			rd.include(request, response);
	  			}
	}

}
