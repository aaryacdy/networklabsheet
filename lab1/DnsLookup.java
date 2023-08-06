package lab1;

import java.net.*;
/*Aarya chaudhary
Roll No : 1*/
public class DnsLookup {
   public static void main(String[] args) {
      try {
         InetAddress[] addresses = InetAddress.getAllByName("dns.google.com");
         for (InetAddress address : addresses) {
            System.out.println(address.getHostAddress());
         }
      } catch (UnknownHostException e) {
         System.out.println("Could not find addresses for dns.google.com");
      }
   }
}

