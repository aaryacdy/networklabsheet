package lab1;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class SpamChecking {
	public static final String BLACKHOLE = "sbl.spamhaus.org";
	public static void main(String args[]) throws UnknownHostException {
		String arg = "202.166.206.236";
		if (isSpammer(arg)) {
			System.out.println(arg + " is a spammer.");
		} else {
			System.out.println(arg + " appear legitimate.");
		}
	}
	private static boolean isSpammer(String arg) {
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? +256 : octet;
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}
}