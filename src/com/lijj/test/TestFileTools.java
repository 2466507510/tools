package com.lijj.test;

import com.lijj.tools.FileTools;

/**
 * Created by LIJJAI on 2018/11/9.
 */
public class TestFileTools {
	public static void main(String[] a) {
//		FileTools.fileCopy("C:\\Program_Files\\Java\\1.8_64\\jdk1.8.0_141\\src.zip", "D:/china/sr.zip");
//		System.out.println(FileTools.ifExitFile(new File("D:/china/sc.zip")));
		System.out.println(FileTools.findFile("SourceTreeSetup-2.1.2.5.exe", "d:/tools"));
	}
}
