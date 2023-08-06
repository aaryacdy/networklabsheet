package lab4;
import java.io.*;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class UrlConnection {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.google.com/");
            URLConnection uc = u.openConnection();
            InputStream stream = uc.getInputStream();
            int c;
            while ((c = stream.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
