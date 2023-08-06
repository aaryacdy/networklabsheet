package lab8;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/*Aarya chaudhary
Roll No : 1*/
public class ChatClientApplication {
	private static final String END_CHAT_COMMAND = "/end";
	private SocketChannel socketChannel;
	private ByteBuffer buffer;
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the port:");
		int port = Integer.parseInt(sc.nextLine());
		try {
			// Connect to the server
			socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("localhost", port));
			int serverPort = socketChannel.socket().getPort();
			buffer = ByteBuffer.allocate(1024);

			System.out.println("Connected to chat server on port " + serverPort);

			// Read messages from the user and send them to the server
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String message = scanner.nextLine();

				// Send the message to the server
				sendMessage(message);

				if (message.equalsIgnoreCase(END_CHAT_COMMAND)) {
					// User wants to end the chat
					break;
				}
			}

			// Close the socket channel
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage(String message) throws IOException {
		buffer.clear();
		buffer.put(message.getBytes(StandardCharsets.UTF_8));
		buffer.flip();
		socketChannel.write(buffer);
	}

	public static void main(String[] args) {
		ChatClientApplication client = new ChatClientApplication();
		client.start();
	}
}