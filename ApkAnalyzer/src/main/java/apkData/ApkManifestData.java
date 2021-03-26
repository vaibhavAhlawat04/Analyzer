package apkData;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.android.ide.common.xml.ManifestData.SupportsScreens;


public class ApkManifestData {
	
	private static String packageName;
	private static List permissionsList;
	private static String compileSdkVersionName;
	private static String compileSdkVersion;
	private static List activityList;
	private static boolean Debuggable;
	private static SupportsScreens SupportedScreens;
	private static int minSdkVersion;
	private static int targetSdkVersion;
	private static String versionName;
	private static String versionCode;
	private static List Services;
	private static List ContentProvider;
	
	public static int getTargetSdkVersion() {
		return targetSdkVersion;
	}

	public void setTargetSdkVersion(int targetSdkVersion) {
		this.targetSdkVersion = targetSdkVersion;
	}
	
	public static List getContentProvider() {
		return ContentProvider;
	}

	public void setContentProvider(List contentProvider) {
		this.ContentProvider = contentProvider;
	}

	public static List getServices() {
		return Services;
	}

	public void setServices(List services) {
		this.Services = services;
	}

	public static String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String string) {
		this.versionCode = string;
	}

	public static String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		ApkManifestData.versionName = versionName;
	}

	public static int getMinSdkVersion() {
		return minSdkVersion;
	}

	public static void setMinSdkVersion(int minSdkVersion) {
		ApkManifestData.minSdkVersion = minSdkVersion;
	}

	public static boolean isDebuggable() {
		return Debuggable;
	}

	public void setDebuggable(boolean debuggable) {
		this.Debuggable = debuggable;
	}

	public static List getActivityList() {
		return activityList;
	}

	public void setActivityList(List activityList) {
		ApkManifestData.activityList = activityList;
	}

	public static String getCompileSdkVersionName() {
		return compileSdkVersionName;
	}

	public void setCompileSdkVersionName(String compileSdkVersionName) {
		this.compileSdkVersionName = compileSdkVersionName;
	}

	public static String getPackageName() {
		return packageName;
	}

	public static void setPackageName(String packageName) {
		ApkManifestData.packageName = packageName;
	}

	public static List getPermissions() {
		return permissionsList;
	}

	public static SupportsScreens getSupportedScreens() {
		return SupportedScreens;
	}

	public void setSupportedScreens(SupportsScreens supportsScreens) {
		this.SupportedScreens = supportsScreens;
	}

	public static void setPermissions(List permissionsList) {
		ApkManifestData.permissionsList = permissionsList;
	}

	public static String getCompileSdkVersion() {
		return compileSdkVersion;
	}

	public void setCompileSdkVersion(String compileSdkVersion) {
		this.compileSdkVersion = compileSdkVersion;
	}

	@Override
	public String toString() {
		return  "\n"+  "apkVersion= "+ versionName
			 +"\n"+ "VersionCode= " + versionCode
			+"\n" + "PackageName= " + packageName  
			+"\n" + "Debuggable= " + Debuggable
			+"\n" + "MinSdkVersion= " + minSdkVersion
			+"\n" + "TargetSdkVersion= " + targetSdkVersion
			+"\n" + "CompiledSdkVersion= " + compileSdkVersion
			+"\n" + "CompileSdkVersionName= "+ compileSdkVersionName
			+"\n" + "SupportedScreenSize= " + SupportedScreens
			+"\n" + "Permissions"+"["+permissionsList.size()+"]="  + permissionsList
			+"\n" + "Activities"+"["+activityList.size()+"]=" + activityList
			+"\n" + "Services"+"["+Services.size()+"]=" + Services
			+"\n" + "ContentProviders"+"["+ContentProvider.size()+"]=" + ContentProvider;
			
	}
	
	

}
