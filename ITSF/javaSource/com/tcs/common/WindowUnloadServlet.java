package com.tcs.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class WindowUnloadServlet
 */
public class WindowUnloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(WindowUnloadServlet.class);
    
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WindowUnloadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//try {
			doProcesscing(request, response);
		///} catch (Exception e) {

		//	throw new RuntimeException(e);
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcesscing(request, response);
		} catch (Exception e) {
			logger.error("**getMessage in throwable==>" + e.getMessage());
			throw new ServletException(e);
		} 
	}

	/**
	 * @author TCS
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void doProcesscing(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath());
	}

}
