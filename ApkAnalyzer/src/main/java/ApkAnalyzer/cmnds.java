package ApkAnalyzer;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class cmnds {
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("bash", "-c","aapt dump badging /home/vaibhav/Documents/apkFile.apk | grep versionName=");
		
		try {
			Process process = pb.start();
			
			printResults(process);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void printResults(Process process) throws IOException {
		 FileWriter myWriter = new FileWriter("result.txt");
		 
	    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	        System.out.println(line);
	        myWriter.write(line + "\n");
	    }
	      
	      myWriter.close();

	}

}
