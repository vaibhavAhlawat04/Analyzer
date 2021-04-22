package ApkAnalyzer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import apkData.ApkManifestData;


public class ReadYml {
	public ReadYml() throws IOException {
		String location = System.getProperty("user.dir") + "/Decompiled/apktool.yml";


		FileReader fr = new FileReader(location);
		BufferedReader br = new BufferedReader(fr);
		Yaml yaml = new Yaml();

		while((br.readLine())!=null) {
			//System.out.println(str.toString());
			Map<String, Object> data = yaml.load(br);
			//System.out.println(data);  
			//System.out.println(data.get("sdkInfo"));
		//	System.out.println(data.get("versionInfo"));
			ApkManifestData.setApkInfo(data.get("versionInfo"));
			ApkManifestData.setSdkInfo(data.get("sdkInfo"));
			
		}

		br.close();
	}

}
