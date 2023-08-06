package lab1;

import java.net.*;

/*Aarya chaudhary
Roll No : 1*/
public class LocalMachine {
    public static void main(String[] args) {
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Name: " + localAddress.getHostName());
            System.out.println("IP Address: " + localAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Could not find local machine");
        }
    }
}

