package com.tcs.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class ForcedRequestFilter
 */
public class ForcedRequestFilter implements Filter {
	private static Logger logger = Logger.getLogger(WindowUnloadServlet.class);
    
	/**
	 * Default constructor.
	 */
	public ForcedRequestFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			if (null != chain && null != response && !response.isCommitted()) {						
				chain.doFilter(request, response);
				
				return;
			}
		} catch (ServletException sexp) {

			HttpSession sessionErr = ((HttpServletRequest) request).getSession();

			sessionErr.setAttribute("frameworkRecordedRuntimeException",sexp);
			logger.error("*****ForcedRequestFilter****error message==>>*"+ sexp.getMessage());
			throw sexp;

		}catch (IOException exp) {

			HttpSession sessionErr = ((HttpServletRequest) request).getSession();

			sessionErr.setAttribute("frameworkRecordedRuntimeException",exp);
			logger.error("*****ForcedRequestFilter****error message==>>*"+ exp.getMessage());
			throw exp;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
