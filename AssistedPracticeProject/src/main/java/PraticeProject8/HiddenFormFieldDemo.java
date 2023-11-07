package PraticeProject8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HiddenFormFieldDemo
 */
@WebServlet("/HiddenFormFieldDemo")
public class HiddenFormFieldDemo extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession();

	        Integer visitCount = (Integer) session.getAttribute("visitCount");

	        if (visitCount == null) {
	            visitCount = 1;
	        } else {
	            visitCount++;
	        }

	       
	        session.setAttribute("visitCount", visitCount);

	        out.println("<html>");
	        out.println("<head><title>Session Tracking using Hidden Form Fields</title></head>");
	        out.println("<body>");
	        out.println("<h1>Session Tracking using Hidden Form Fields</h1>");
	        out.println("<p>Welcome to the servlet that demonstrates hidden form field session tracking.</p>");
	        out.println("<p>Your visit count: " + visitCount + "</p>");
	        out.println("<form method='post' action='HiddenFormFieldDemo'>");
	        out.println("<input type='hidden' name='visitCount' value='" + visitCount + "'>");
	        out.println("<input type='submit' value='Reload'>");
	        out.println("</form>");
	        out.println("</body>");
	        out.println("</html>");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

}
