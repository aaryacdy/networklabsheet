package lab8;
import java.io.IOException;
import java.net.*;
import java.nio.*;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;
/*Aarya chaudhary
Roll No : 1*/
public class TimeClientApplication {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try {
            // Create a server socket channel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(0));
            serverSocketChannel.configureBlocking(false);

            int serverPort = serverSocketChannel.socket().getLocalPort();
            System.out.println("Time server started on port " + serverPort);

            // Create a selector and register the server socket channel
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

            while (true) {
                // Select ready channels
                selector.select();

                // Get the selection keys for the ready channels
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    if (key.isAcceptable()) {
                        // Accept incoming client connections
                        SocketChannel clientChannel = serverSocketChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);

                        // Connect dynamically to the client
                        SocketAddress clientAddress = clientChannel.getRemoteAddress();
                        System.out.println("Connected to client: " + clientAddress);
                    } else if (key.isReadable()) {
                        // Read from the client channel
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        buffer.clear();

                        int bytesRead = clientChannel.read(buffer);
                        if (bytesRead == -1) {
                            // Client has closed the connection
                            clientChannel.close();
                            continue;
                        }
                        buffer.flip();
                        String request = new String(buffer.array(), 0, buffer.limit(), StandardCharsets.UTF_8).trim();
                        String response;
                        if (request.equalsIgnoreCase("TIME")) {
                            LocalDateTime currentTime = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            response = currentTime.format(formatter);
                        } else response = "Invalid request";
                        // Write the response to the client channel
                        buffer.clear();
                        buffer.put(response.getBytes(StandardCharsets.UTF_8));
                        buffer.flip();
                        clientChannel.write(buffer);
                    }
                    iterator.remove();
                }}
        } catch (IOException e) {
            e.printStackTrace();
        }}
}