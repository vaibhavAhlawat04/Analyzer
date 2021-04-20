package ApkAnalyzer;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import apkData.ApkManifestData;

public class ManifestHandler  extends DefaultHandler {

	private ApkManifestData manifestdata= new ApkManifestData();
	private List<String> activityList = new ArrayList<String>();
	private List<String> permissionList = new ArrayList<String>();
	private List<String> ServiceList = new ArrayList<String>();
	private List<String> contentProviderList = new ArrayList<String>();


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if(qName.equalsIgnoreCase("manifest")) {
			manifestdata.setCompileSdkVersion(attributes.getValue("android:compileSdkVersion"));
			ApkManifestData.setPackageName(attributes.getValue("package"));
			manifestdata.setCompileSdkVersionName(attributes.getValue("android:compileSdkVersionCodename"));
		}
		if(qName.equalsIgnoreCase("activity")) {
			activityList.add(attributes.getValue("android:name"));
			manifestdata.setActivityList(activityList);
		}
		if(qName.equalsIgnoreCase("uses-permission")) {
			permissionList.add(attributes.getValue("android:name"));
			ApkManifestData.setPermissions(permissionList);
		}
		if(qName.equalsIgnoreCase("Service")) {
			ServiceList.add(attributes.getValue("android:name"));
			manifestdata.setServices(ServiceList);

		}
		if(qName.equalsIgnoreCase("provider")) {
			contentProviderList.add(attributes.getValue("android:authorities"));
			manifestdata.setContentProvider(contentProviderList);

		}
	}	


}
