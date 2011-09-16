package com.octo.image;

import java.io.File;

public class Run {

	public static void main(String args[]) {
		String dirName = args[0];
		File dir = new File(dirName);
		if (dir.isDirectory()) {
			JpegReducer jpegReducer = new JpegReducer(new ImageFileAdator(),
					new ImageReducer());
			String[] imageFiles = dir.list();
			File outDir = new File(dir.getAbsolutePath() + "/out");
			outDir.mkdir();
			for (int i = 0; i < imageFiles.length; i++) {
				jpegReducer.reduce(dir.getAbsolutePath() + "/" + imageFiles[i],
						dir.getAbsolutePath() + "/out/" + imageFiles[i]);
			}
		}
	}
}
