package ApkAnalyzer;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import ApkLocation.Locations;
import apkData.ApkManifestData;
import apkData.ApkSizeData;

public class analyzeApk {
	
	private static Size apkSize; 
	private static Locations locations = new Locations(); 
	private static ApkSizeData apkdata = new ApkSizeData(); 
	private static Manifest manifest;
	private static ApkManifestData manifestdata = new ApkManifestData();
	private static Debuggable debugable;
	
	public analyzeApk(Path apkPath){
		
		System.out.println("Apk Location: " + locations.getApkPath());
		
		try {	
			File file = new File(System.getProperty("user.dir")+"/result.txt");
			FileWriter output = new FileWriter(file,true);
			System.out.println("OutputFile location:   " + System.getProperty("user.dir"));
			
			apkSize = new Size(apkPath);	
			manifest = new Manifest();
			debugable = new Debuggable();
			
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
