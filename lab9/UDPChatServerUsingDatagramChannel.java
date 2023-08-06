package lab9;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
/*Aarya chaudhary
Roll No : 1*/
public class UDPChatServerUsingDatagramChannel {
    private static final int SERVER_PORT = 6000;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.bind(new InetSocketAddress(SERVER_PORT));
            System.out.println("Server started on port " + SERVER_PORT);
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            while (true) {
                buffer.clear();
                InetSocketAddress clientAddress = (InetSocketAddress) channel.receive(buffer);
                buffer.flip();
                String message = new String(buffer.array(), 0, buffer.limit());
                System.out.println("Received from " + clientAddress.getAddress() + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}
}

