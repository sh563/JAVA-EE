package com.cester.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cester.dao.EmployeeDao;
import com.cester.model.Employee;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
		HttpSession session= request.getSession();
		
		int eid = Integer.parseInt(request.getParameter("emp_id"));
		EmployeeDao obj = new EmployeeDao();
		Employee emp = obj.getEmployeeByID(eid);
		out.print(emp);
		out.print("<html>");
		out.print("<body>");
		
		out.print("<form action ='SubmitServlet'>");
		out.print(" Employee Id :<input type = 'text' name ='emp_id' value="+emp.getEmployeeId()+">");
		out.print(" Employee NAME :<input type = 'text' name ='emp_name' value="+emp.getEmplyeename()+">");
		out.print(" Employee CONTACT :<input type = 'text' name ='emp_contact' value="+emp.getContact()+">");
		out.print(" Employee CITY :<input type = 'text' name ='emp_city' value="+emp.getcity()+">");
		out.print(" <input type = 'submit'  value='SUBMIT DATA'>");
		out.print("</form>");
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
