package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QR {

	// Hacer que este metodo me retorne un file
	public File crearArchivoQr(String datos, int ancho, int altura) throws WriterException {

		String nombreArchivo = "UltimaImagenQR.png";

		File fileImageQR = new File(nombreArchivo);

		BitMatrix matrix;

		try {
			Writer escritor = new QRCodeWriter();
			matrix = escritor.encode(datos, BarcodeFormat.QR_CODE, ancho, altura);

			//imagen en memoria sobre la que puedo dibujar.
			BufferedImage imagen = new BufferedImage(ancho, altura, BufferedImage.TYPE_INT_RGB);

			for (int y = 0; y < altura; y++) {
				for (int x = 0; x < ancho; x++) {
					int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
					imagen.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
				}
			}
          //Escribo mi nueva imagen del qr tipo png en mi arhivo
			ImageIO.write(imagen, "png", fileImageQR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileImageQR;
	}
	
	
	 public BufferedImage crearImagenQR(String datos, int ancho, int altura) throws WriterException {
	        BitMatrix matrix;
	        Writer escritor = new QRCodeWriter();
	        matrix = escritor.encode(datos, BarcodeFormat.QR_CODE, ancho, altura);
	        
	        BufferedImage imagen = new BufferedImage(ancho, altura, BufferedImage.TYPE_INT_RGB);
	        
	        for(int y = 0; y < altura; y++) {
	            for(int x = 0; x < ancho; x++) {
	                int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
	                imagen.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
	            }
	        }
	        
	        return imagen;        
	    }   

}