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
 * Servlet implementation class ModifyController
 */
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyController() {
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
	String button=request.getParameter("button");
	bean.Modify s=new Modify();
	request.setAttribute("CID",cid);
	if(button.equals("Change Phone Number"))
	{
		RequestDispatcher rd=request.getRequestDispatcher("changePhone.jsp");  
        rd.forward(request, response); 
	}
	if(button.equals("Change Email"))
	{
		RequestDispatcher rd=request.getRequestDispatcher("changeEmail.jsp");  
        rd.forward(request, response);
	}
	
	}

}
