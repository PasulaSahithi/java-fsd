package PracticeProject9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionEx
 */
public class HttpSessionEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpSessionEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {PrintWriter pw=response.getWriter();
	RequestDispatcher rd=request.getRequestDispatcher("ServletInterfaceEx.html");
	rd.include(request, response);
	String uname=request.getParameter("uname");
	String pswd=request.getParameter("pswd");
	if(uname.equals(pswd))
	{
		HttpSession session=request.getSession();
		session.setAttribute("UserID",uname);
		pw.print("Login Successful");
	}
	else
	{
		pw.print("Login failed");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
