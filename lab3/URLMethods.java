package lab3;
import java.io.IOException;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class URLMethods {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://google.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("OPTIONS");
        connection.connect();
        String methods = connection.getHeaderField("Allow");
        System.out.println("Supported Methods: " + methods);
    }
}

