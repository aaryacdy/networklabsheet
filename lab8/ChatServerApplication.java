package lab8;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*Aarya chaudhary
Roll No : 1*/
public class ChatServerApplication {
    private static final String END_CHAT_COMMAND = "/end";

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private Map<SocketChannel, String> clientMap;

    public ChatServerApplication() {
        clientMap = new HashMap<>();
    }

    public void start() {
        try {
            // Open selector and server socket channel
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();

            // Configure the server socket channel and bind to an available port
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(0));
            int serverPort = serverSocketChannel.socket().getLocalPort();

            // Register the server socket channel with the selector for incoming connections
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Chat server started on port " + serverPort);

            // Server event loop
            while (true) {
                // Wait for events
                selector.select();

                // Get the selection keys for the events
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    // Accept incoming connection
                    if (key.isAcceptable()) {
                        acceptConnection(key);
                    }

                    // Read from a channel
                    if (key.isReadable()) {
                        readFromChannel(key);
                    }

                    // Remove the current key from the iterator
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the selector and server socket channel when finished
            try {
                selector.close();
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void acceptConnection(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);

        // Register the client channel for read events
        clientChannel.register(selector, SelectionKey.OP_READ);

        // Store the client channel with an initial empty username
        clientMap.put(clientChannel, "");

        System.out.println("New client connected: " + clientChannel.getRemoteAddress());
    }

    private void readFromChannel(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = clientChannel.read(buffer);

        if (bytesRead == -1) {
            // Connection closed by the client
            disconnectClient(clientChannel);
            return;
        }

        buffer.flip();
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);
        String message = new String(data, StandardCharsets.UTF_8).trim();

        if (clientMap.get(clientChannel).isEmpty()) {
            // First message is the username
            clientMap.put(clientChannel, message);
            System.out.println("New client username set: " + message);
        } else {
            // Chat message from client
            System.out.println("Received message from " + clientMap.get(clientChannel) + ": " + message);

            if (message.equalsIgnoreCase(END_CHAT_COMMAND)) {
                // Client wants to end the chat
                disconnectClient(clientChannel);
                return;
            }

            // Broadcast the message to all connected clients except the sender
            broadcastMessage(clientChannel, message);
        }
    }

    private void broadcastMessage(SocketChannel senderChannel, String message) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));

        for (SocketChannel clientChannel : clientMap.keySet()) {
            if (clientChannel != senderChannel) {
                clientChannel.write(buffer);
                buffer.rewind();
            }
        }
    }

    private void disconnectClient(SocketChannel clientChannel) throws IOException {
        String username = clientMap.get(clientChannel);
        clientChannel.close();
        clientMap.remove(clientChannel);

        System.out.println("Client disconnected: " + username);
    }

    public static void main(String[] args) {
        ChatServerApplication server = new ChatServerApplication();
        server.start();
    }
}