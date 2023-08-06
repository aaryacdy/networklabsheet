package lab5;
import java.io.*;
import java.net.Socket;
/*Aarya chaudhary
Roll No : 1*/
public class WriteContentToServer {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            writer.write("bye\r\n");
            writer.flush();
            // Read data from the server and print it to the console
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
