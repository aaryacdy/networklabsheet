package lab5;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
/*Aarya chaudhary
Roll No : 1*/
public class ReadContentFromServer {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
