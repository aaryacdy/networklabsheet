package lab2;
import java.io.UnsupportedEncodingException;
/*Aarya chaudhary
Roll No : 1*/
public class URLEncoder {
    public static void main(String[] args) {
        try {
            System.out.println(java.net.URLEncoder.encode("This string has space", "UTF-8"));
            System.out.println(java.net.URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
            System.out.println(java.net.URLEncoder.encode("This%string%has%percent", "UTF-8"));
            System.out.println(java.net.URLEncoder.encode("This+string+has+pluse", "UTF-8"));
            System.out.println(java.net.URLEncoder.encode("This=string=has=equals=sign", "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken Vmdoes not support utf-8");
		}
    }
}
