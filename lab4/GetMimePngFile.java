package lab4;
import java.net.*;
import java.io.IOException;
/*Aarya chaudhary
Roll No : 1*/
public class GetMimePngFile {
	public static void main(String[] args) throws IOException {
		String pngFile = "file:\\D:\\notes\\6th_sem\\Lab\\network\\flower.png";
		String pdfFile = "file:\\D:\\notes\\6th_sem\\Lab\\network\\unit-2.pdf";
		URLConnection connection1 = null;
		URLConnection connection2 = null;
		String pngMimeType = null;
		String pdfMimeType = null;

		// Guess MIME type of PNG file and PDF file
		URL url1 = new URL(pngFile);
		URL url2 = new URL(pdfFile);
		connection1 = url1.openConnection();
		connection2 = url2.openConnection();
		pngMimeType = connection1.getContentType();
		pdfMimeType = connection2.getContentType();

		System.out.println("MIME type of PNG file: " + pngMimeType);
		System.out.println("MIME type of PDF file: " + pdfMimeType);
	}
}

