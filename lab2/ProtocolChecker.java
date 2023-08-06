package lab2;
import java.net.URL;
/*Aarya chaudhary
Roll No : 1*/
public class ProtocolChecker {
	public static void main(String[] args) {
        String[] protocols = {"http://", "https://", "gopher://", "file://", "mailto:info@", "telnet://"};
        for (String protocol : protocols) {
            try {
            	String urlString= protocol+ "kathford.edu.np";
                URL url = new URL(urlString);
                System.out.println("Protocol " + protocol + " is supported ");
            } catch (Exception e) {
                System.out.println("Protocol " + protocol + " is not supported ");
            }
        }
	}
}
