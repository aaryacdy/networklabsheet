package lab3;
import java.net.*;
import java.util.*;
/*Aarya chaudhary
Roll No : 1*/
public class MyCookiePolicy implements CookiePolicy {
	public boolean shouldAccept(URI uri, HttpCookie cookie) {
		System.out.println("checking policy");
		if (uri.getHost().endsWith(".com")) {
			System.out.println("blocked for the domain: " + uri);
			return false;
		}
		System.out.println("not blocked for the domain: " + uri);
		return true;
	}

	public static void main(String[] args) {
		CookieManager cm = new CookieManager();
		CookiePolicy policy = new MyCookiePolicy();
		cm.setCookiePolicy(policy);
		// try adding cookies
		URI uri, uri1;
		try {
			uri = new URI("http://kathford.edu.np");
			uri1 = new URI("http://kathford.com");
			System.out.print("Inserting cookie");
			policy.shouldAccept(uri, new HttpCookie("name", "value"));
			policy.shouldAccept(uri1, new HttpCookie("name", "value"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
