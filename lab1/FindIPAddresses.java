package lab1;

import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class FindIPAddresses {
    public static void main(String[] args) {
        try {
            var hostname = "google.com";
            InetAddress inetAddresses = InetAddress.getByName(hostname);
            System.out.println("IPV4 Address : " + inetAddresses.getHostAddress());
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            for (InetAddress address : addresses) {
                if (address instanceof Inet6Address)
                    System.out.println("IPv6: " + address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
