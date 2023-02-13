package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Servicios.EmpleadoServicio;

@WebServlet(name = "SvPdf", urlPatterns = "/SvPdf")
public class SvPdf extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		System.out.println("dentro de doGet de SvPdf");  

		String data = request.getParameter("data");


		System.out.println(EmpleadoServicio.getEmpleado());
         
		System.out.println("se imprimira la factura bien " + data);
         response.sendRedirect("pdf.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	private static final long serialVersionUID = 1L;
}
