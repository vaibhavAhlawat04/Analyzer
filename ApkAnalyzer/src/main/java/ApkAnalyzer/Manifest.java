package ApkAnalyzer;

import java.io.File;
import java.nio.file.Paths;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ApkLocation.Locations;
import Decompiler.ApkDecompiler;

public class Manifest {


	private static ApkDecompiler Dcompiler;
	private static Locations location = new Locations();
	private static String apkFile = location.getApkPath().toString();


	public Manifest() {
		//System.out.println(System.getProperty("user.dir"));
		location.setDecompiledFolder(Paths.get(System.getProperty("user.dir") + "/Decompiled"));
		Dcompiler = new ApkDecompiler(apkFile);
		try {
			Dcompiler.decompile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File manifestFile = new File(location.getDecompiledFolder().toString() + "/AndroidManifest.xml");
			//System.out.println(manifestFile.getAbsolutePath());

			if(manifestFile.exists()) {
				SAXParserFactory factory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = factory.newSAXParser(); 
				ManifestHandler usrhandler = new ManifestHandler();
				saxParser.parse(manifestFile, usrhandler);
			}

		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}

}
