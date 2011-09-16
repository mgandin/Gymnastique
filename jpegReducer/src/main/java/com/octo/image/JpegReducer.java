package com.octo.image;

import java.awt.image.BufferedImage;

public class JpegReducer {

	private ImageFileAdator imageFileAdator;
	private ImageReducer imageReducer;
	
	public JpegReducer(ImageFileAdator imageFileAdator,ImageReducer imageReducer) {
		this.imageFileAdator = imageFileAdator;
		this.imageReducer = imageReducer;
	}

	public void reduce(String imageFileName,String outFileName) {
		BufferedImage image = imageFileAdator.getImage(imageFileName);
		BufferedImage imageReduced = imageReducer.reduce(image);
		imageFileAdator.saveImage(imageReduced, outFileName);
		
	}

}
