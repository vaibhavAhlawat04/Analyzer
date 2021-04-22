package apkData;

import java.util.List;
import java.util.Map;


public class ApkManifestData {
	
	private static String packageName;
	private static List<?> permissionsList;
	private static String compileSdkVersionName;
	private static String compileSdkVersion;
	private static List<?> activityList;
	private static Object apkInfo;
	private static Object sdkInfo;
	private static boolean Debuggable;
	private static Map<String,String> SupportedScreens;
	private static String versionName;
	private static String versionCode;
	private static List<?> Services;
	private static List<?> ContentProvider;
	
	public static Object getSdkInfo() {
		return sdkInfo;
	}

	public static void setSdkInfo(Object sdkInfo) {
		ApkManifestData.sdkInfo = sdkInfo;
	}

	public static Object getApkInfo() {
		return apkInfo;
	}

	public static void setApkInfo(Object object) {
		ApkManifestData.apkInfo = object;
	}
	
	public static List<?> getContentProvider() {
		return ContentProvider;
	}

	public void setContentProvider(List<?> contentProvider) {
		ApkManifestData.ContentProvider = contentProvider;
	}

	public static List<?> getServices() {
		return Services;
	}

	public void setServices(List<?> services) {
		ApkManifestData.Services = services;
	}

	public static String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String string) {
		ApkManifestData.versionCode = string;
	}

	public static String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		ApkManifestData.versionName = versionName;
	}

	public static boolean isDebuggable() {
		return Debuggable;
	}

	public void setDebuggable(boolean debuggable) {
		ApkManifestData.Debuggable = debuggable;
	}

	public static List<?> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<?> activityList) {
		ApkManifestData.activityList = activityList;
	}

	public static String getCompileSdkVersionName() {
		return compileSdkVersionName;
	}

	public void setCompileSdkVersionName(String compileSdkVersionName) {
		ApkManifestData.compileSdkVersionName = compileSdkVersionName;
	}

	public static String getPackageName() {
		return packageName;
	}

	public static void setPackageName(String packageName) {
		ApkManifestData.packageName = packageName;
	}

	public static List<?> getPermissions() {
		return permissionsList;
	}

	public static Map<String, String> getSupportedScreens() {
		return SupportedScreens;
	}

	public void setSupportedScreens(Map<String, String> supportsScreens) {
		ApkManifestData.SupportedScreens = supportsScreens;
	}

	public static void setPermissions(List<?> permissionsList) {
		ApkManifestData.permissionsList = permissionsList;
	}

	public static String getCompileSdkVersion() {
		return compileSdkVersion;
	}

	public void setCompileSdkVersion(String compileSdkVersion) {
		ApkManifestData.compileSdkVersion = compileSdkVersion;
	}

	@Override
	public String toString() {
		return  "PackageName= " + packageName
			+"\n" + "Debuggable= " + Debuggable
			+"\n" +    apkInfo 
			+"\n" + sdkInfo
			+"\n" + "CompiledSdkVersion= " + compileSdkVersion
			+"\n" + "CompileSdkVersionName= "+ compileSdkVersionName
			+"\n" + "SupportedScreenSize= " + SupportedScreens
			+"\n" + "Permissions"+"["+permissionsList.size()+"]="  + permissionsList
			+"\n" + "Activities"+"["+activityList.size()+"]=" + activityList
			+"\n" + "Services"+"["+Services.size()+"]=" + Services
			+"\n" + "ContentProviders"+"["+ContentProvider.size()+"]=" + ContentProvider;
			
	}
	
	

}
