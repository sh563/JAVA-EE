package com.cester.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cester.dao.EmployeeDao;
import com.cester.model.Employee;

/**
 * Servlet implementation class DisplayEmployees
 */
@WebServlet("/DisplayEmployees")
public class DisplayEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployees() {
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
		
		EmployeeDao  dbUtil = new EmployeeDao();
		
		List<Employee>  emps = dbUtil.display();
		
		out.print("<html>");
		out.print("<body>");
		
		out.print("<table border='5px' bgcolor='sky blue'>");
		out.print("<tr><th>Employee ID</th><th>Name</th><th>Contact</th><th>City<th>Insert</th><th>Update</th><th>Delete</th></tr>");
		
		for(Employee  emp:    emps){
			
			out.print("<tr><td>"+emp.getEmployeeId()+"</td><td>"+emp.getEmplyeename()+"</td><td>"+emp.getContact()+"</td><td>"+emp.getcity()+"</td><td><a href='InsertServlet'>Insert</a></td><td><a href='UpdateServlet?id="+emp.getEmployeeId()+"'>Update</a></td><td><a href='DeleteServlet?id="+emp.getEmployeeId()+"'>Delete</a></td></tr>");
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

