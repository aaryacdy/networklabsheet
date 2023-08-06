package lab4;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
/*Aarya chaudhary
Roll No : 1*/
public class GetHeaderFileData {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://facebook.com/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");

            // print content type
            String contentType = conn.getContentType();
            System.out.println("Content Type: " + contentType);

            // print content length
            int contentLength = conn.getContentLength();
            System.out.println("Content Length: " + contentLength);

            // print last modified
            long lastModified = conn.getLastModified();
            Date lastModifiedDate = new Date(lastModified);
            System.out.println("Last Modified: " + lastModifiedDate);

            // print access date
            long accessDate = conn.getDate();
            Date accessDateTime = new Date(accessDate);
            System.out.println("Access Date: " + accessDateTime);

            conn.disconnect();
        } catch (IOException e) {
            System.out.println("Error retrieving URL information");
        }
    }
}
