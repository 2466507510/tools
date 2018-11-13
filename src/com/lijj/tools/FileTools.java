package com.lijj.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTools {

	// 文件拷贝
	public static void fileCopy(String pathName1, String pathName2) {
		File fromFile = new File(pathName1);
		File toFile = new File(pathName2);
		if (ifExitFile(toFile)) {
			try {
				throw new Exception("目标文件名称已存在，不允许复制或覆盖原文件");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fromFile);
			byte[] all = new byte[(int) fromFile.length()];
			fis.read(all);

			File _toFile = toFile.getParentFile();
			if (!_toFile.exists()) {
				_toFile.mkdirs();
			}
			fos = new FileOutputStream(toFile);
			fos.write(all);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean ifExitFile(File file) {
		File parentFile = file.getParentFile();
		File[] files = parentFile.listFiles();
		for (File f : files) {
//			System.out.println(f.getName());
			if (f.getName().equals(file.getName())) {
				return true;
			}

		}
		return false;
	}
}
