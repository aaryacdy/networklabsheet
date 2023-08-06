package lab1;

import java.io.IOException;
import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class HostReachability {
    public static void main(String[] args) {
        try {
            var hostname  = "tu.edu.np";
            InetAddress inetAddress = InetAddress.getByName(hostname);
            if (inetAddress.isReachable(5000)) {
                System.out.println(hostname + " is reachable.");
            } else {
                System.out.println(hostname + " is not reachable.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
