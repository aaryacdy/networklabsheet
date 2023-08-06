package lab9;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*Aarya chaudhary
Roll No : 1*/
public class UDPTimeClient {
	 private static final int PORT = 56789;
	    public static void main(String[] args) {
	        try (DatagramSocket socket = new DatagramSocket()) {
	            InetAddress serverAddress = InetAddress.getLocalHost();
	            byte[] requestData = new byte[1];
	            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, serverAddress, PORT);
	            socket.send(requestPacket);
	            byte[] buffer = new byte[256];
	            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
	            socket.receive(responsePacket);
	            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
	            System.out.println("Server response: " + response);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
