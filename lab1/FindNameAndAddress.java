package lab1;

import java.net.*;

/*Aarya chaudhary
Roll No : 1*/
public class FindNameAndAddress {

    public static void main(String[] args) throws UnknownHostException {
        var addressStr = "fohss.tu.edu.np";
        try {
            InetAddress address = InetAddress.getByName(addressStr);
            System.out.println("The IP Address is  : " + address.getHostAddress());
            System.out.println("The Hostname is : " + address.getHostName());
        } catch (Exception e) {
            System.out.println("Could not find address for " + addressStr);
        }
    }
}
