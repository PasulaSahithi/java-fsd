package PracticeProject7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class URLRewriteDemo
 */
@WebServlet("/URLRewriteDemo")
public class URLRewriteDemo extends HttpServlet {
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        // Get the session or create a new one if it doesn't exist
	        HttpSession session = request.getSession();
	        
	        // Retrieve the session data
	        Integer visitCount = (Integer) session.getAttribute("visitCount");
	        
	        // If visitCount is null, it's the first visit
	        if (visitCount == null) {
	            visitCount = 1;
	        } else {
	            visitCount++;
	        }
	        
	        // Store the updated visitCount in the session
	        session.setAttribute("visitCount", visitCount);
	        
	        // Append the session ID to the URL for URL rewriting
	        String urlWithSessionID = response.encodeURL("URLRewriteDemo");
	        
	        out.println("<html>");
	        out.println("<head><title>Session Tracking using URL Rewrite</title></head>");
	        out.println("<body>");
	        out.println("<h1>Session Tracking using URL Rewrite</h1>");
	        out.println("<p>Welcome to the servlet that demonstrates URL rewriting.</p>");
	        out.println("<p>Your visit count: " + visitCount + "</p>");
	        out.println("<p><a href='" + urlWithSessionID + "'>Reload</a></p>");
	        out.println("</body>");
	        out.println("</html>");
	    }

}
