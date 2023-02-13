package controllers;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

@WebServlet(name = "servletTelcel", urlPatterns = "/servletTelcel")
public class servletTelcel extends HttpServlet {
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String data = request.getParameter("data");

		
		// response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		System.out.println("dentro de doGet");
		 
		
		System.out.println("se imprimira la factura bien " + data);
         response.sendRedirect("pdf.jsp");
		//request.getRequestDispatcher("index.jsp").forward(request, response);//Interfaz 
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}


