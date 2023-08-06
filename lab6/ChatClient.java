package lab6;
import java.io.*;
import java.net.Socket;
/*Aarya chaudhary
Roll No : 1*/
public class ChatClient {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket serverSocket = new Socket("localhost", 1234);
            System.out.println("Connected to chat server.");

            // Create reader and writer for server communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(serverSocket.getOutputStream(), true);

            // Create a separate thread to read messages from the server
            Thread messageReader = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            messageReader.start();

            // Read user input and send messages to the server
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = userInputReader.readLine()) != null) {
                writer.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}
}
