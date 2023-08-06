package lab8;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/*Aarya chaudhary
Roll No : 1*/
public class TimeServerApplication {
	private static final int BUFFER_SIZE = 1024;
	private static final String SERVER_HOST = "localhost";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the server port number: ");
		int serverPort = scanner.nextInt();
		try {
			// Create a socket channel and connect to the time server
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress(SERVER_HOST, serverPort));

			// Send a request to the server
			String request = "TIME";
			ByteBuffer requestBuffer = ByteBuffer.wrap(request.getBytes(StandardCharsets.UTF_8));
			socketChannel.write(requestBuffer);

			// Receive the response from the server
			ByteBuffer responseBuffer = ByteBuffer.allocate(BUFFER_SIZE);
			socketChannel.read(responseBuffer);

			// Process and print the response
			String response = new String(responseBuffer.array(), StandardCharsets.UTF_8).trim();
			System.out.println("Response from server: " + response);

			// Close the socket channel
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
