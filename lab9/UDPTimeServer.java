package lab9;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
/*Aarya chaudhary
Roll No : 1*/
public class UDPTimeServer {
	 private static final int PORT = 56789;
	 	public static void main(String[] args) {
	        try (DatagramSocket socket = new DatagramSocket(PORT)) {
	            System.out.println("Server started on port " + PORT);
	            while (true) {
	                byte[] buffer = new byte[256];
	                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	                socket.receive(packet);
	                InetAddress clientAddress = packet.getAddress();
	                int clientPort = packet.getPort();
	                String response = new Date().toString();
	                byte[] responseData = response.getBytes();
	                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
	                        clientAddress, clientPort);
	                socket.send(responsePacket);
	                System.out.println("Sent response to " + clientAddress.getHostAddress() + ":" + clientPort);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }}
}
