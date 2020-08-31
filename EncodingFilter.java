package new_board;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns =
{"/*"})

public class EncodingFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

    /**
     * Default constructor.
     */
//    public EncodingFilter() {
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see Filter#destroy()
	 */


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */


	/**
	 * @see Filter#init(FilterConfig)
	 */


}
