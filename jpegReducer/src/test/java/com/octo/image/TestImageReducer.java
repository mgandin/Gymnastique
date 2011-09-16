package com.octo.image;

import java.awt.Image;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestImageReducer {

	private ImageReducer imageReducer;
	
	@Before
	public void setUp() throws Exception {
		imageReducer = new ImageReducer();
	}
	
	@Test
	public void testReducer() {
		ImageFileAdator adaptor = new ImageFileAdator();
		Image image = imageReducer.reduce(adaptor.getImage("src/test/resources/photos/Velasquez-las-meninias.jpg"));
		Assert.assertNotNull(image);
		Assert.assertEquals(424, image.getWidth(null));
		Assert.assertEquals(475, image.getHeight(null));
	}

}
