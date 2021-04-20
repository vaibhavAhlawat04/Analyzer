package ApkAnalyzer;

import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

import com.android.annotations.NonNull;
import com.android.tools.apk.analyzer.ApkSizeCalculator;

import ApkLocation.Locations;
import apkData.ApkSizeData;

public class Size {

	public Locations locations;	 
	private long ResourceSize = 0;
	private ApkSizeData apkdata = new ApkSizeData(); 
	
	
	public Size(Path apkPath) {
		if(apkPath!=null) {
				apkdata.setApkRawSize(apkRawSize(apkPath));
				apkdata.setApkDownloadSize(apkDownloadSize(apkPath));
				ApkSizeData.setApkResourceSize(apkResourceSize(apkPath));
		
		}else {
			System.out.println("Null path");
		}
		
	}
	public String apkResourceSize(Path apkPath) {
		 Map<String, Long> map = Size.sizePerFile(apkPath);
			for (Entry<String, Long> entry : map.entrySet()) {
				if(entry.getKey().startsWith("/res/")) {
				     ResourceSize= entry.getValue() + ResourceSize;
					}
			   			}
			return getSize(ResourceSize);	
	}


	public static String apkDownloadSize(Path apkPath) {
        ApkSizeCalculator sizeCalculator = ApkSizeCalculator.getDefault();
        return getSize(sizeCalculator.getFullApkDownloadSize(apkPath));
    }

    public static String apkRawSize(Path apkPath) {
    	
        ApkSizeCalculator sizeCalculator = ApkSizeCalculator.getDefault();
        
        return getSize(sizeCalculator.getFullApkRawSize(apkPath));
    }
    private static String getSize(long bytes) {
        return getHumanizedSize(bytes);
    }
    
    public static Map<String, Long> sizePerFile(Path apkPath) {
    	   ApkSizeCalculator sizeCalculator = ApkSizeCalculator.getDefault();
    	return sizeCalculator.getRawSizePerFile(apkPath);
    }
    
    @NonNull
    static String getHumanizedSize(long sizeInBytes) {
        long kilo = 1024;
        long mega = kilo * kilo;

        DecimalFormat formatter = new DecimalFormat("#.#");
        int sign = sizeInBytes < 0 ? -1 : 1;
        sizeInBytes = Math.abs(sizeInBytes);
        if (sizeInBytes > mega) {
            return formatter.format((sign * sizeInBytes) / (double) mega) + "MB";
        } else if (sizeInBytes > kilo) {
            return formatter.format((sign * sizeInBytes) / (double) kilo) + "KB";
        } else {
            return (sign * sizeInBytes) + "B";
        }
    }
    

}
