package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Statement
 */
public class Statement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statement() {
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
		PrintWriter out=response.getWriter();
		try{
		
		response.setContentType("text/html");
		int n=Integer.parseInt((String)request.getParameter("noofdays"));
		
		int acc=Integer.parseInt(request.getParameter("rad1"));
		System.out.print(n+"  "+acc);
		ResultSet rs=bean.UserExists.getTrans(acc,n);
		request.setAttribute("result",rs);
		request.setAttribute("accNo",acc);
		RequestDispatcher rd=request.getRequestDispatcher("DisplayStatement.jsp");
		rd.forward(request, response);
		/*try {
			out.println("<tr>");
			//while(rs.next()){
				//out.println("<td>"+rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getFloat(4)+rs.getInt(5)+rs.getDate(6)+"</td>");
			//}
			out.println("</tr>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	catch(NumberFormatException e)
	{
		out.println("<html><body onload=\"alert('Invalid Days')\"></body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("TransactionByLastDate.jsp");  
        rd.include(request, response);
	}
	}
}
