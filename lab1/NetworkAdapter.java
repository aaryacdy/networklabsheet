package lab1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

/*Aarya chaudhary
Roll No : 1*/
public class NetworkAdapter {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
