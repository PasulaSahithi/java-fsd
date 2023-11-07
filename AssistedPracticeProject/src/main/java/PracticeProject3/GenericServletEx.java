package PracticeProject3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class GenericServletEx
 */
public class GenericServletEx extends GenericServlet {

    public GenericServletEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		String uname=req.getParameter("uname");
		String pswd=req.getParameter("pswd");
		if(uname.equals(pswd))
		{
			pw.print("Login is Successful");
		}
		else
		{
			pw.print("Invalid credentails");
		}
	}

}
