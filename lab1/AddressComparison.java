package lab1;

import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class AddressComparison {
    public static void main(String[] args) {
       try {
           InetAddress addressFirst = InetAddress.getByName("tu.edu.np");
           InetAddress addressSecond = InetAddress.getByName("fohss.tu.edu.np");
           if(addressFirst.getHostAddress().equals(addressSecond.getHostAddress())) {
               System.out.println("Address is same.");
           } else {
               System.out.println("Address is different.");
           }
       }catch (Exception e) {
           e.printStackTrace();
           System.out.println("Could not resolve host name.");
       }
    }
}
