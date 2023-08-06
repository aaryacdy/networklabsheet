package lab1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*Aarya chaudhary
Roll No : 1*/
public class WebLog {

	public static void main(String[] args) throws IOException {
		String logFile =("np.txt") ;
		for (int i = 0; i <= 2; i++) {
			Map<String, String> ipCounts = new HashMap<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] fields = line.split(" ");
					if (fields.length > 0) {
						String ipAddress = fields[0];
						ipCounts.put(ipAddress, fields[5]+"-"+fields[6]);
					}
				}
			}
			for (Map.Entry<String, String> entry : ipCounts.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
}
