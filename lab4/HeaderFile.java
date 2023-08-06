package lab4;
import java.net.*;
import java.util.*;
/*Aarya chaudhary
Roll No : 1*/
public class HeaderFile {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://kathford.edu.np/");
			URLConnection connection = url.openConnection();
			Map<String, List<String>> headerFields = connection.getHeaderFields();
			for (String key : headerFields.keySet()) {
				System.out.println(key + ": " + headerFields.get(key));
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
