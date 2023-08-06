package lab2;
import java.io.*;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class ObjectDownloader {

    public static void main(String[] args) {
        String url = "https://kathford.edu.np/wp-content/uploads/2019/05/kath-log.svg";
        String filename = "kath-log.svg";

        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Downloaded " + filename + " from " + url);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
