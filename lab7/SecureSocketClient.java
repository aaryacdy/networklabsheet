package lab7;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/*Aarya chaudhary
Roll No : 1*/
public class SecureSocketClient {
    public static void main(String[] args) {
        String urlToDownload = "https://kathford.edu.np"; // URL to the content you want to download
        // Create an HttpClient instance
        HttpClient httpClient = HttpClient.newBuilder().build();
        // Create an HttpRequest with the URL to download
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlToDownload))
                .GET()
                .build();
        try {
            // Send the HTTP request and receive the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the HTTP status code
            if (response.statusCode() == 200) {
                // Write the response content to a file
                String content = response.body();
                Path filePath = Paths.get("content.txt");
                Files.write(filePath, content.getBytes());
                System.out.println("Content downloaded and saved to content.txt");
            } else {
                System.out.println("Failed to download content. Response code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
