package ApkAnalyzer;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import ApkLocation.Locations;
import apkData.ApkManifestData;
import apkData.ApkSizeData;

public class analyzeApk {
	
	private static Locations locations = new Locations(); 
	private static ApkSizeData apkdata = new ApkSizeData(); 
	private static ApkManifestData manifestdata = new ApkManifestData();
	public analyzeApk(Path apkPath){
		
		System.out.println("Apk Location: " + locations.getApkPath());
		
		try {	
			File file = new File(System.getProperty("user.dir")+"/result.txt");
			FileWriter output = new FileWriter(file,true);
			System.out.println("OutputFile location:   " + System.getProperty("user.dir"));
			
			new Size(apkPath);	
			new Manifest();
			//new Debuggable();
			new ReadYml();
			System.out.println("Apk Size:  "+ "\n" + apkdata.toString());
			System.out.println("Manifest Data: "+ "\n" + manifestdata.toString());
			
			output.write(apkdata.toString());
			output.write(manifestdata.toString()+"%n");
			
			output.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}


}
