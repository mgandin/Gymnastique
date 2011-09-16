package com.octo.image;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestJpegReducer {

	private JpegReducer jpegReducer;
	
	@Before
	public void setUp() throws Exception {
		jpegReducer = new JpegReducer(new ImageFileAdator(),new ImageReducer());
	}

	@Test
	public void testAll() throws Exception {
		jpegReducer.reduce("src/test/resources/photos/Velasquez-las-meninias.jpg","test.jpg");
		File file = new File("test.jpg");
		Assert.assertTrue(file.isFile());
		file.delete();
	}
}
