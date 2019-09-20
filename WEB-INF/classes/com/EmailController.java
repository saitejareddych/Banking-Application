package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Modify;

/**
 * Servlet implementation class EmailController
 */
public class EmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailController() {
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
		int cid=Integer.parseInt(request.getParameter("cid"));
		String email=request.getParameter("email");
		bean.Modify s= new  Modify();
		PrintWriter out=response.getWriter();
		boolean flag=s.email(cid,email);
		if(flag)
		{
			out.println("<html><body onload=\"alert('Email updated successfully')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("bankerHomePage.html");  
	        rd.include(request, response);
		}
	}

}
