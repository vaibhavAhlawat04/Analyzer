package Decompiler;

import java.io.File;

import brut.androlib.Androlib;
import brut.androlib.AndrolibException;
import brut.androlib.ApkDecoder;
import brut.androlib.ApkOptions;

public class ApkDecompiler {
	
	private static String apkFile ;
	private String DecompiledLocation = System.getProperty("user.dir") + "/Decompiled";
	private static boolean isFrameworkInstalled;


	public ApkDecompiler(String apkFile) {
		if(apkFile==null) {
			throw new IllegalArgumentException();
		}
		synchronized (ApkDecompiler.class) {
			if (isFrameworkInstalled == false) {
				installFramework(); //we need to install framework, otherwise some apk cannot be decompiled (arsc cannot decompile)
				isFrameworkInstalled = true;
			}
		}
		ApkDecompiler.apkFile = apkFile;
	}

	private void installFramework() {
		ApkOptions apkOptions = new ApkOptions();
		try {
			new Androlib(apkOptions).installFramework(new File("libs" + File.separator + "framework-res.apk"));
		} catch (AndrolibException e) {
			System.out.println("failed installation");
			e.printStackTrace();
		}

	}

	public ApkDecompiler getInstance(String apkFile) {
		return new ApkDecompiler(apkFile);
	}
	public void decompile() throws Exception{
		File file = new File(apkFile);
		ApkDecoder decoder = new ApkDecoder();
		decoder.setApkFile(file);
		decoder.setForceDelete(true);

		try {
			decoder.setDecodeSources((short)0);   
		}catch(AndrolibException alib) {
			alib.printStackTrace();
		}
		try {
			File output = new File(DecompiledLocation);
			decoder.setOutDir(output);
		}catch(AndrolibException alib) {
			alib.printStackTrace();
		}
		try {
			decoder.decode();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
