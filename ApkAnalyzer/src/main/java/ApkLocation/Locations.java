package ApkLocation;

import java.nio.file.Path;

public class Locations {
	private static Path apkPath;
	private static Path DecompiledFolder;
		
	public Path getApkPath() {
		return apkPath;
	}
	public void setApkPath(Path apkPath) {
		this.apkPath = apkPath;
	}
	public Path getDecompiledFolder() {
		return DecompiledFolder;
	}
	public void setDecompiledFolder(Path decompiledFolder) {
		DecompiledFolder = decompiledFolder;
	} 

}
