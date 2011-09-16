package com.octo.image;

import java.awt.image.BufferedImage;
import java.io.File;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestImageFileAdaptor {

	private ImageFileAdator loader;
	
	@Before
	public void setUp() throws Exception {
		loader = new ImageFileAdator();
	}
	
	@Test
	public void testGetImage() {
		BufferedImage image = loader.getImage("src/test/resources/photos/Velasquez-las-meninias.jpg");
		Assert.assertNotNull(image);
	}
	
	public void testSaveImage() {
		BufferedImage image;
		image = loader.getImage("src/test/resources/photos/Velasquez-las-meninias.jpg");
		
		loader.saveImage(image,"out.jpg");
		File file = new File("out.jpg");
		Assert.assertTrue(file.isFile());
		file.delete();
	}

}
