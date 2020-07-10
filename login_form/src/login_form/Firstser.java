package login_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Firstser
 */
@WebServlet("/Firstser")
public class Firstser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Firstser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("u_name");
		String pass=request.getParameter("u_pass");
		
		//out.print("Hello..... "+name+"you are on login page: ");
		
		if(pass.equals("u_pass")) {
			
			RequestDispatcher rd=request.getRequestDispatcher("secondServ");
			
			rd.forward(request,response);
			
			
			
			response.sendRedirect("secondServ");
		}
		
		else {
			
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			
			out.print("Sorry the typed password is Incorrect");
			
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
