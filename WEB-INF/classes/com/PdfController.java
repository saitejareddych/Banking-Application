package com;

import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PdfController
 */
public class PdfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfController() {
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
			long accNo=Integer.parseInt(request.getParameter("accNo"));
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment;filename=Statement.pdf");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.35:1521:xe", "system", "admin");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from transactiondb where accountno="+accNo);
				Document document=new Document();
				PdfWriter.getInstance(document,response.getOutputStream());
				document.open();
				Paragraph paragraph = new Paragraph();
				PdfPTable table = new PdfPTable(5);
				PdfPCell c1 = new PdfPCell(new Paragraph("Transaction ID"));
				PdfPCell c2 = new PdfPCell(new Paragraph("CR/DR"));
				PdfPCell c3 = new PdfPCell(new Paragraph("Note"));
				PdfPCell c4 = new PdfPCell(new Paragraph("Amount"));
				PdfPCell c5 = new PdfPCell(new Paragraph("Account Number"));
				table.addCell(c1);
	    	 	table.addCell(c2);
	    	 	table.addCell(c3);
	    	 	table.addCell(c4);
	    	 	table.addCell(c5);
			     while(rs.next()){
			    	 String ref=Integer.toString(rs.getInt(1));
			    	 System.out.println(ref);
			    	String CR=rs.getString(2);
			    	String comments=rs.getString(3);
			    	 	String amount=Integer.toString(rs.getInt(4));
			    	 	String accNo1=Integer.toString(rs.getInt(5));
			    	 	Date date=(rs.getDate(6));
			    	 	PdfPCell cell1 = new PdfPCell(new Paragraph(ref));
			    		PdfPCell cell2 = new PdfPCell(new Paragraph(CR));
			    		PdfPCell cell3 = new PdfPCell(new Paragraph(comments));
			    		PdfPCell cell4 = new PdfPCell(new Paragraph(amount));
			    		PdfPCell cell5 = new PdfPCell(new Paragraph(accNo1));
			    	 	table.addCell(cell1);
			    	 	table.addCell(cell2);
			    	 	table.addCell(cell3);
			    	 	table.addCell(cell4);
			    	 	table.addCell(cell5);
			      }
			     document.add(table);
				document.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
