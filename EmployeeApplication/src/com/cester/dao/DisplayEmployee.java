package com.cester.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayEmployee
 */
@WebServlet("/DisplayEmployee")
public class DisplayEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("TEXT/HTML");
		
		PrintWriter out= response.getWriter();
		
		EmployeeDao dbUtil = new EmployeeDao();
		
		List<EmployeeDao> emps=dbUtil.display();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr><th>Employee ID</th><th>Contact</th><th>city</th></tr>");
		for (EmployeeDao emp:  emps) {
			out.print("<tr><td>"+emp.getId()+"</td></tr>");
			
		}
		
		
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
