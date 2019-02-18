package com.tcs.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ErrorServlet
 */
public class ErrorServlet extends HttpServlet implements javax.servlet.Servlet {

	private static Logger logger = Logger.getLogger(ErrorServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorServlet() {
		super();
		logger.debug("************in ErrorServlet==>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcessing(request, response);
		} catch (Exception t) {
			logger.error("ErrorServlet***doGet -getMessage in throwable==>", t);
			throw new ServletException("Error In Proecessing",t);
		}
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcessing(request, response);
		} catch (Exception e) {
			logger.error("ErrorServlet***doPost -getMessage in throwable==>", e);
			throw new ServletException("Error In Proecessing",e);
		} /*catch (Throwable t) {
			logger.error("ErrorServlet****getMessage in throwable==>"
					+ t.getMessage());
		}*/
	}

	public void doProcessing(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {

		try {
			request.getRequestDispatcher("/error.xhtml").forward(request,
					response);
		} catch (ServletException e) {
			logger.error("ErrorServlet***doProcessing -getMessage in throwable==>", e);
			throw new ServletException(e);
		} /*catch (Throwable t) {
			logger.error("ErrorServlet**getMessage in throwable*==>"
					+ t.getMessage());
		}*/
	}

}
