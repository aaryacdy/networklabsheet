package lab1;
import java.net.InetAddress;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class CanonicalEx {
	public static void main(String[] args) {
	      try {
//	         InetAddress address = InetAddress.getByName("google.com");
	         InetAddress address = InetAddress.getByName("8.8.8.8");
	         System.out.println("Canonical Hostname: " + address.getCanonicalHostName());
	         System.out.println("Hostname: " + address.getHostName());
	         System.out.println("IP address: " + address.getHostAddress());
	      } catch (UnknownHostException e) {
	         System.out.println("Could not find IP address");
	      }
	   }
}