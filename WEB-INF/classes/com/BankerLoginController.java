package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankerLoginController
 */
public class BankerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankerLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Sorry invalid Access</h1>");
		out.println("<h2>Please Login first <a href='index.html'>Login Page</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String banker = request.getParameter("banker");
		String bPassword = request.getParameter("bPassword");
		System.out.println(banker);
		System.out.println(bPassword);
		if(banker.equals("saiteja")&& bPassword.equals("1234"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("bankerHomePage.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("<html><body onload=\"alert('Invalid Username/Password')\"></body></html>");
			RequestDispatcher rd1=request.getRequestDispatcher("index.html");		
			rd1.include(request,response);
		}
		}
	}

