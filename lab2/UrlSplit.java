package lab2;
import java.net.MalformedURLException;
import java.net.URL;
/*Aarya chaudhary
Roll No : 1*/
public class UrlSplit {
	  public static void main(String[] args) {
        String urlString = "https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-";
        try {
            URL url = new URL(urlString);
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String path = url.getPath();
            String query = url.getQuery();
            String fragment = url.getRef();
            System.out.println("Protocol: " + protocol);
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            System.out.println("Fragment: " + fragment);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + urlString);
        }
    }
}
