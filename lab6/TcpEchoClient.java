package lab6;
import java.io.*;
import java.net.Socket;
/*Aarya chaudhary
Roll No : 1*/
public class TcpEchoClient {
    private final static String HOSTNAME = "localhost";
    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket(HOSTNAME, PORT);
             InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
             BufferedReader in = new BufferedReader(isr);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            System.out.println("Connected to " + HOSTNAME + " on port " + PORT);
            String data = "Hello\nBye";
            System.out.println("Sending to server:\n" + data);
            out.println(data);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client received: " + line);
            }}}
}
