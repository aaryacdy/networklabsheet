package lab2;
import java.io.*;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class WebpageDownloader {

    public static void main(String[] args) {
        String url = "https://www.google.com";
        try {
            URLConnection connection = new URL(url).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print the line to the console (you can also save it to a file)
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
