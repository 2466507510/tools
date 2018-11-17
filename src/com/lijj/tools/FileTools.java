package com.lijj.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTools {

	private FileTools() {

	}

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

	// 判断是否存在这个文件
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

//	static int a = 0;
	private static String str = "没有该文件";

	// 在硬盘中查找文件的位置 fileName表示文件名 path表示路径
	public static String findFile(String fileName, String path) {
//		System.out.println(fileName + "   " + path);
		File file = new File(path);
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.listFiles().length);
		if (file.listFiles() != null && file.listFiles().length > 0) {
			for (File f : file.listFiles()) {
//				System.out.println(f.getAbsolutePath());
//				a++;
//			  System.out.println(f.isDirectory());
//			  System.out.println(f.isFile());
				if (f.isFile()) {
//				System.out.println(f.getName());
//				System.out.println(fileName);
//				System.out.println(f.getName().equals(fileName));
					if (fileName.equals(f.getName())) {
//					System.out.println(f.getName());
//					System.out.println(fileName);
//						System.out.println(fileName.equals(f.getName()));
//					System.out.println(f.getAbsolutePath());
						str = f.getAbsolutePath();
					}
				} else if (f.isDirectory()) {
//					System.out.println(f.getAbsolutePath());
					findFile(fileName, f.getAbsolutePath());
				}

			}
		}
//		System.out.println(a);
		return str;
	}
}
