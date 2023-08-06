package lab2;
import java.net.*;
import java.io.*;
/*Aarya chaudhary
Roll No : 1*/
public class GetExample {
    public static void main(String[] args) {
        try {
            // Create a URL object for the server-side program
            URL url = new URL("http://kathford.edu.np");
            // Open a connection to the URL using HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // Get the response code from the server
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);
            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Print the response from the server
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}