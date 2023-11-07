package PracticeProject5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ServletFilterEx
 */
public class ServletFilterEx implements Filter {

    /**
     * Default constructor. 
     */
    public ServletFilterEx() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		if(id.equals("101") && name.equals("sahithi"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			pw.print("Invalid Credentails...! \nTry again");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
