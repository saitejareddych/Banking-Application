package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AddPayee;

/**
 * Servlet implementation class AddPayeeController
 */
public class AddPayeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayeeController() {
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
		HttpSession session=request.getSession(true);
		PrintWriter out=response.getWriter();
		int cid=(Integer)session.getAttribute("CID");
		System.out.println(cid);
		long accNo=Long.parseLong(request.getParameter("ACCNO"));
		
		
		String nickName=request.getParameter("NickName");
		bean.AddPayee a=new AddPayee();
		boolean flag=a.addPayee(accNo, nickName,cid);
		if(flag){
			out.println("<html><body onload=\"alert('Registered Successfully')\"></body></html>");
			 RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");  
		        rd.include(request, response);  
		}
		else
		{
			out.println("<html><body onload=\"alert('Payee Account Number Does Not Exist')\"></body></html>");
			 RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");  
		        rd.include(request, response);  
		}
		
		
	}

}
