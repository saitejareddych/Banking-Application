package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PaymentProcessing;

/**
 * Servlet implementation class PaymetController
 */
public class PaymetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymetController() {
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
		String senderAccNo=request.getParameter("senderNo");
		String receiverAccNo=request.getParameter("receiverNo");
		String notes=request.getParameter("notes");
		System.out.println(notes);
		System.out.println(senderAccNo);
		System.out.println(receiverAccNo);
		HttpSession session=request.getSession();
		int cid=(Integer)session.getAttribute("CID");
		int amount=Integer.parseInt(request.getParameter("amount"));
		bean.PaymentProcessing p= new PaymentProcessing();
		PrintWriter out=response.getWriter();
		boolean flag=p.pay(senderAccNo,receiverAccNo,notes,amount,cid);
		if(flag)
		{
			out.println("<html><body onload=\"alert('Transfered Successfully')\"></body></html>");
			 RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");  
		        rd.include(request, response); 
		}
		else
		{
			out.println("<html><body onload=\"alert('Transfered Failed')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");
			rd.include(request,response);
		}
	}

}
