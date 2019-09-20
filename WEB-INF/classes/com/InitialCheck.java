package com;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserExists;
import bean.VerifyBean;

/**
 * Servlet implementation class InitialCheck
 */
public class InitialCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitialCheck() {
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
  	bean.VerifyBean obj=new VerifyBean();  
	response.setContentType("text/html");
  				PrintWriter out=response.getWriter();
  		int cid= Integer.parseInt(request.getParameter("CID"));
  		String pwd=request.getParameter("pwd");
  		
     

  		
  		boolean status=objt.verify(cid,pwd);
  	  	boolean accstatus=obj.verify(cid, pwd);
  	  	HttpSession session=request.getSession();
  		if(status){
  		session.setAttribute("CID",new Integer(cid));
     session.setAttribute("pwd",pwd);
     RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");
		rd.forward(request,response);
		
		
  		}
  		else{ 
  			if(accstatus){
  			
  			session.setAttribute("CID",new Integer(cid));
     session.setAttribute("pwd",pwd);
     RequestDispatcher rd=request.getRequestDispatcher("verifyreg.jsp");
		rd.forward(request,response);
  		}
  		else{
  			out.println("<html><body onload=\"alert('Password Do Not match')\"></body></html>");
  			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
  		}
  		}
  		
	}

}
