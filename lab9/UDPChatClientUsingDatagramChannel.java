package lab9;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;
/*Aarya chaudhary
Roll No : 1*/
public class UDPChatClientUsingDatagramChannel {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 6000;
    private static final int BUFFER_SIZE = 1024;
    public static void main(String[] args) {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.configureBlocking(false);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the message:");
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            while (true) {
                String message = scanner.nextLine();
                buffer.clear();
                buffer.put(message.getBytes());
                buffer.flip();
                channel.send(buffer, new InetSocketAddress(SERVER_IP, SERVER_PORT));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}
}
