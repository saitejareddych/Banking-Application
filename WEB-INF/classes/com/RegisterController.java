package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Email;
import bean.Register;

  /**
Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		int ssn = Integer.parseInt(request.getParameter("SSN"));
		String fname = request.getParameter("fName");
		String mname = request.getParameter("mName");
		String lname = request.getParameter("lName");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String email = request.getParameter("email");
		String gender=request.getParameter("gender");
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		long phone = Integer.parseInt(request.getParameter("phone"));
		int pin = Integer.parseInt(request.getParameter("pinCode"));
		String accType = request.getParameter("accType");
		bean.Register r=new Register();
		PrintWriter out=response.getWriter();
		boolean flag=r.RegisterCustomer(ssn, fname,balance, email, address, state, country, phone,accType,pin,gender);
		if(flag)
		{
			out.println("<html><body onload=\"alert('Registered Successfully')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("bankerHomePage.html");  
	        rd.include(request, response);  
		}
		else
		{
			out.println("<html><body onload=\"alert('Registration Failed/SSN Does Not Exist ')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("bankerHomePage.html");  
	        rd.include(request, response); 
		}
					}
	}

