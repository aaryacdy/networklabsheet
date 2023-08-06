package lab2;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class URISolver {
    public static void main(String[] args) {
        String baseURI = "https://www.kathford.edu.np/about-us";
        String relativeURI = "kathford-scholarships";
        try {
            URI resolvedURI = new URI(baseURI).resolve(relativeURI);
            System.out.println("Resolved URI: " + resolvedURI);
        } catch (URISyntaxException e) {
            System.out.println("Invalid URI syntax: " + e.getMessage());
        }
    }
}
