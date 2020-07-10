package com.cester.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlets
 */
@WebServlet("/EmployeeServlets")
public class EmployeeServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:").append(request.getContextPath());
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int contact = Integer.parseInt(request.getParameter("contact"));
		String city=request.getParameter("city");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body bgcolor='sky color'>");
		
		out.print("<h3> USER SENT THE ID AS:</h3>");
		out.print("<h3>  USER SENT THE NAME AS:</h3>");
		out.print("<h3>  USER SENT THE CONTACT AS:</h3>");
		out.print("<h3>  USER SENT THE CITY AS:</h3>");
		out.print("</body>");
		
		out.print("/html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
