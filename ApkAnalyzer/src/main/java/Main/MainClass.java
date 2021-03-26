package Main;

import java.nio.file.Path;
import java.nio.file.Paths;

import ApkAnalyzer.analyzeApk;
import ApkLocation.Locations;

public class MainClass {
	private static Path apkPath;
	private static Locations location = new Locations();

	public static void main(String[] args) {
		// /home/vaibhav/Documents/apkFile.apk  
		apkPath=Paths.get(args[0]);
		location.setApkPath(apkPath);
		
		new analyzeApk(apkPath);
		
		// /home/vaibhav/Documents/Apks/old.apk
		if(args.length>=2) {
			//System.out.println("Second Apk ");
			
			apkPath=Paths.get(args[1]);
			location.setApkPath(apkPath);
			
			new analyzeApk(apkPath);
		}	
	}

}
