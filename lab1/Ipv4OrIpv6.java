package lab1;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
/*Aarya chaudhary
Roll No : 1*/
public class Ipv4OrIpv6 {

	public static void main(String[] args) throws UnknownHostException {
		String url = "192.168.10.1";
		byte add[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		InetAddress ip1 = Inet4Address.getByName(url);
		InetAddress ip2 = Inet6Address.getByAddress(add);
		if (ip1.getAddress().length == 4) {
			System.out.println(" This is Address IPv4 :" + ip1.getHostAddress());
		} else {
			System.out.println("This is Address IPv6 :" + ip2.getHostAddress());
		}
	}
}