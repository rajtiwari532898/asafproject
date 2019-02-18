package com.comdata.posa.util;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;



/**
 * Servlet implementation class for Servlet: CaptchaServlet
 *
 */

public final class CaptchaServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final Logger M_LOGGER = Logger.getLogger(CaptchaServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CaptchaServlet() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletOutputStream outputStream=null;
		 BufferedImage captchaImg=null;
		 try {
			CaptchaUtil captchaUtil = CaptchaUtil.getInstance();
			String captchaStr = captchaUtil.getCaptchaString1(Integer.valueOf(5));			
			captchaImg = captchaUtil.getCaptchaImage(captchaStr, 200,60);
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");
			outputStream = response.getOutputStream();
			if (outputStream != null && captchaImg != null) {
				ImageIO.write(captchaImg, "jpeg", outputStream);
			}
			HttpSession session=(HttpSession)request.getSession(false);
			session.setAttribute("CAPTCHA_STRING", captchaStr);
		} catch (IOException e) {
			M_LOGGER.error("Error in CaptchaServlet.doPost :"+ e.getMessage());
			throw e;
		} finally {
			try {
				if (outputStream != null && captchaImg != null) {
					captchaImg.flush();
					outputStream.flush();
					outputStream.close();

				}
			} catch (IOException e) {
				M_LOGGER.error("Error in CaptchaServlet :"+ e.getMessage());
				//throw new RuntimeException(e);
			}
		}
	}
}
	
