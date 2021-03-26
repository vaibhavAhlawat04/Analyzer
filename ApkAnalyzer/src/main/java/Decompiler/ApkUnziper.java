package Decompiler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ApkUnziper {

	private String apkFile = "/home/vaibhav/Documents/apkFile.apk";
	private String unZipLocation = "/home/vaibhav/Documents/unzipped";

	public static void main(String[] args) throws IOException {
		ApkUnziper unzipApk = new ApkUnziper("/home/vaibhav/Documents/apkFile.apk");
			unzipApk.unzip();	
	}

	public ApkUnziper(String apkFile) {
		if (apkFile == null) {
			throw new IllegalArgumentException("apkFile null");
		}

		this.apkFile = apkFile;
	}

	public static ApkUnziper getInstance(String apkFile) {
		return new ApkUnziper(apkFile);
	}

	
	public void unzip() throws IOException {

		byte[] buffer = new byte[1024];

		ZipInputStream zis = null;
		try {
			zis = new ZipInputStream(new FileInputStream(apkFile));
			//get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();
			System.out.println("Point a");


			while (ze != null) {

				String fileName = ze.getName();
				File newFile = new File(unZipLocation, fileName);

				//create all non exists folders
				//else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(newFile);
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}

				} catch (IOException e) {
					
				} finally {
					if (fos != null) {
						fos.close();
					}
				}
				ze = zis.getNextEntry();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} 

	}
}
