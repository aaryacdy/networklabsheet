package lab1;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressEx {

	public static void main(String[] args)throws UnknownHostException {
		// TODO Auto-generated method stub
		String url="www.tufohss.edu.np";
		InetAddress ip1 = InetAddress.getByName(url);
		System.out.println("Address :" +ip1.getHostAddress());
	}

}


