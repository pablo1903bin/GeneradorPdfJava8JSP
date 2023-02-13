package controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PDF;

//import model.QR.GeneraQR;

//import com.itextpdf.text.pdf.PdfWriter;

@WebServlet(name = "crearPDF", urlPatterns = "/crearPDF")
public class crearPDF extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PDF pDF = new PDF();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Generar PDF con el id: " + id);


			pDF.GenerarPDF(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data = request.getParameter("data");
		System.out.println("Metodo Post mas datos del form de envio al servidor " + data);
		// int id = Integer.parseInt(request.getParameter("id"));
		// System.out.println("Generar PDF con perro id: " + id);

		response.sendRedirect("pdf.jsp");
		// doGet(request, response);
	}

	private static final long serialVersionUID = 1L;
}
