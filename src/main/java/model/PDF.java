package model;

import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDF {

	public void GenerarPDF(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Descargar PDF");

		try {

			final PDDocument doc = new PDDocument();
			ByteArrayOutputStream output = new ByteArrayOutputStream(); // Escribira Bytes
			PDPage page = new PDPage();
			doc.addPage(page);
			PDPageContentStream contenidoBytes = new PDPageContentStream(doc, page);

			/********* Traer mi imagen qr para insertarlo en el pdf *********************/
			QR qR = new QR();
			BufferedImage imagenQR = qR.crearImagenQR("las cariñosasitas temporales del sistema en la ultima version",
					200, 200);

			File tempFileQR = File.createTempFile("QRArchivotemporal", ".png", null);
			ImageIO.write(imagenQR, "png", tempFileQR);
			/*********************************************************************************************/

			// Agrego contenido textual
			contenidoBytes.beginText();
			contenidoBytes.setFont(PDType1Font.HELVETICA, 12);
			contenidoBytes.newLineAtOffset(100, 700);
			contenidoBytes.showText("Informacion del usuario");
			contenidoBytes.endText();

			PDImageXObject imagenQr = PDImageXObject.createFromFileByContent(tempFileQR, doc);
			tempFileQR.deleteOnExit();
			// Dibujo la imagen en el documento PDF
			contenidoBytes.drawImage(imagenQr, 210, 400);
			contenidoBytes.close();

			// Se aplica la proteccion
			cifrarPdf(doc);

			doc.save(output);
			doc.close();

			response.setContentType("application/pdf");

			response.setHeader("Content-Disposition", "attachment; filename=\"MypdfQR.pdf\"");
			response.setContentLength(output.size());
			OutputStream os = response.getOutputStream();
			output.writeTo(os);
			os.flush();
			os.close();

		} catch (Exception e) {
			e.getMessage().toString();
			System.out.println("Error interno de document" + e);
		} finally {

		}

	}

	private PDDocument cifrarPdf(PDDocument doc) {
		System.out.println("Encriptando pdf");
		/* Encriptado del pdf */// crear un objeto de permiso de acceso
		AccessPermission permisoAcceso = new AccessPermission();
		//Contraseña de usuario: Para abrir y ver el archivo con permisos restringidos
		//Contraseña de propietario:  para acceder al archivo con todos los permisos
		StandardProtectionPolicy spp = new StandardProtectionPolicy("123456", "abcd", permisoAcceso);
		// longitud de la clave de cifrado
		spp.setEncryptionKeyLength(256);

		spp.setPermissions(permisoAcceso);
		try {
			doc.protect(spp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

}
