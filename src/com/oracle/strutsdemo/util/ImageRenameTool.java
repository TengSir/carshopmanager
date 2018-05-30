package com.oracle.strutsdemo.util;

import java.io.File;

public class ImageRenameTool {

	public static void renameImagesByPath(String path, int start) {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] childs = dir.listFiles();
			for (File f : childs) {
				if (f.isFile()) {
					System.out.println(f.getName());
					f.renameTo(new File("videos/new/" + start
							+ f.getName().substring(f.getName().lastIndexOf("."), f.getName().length())));
					start++;
				}
			}
		}
	}

	public static void main(String[] args) {
		renameImagesByPath("videos", 1);
	}

}
