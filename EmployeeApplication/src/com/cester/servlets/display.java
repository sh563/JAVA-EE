package com.cester.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cester.dao.EmployeeDao;
import com.cester.model.Employee;

/**
 * Servlet implementation class display
 */
@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display() {
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
		EmployeeDao obj = new EmployeeDao();
		List <Employee> empz=new ArrayList<>();
		empz = obj.display();
		out.print(empz);
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border ='4px' color='black'>");
		
		out.print("<tr bgcolor='sky blue'><td>ID</td><td>NAME</td><td>CONTACT</td><td>CITY</td><td>INSERT</td><td>UPDATE</td><td>DELETE</td></tr>");
		for(Employee emp:    empz) {
			
			out.print("<tr><td>"+emp.getEmployeeId()+"</td><td>"+emp.getEmplyeename()+"</td><td>"+emp.getcity()+"</td><td>"+emp.getContact()+"</td><td></td><a href='insertServlet'>INSERT</a><td><a href='updateServlet?emp_id="+ emp.getEmployeeId()+"'>UPDATE</a></td><td></td></tr>");
			
		
		
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
