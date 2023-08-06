package lab3;
import java.net.*;
import java.util.*;
/*Aarya chaudhary
Roll No : 1*/
public class MyCookieManagerEx {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();
        // creating cookies and uri
        HttpCookie cookieA = new HttpCookie("1", "Aarya");
        HttpCookie cookieB = new HttpCookie("2", "Aman");
        URI u1 = URI.create("https://test1.com");
        URI u2 = URI.create("https://test2.com");
//add cookies into cookie store
        cookieStore.add(u1, cookieA);
        cookieStore.add(u2, cookieB);
        System.out.println("cookie added sucessfully.");
//read store all cookies
        List cookieList = cookieStore.getCookies();
        System.out.println("Cookies in CookieStore : " + cookieList + "\n");
        List cookieListu1 = cookieStore.get(u1);
        System.out.println("Cookies list in CookieStore:" + cookieListu1);

        List cookieListu2 = cookieStore.get(u2);
        System.out.println("Cookies list in CookieStore:" + cookieListu2 + "\n");
//remove cookie of uri
        System.out.println("Removal of Cookie : " + cookieStore.remove(u1, cookieA));
        System.out.println("Remaining Cookies : " + cookieListu1 + "\n");

        System.out.println("Removal of Cookie : " + cookieStore.remove(u2, cookieB));
        System.out.println("Remaining Cookies : " + cookieListu2 + "\n");

        // Method 6 - removeAll()
        System.out.println("Removal of all Cookies : " + cookieStore.removeAll());
        System.out.println("Empty CookieStore : " + cookieList);
    }
}
