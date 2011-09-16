package com.octo.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageFileAdator {

	public BufferedImage getImage(String imageFileName) {
		try {
			FileInputStream fileStream = new FileInputStream(new File(
					imageFileName));
			JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(fileStream);
			BufferedImage image = decoder.decodeAsBufferedImage();
			fileStream.close();
			return image;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void saveImage(BufferedImage image, String outFileName) {
		try {
			FileOutputStream fileStream = new FileOutputStream(new File(
					outFileName));
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileStream);
			encoder.encode(image);
			fileStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
