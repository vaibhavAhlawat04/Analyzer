package ApkAnalyzer;

import com.android.SdkConstants;
import com.android.annotations.NonNull;
import com.android.ide.common.xml.AndroidManifestParser;
import com.android.ide.common.xml.ManifestData;
import com.android.ide.common.xml.ManifestData.SupportsScreens;
import com.android.tools.apk.analyzer.Archive;
import com.android.tools.apk.analyzer.ArchiveContext;
import com.android.tools.apk.analyzer.Archives;
import com.android.tools.apk.analyzer.BinaryXmlParser;

import ApkLocation.Locations;
import apkData.ApkManifestData;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Debuggable {
    private static ArchiveContext archive;
	private static Locations locations = new Locations(); 
	private static ApkManifestData manifest = new ApkManifestData();
	
	public Debuggable(){
		
		Path apkPath = locations.getApkPath();
		try { 		
		
			archive =Archives.open(apkPath);
			
			manifest.setDebuggable(manifestDebuggable());
			
			//manifest.setSupportedScreens(ScreenSupport());
			
			//ApkManifestData.setMinSdkVersion(minSdkVersion());
			
			manifest.setVersionName(manifestPrint().substring(manifestPrint().indexOf("versionName")+12, manifestPrint().indexOf("versionName")+20));
			manifest.setVersionCode(manifestVersionCode());
			
			//manifest.setTargetSdkVersion(targetSdkVersion());
			//System.out.println(targetSdkVersion());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 @NonNull
	  private static ManifestData getManifestData(@NonNull Archive archive)
	            throws IOException, ParserConfigurationException, SAXException{
	        Path manifestPath = archive.getContentRoot().resolve(SdkConstants.ANDROID_MANIFEST_XML);
	        byte[] manifestBytes =
	                BinaryXmlParser.decodeXml(
	                        SdkConstants.ANDROID_MANIFEST_XML, Files.readAllBytes(manifestPath));
	        try {
				return AndroidManifestParser.parse(new ByteArrayInputStream(manifestBytes));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
	    public static boolean manifestDebuggable() {
	        try { 	
	            ManifestData manifestData = getManifestData(archive.getArchive());
	            return manifestData.getDebuggable() != null ? manifestData.getDebuggable() : false;
	        } catch (SAXException | ParserConfigurationException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new UncheckedIOException(e);
	        }
	    }
	    public static SupportsScreens ScreenSupport(){
	    	try {
	            ManifestData manifestData = getManifestData(archive.getArchive());
	            return manifestData.getSupportsScreensValues();
	        } catch (SAXException | ParserConfigurationException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new UncheckedIOException(e);
	        }
	    }
	    public static int minSdkVersion(){
	        try {
	            ManifestData manifestData = getManifestData(archive.getArchive());
	            return manifestData.getMinSdkVersion();
	        } catch (SAXException | ParserConfigurationException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new UncheckedIOException(e);
	        }
	    }
	    public static String manifestVersionCode(){
	        try {
	            ManifestData manifestData = getManifestData(archive.getArchive());
	          
	           return String.format("%d", manifestData.getVersionCode());
	        } catch (SAXException | ParserConfigurationException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new UncheckedIOException(e);
	        }
	    }
	    
	    public static String manifestPrint() {
	        try {
	            Path path = archive.getArchive().getContentRoot().resolve(SdkConstants.ANDROID_MANIFEST_XML);
	            byte[] bytes = Files.readAllBytes(path);
	            return new String(BinaryXmlParser.decodeXml(path.getFileName().toString(), bytes));
	        } catch (IOException e) {	 
	            throw new UncheckedIOException(e);
	        }
	    }
	    public int targetSdkVersion(){
	    	try {
	    		ManifestData manifestData = getManifestData(archive.getArchive());
	    		return manifestData.getTargetSdkVersion();
	    	}catch (SAXException | ParserConfigurationException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new UncheckedIOException(e);
	        }
	    }
}
