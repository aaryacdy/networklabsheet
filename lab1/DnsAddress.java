package lab1;

import java.net.*;

public class DnsAddress {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		 String s = "https:// www.google.com/";
		try {
            // Fetch IP address by getByName()
            InetAddress ip = InetAddress.getByName(new URL(s).getHost());
 
            // Print the IP address
            System.out.println("Public IP Address of: " + ip);
        }
        catch (MalformedURLException e) {
            // It means the URL is invalid
            System.out.println("Invalid URL");
        }
		
		
		 
	}

}
