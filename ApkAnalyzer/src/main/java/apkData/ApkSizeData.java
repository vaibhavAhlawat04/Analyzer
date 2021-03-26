package apkData;

public class ApkSizeData {
	private static String apkRawSize;
	private static String apkDownloadSize;
	private static String apkResourceSize;
	
	
	public static String getApkResourceSize() {
		return apkResourceSize;
	}
	public static void setApkResourceSize(String apkResourceSize) {
		ApkSizeData.apkResourceSize = apkResourceSize;
	}
	public String getApkRawSize() {
		return apkRawSize;
	}
	public void setApkRawSize(String apkRawSize) {
		ApkSizeData.apkRawSize = apkRawSize;
	}
	public String getApkDownloadSize() {
		return apkDownloadSize;
	}
	public void setApkDownloadSize(String apkDownloadSize) {
		ApkSizeData.apkDownloadSize = apkDownloadSize;
	}
	

	@Override
	public String toString() {
		return  "\n"+"\n"+"apkRawSize=" + apkRawSize + ", "
	   + "\n" + "apkDownloadSize=" + apkDownloadSize
	   + "\n" + "apkResourceSize=" + apkResourceSize;
	}
	
}
