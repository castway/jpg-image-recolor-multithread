package com.tomankiewicz.rafal.jpg.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class ColorWorkerTest {

	private ColorWorker colorWorker = new ColorWorker();
	private Color rgbCustom = new Color(138, 18, 200);
	
	@Test
	void getRedMethodShouldCorrectlyExtractTheRedValueFromRgb() {

		int rgb = Color.RED.getRGB();
		
		assertEquals(255, colorWorker.getRed(rgb));
		assertEquals(138, colorWorker.getRed(rgbCustom.getRGB()));
	}
	
	@Test
	void getGreenMethodShouldCorrectlyExtractTheGreenValueFromBlue() {
		
		int rgb = Color.GREEN.getRGB();
		
		assertEquals(255, colorWorker.getGreen(rgb));
		assertEquals(18, colorWorker.getGreen(rgbCustom.getRGB()));		
		
	}
	
	@Test
	void getBlueMethodShouldCorrectlyExtractTheBlueValueFromBlue() {
		
		int rgb = Color.BLUE.getRGB();
		
		assertEquals(255, colorWorker.getBlue(rgb));
		assertEquals(200, colorWorker.getBlue(rgbCustom.getRGB()));		
		
	}
	
	@Test
	void createRgbFromIntMethodShouldCorrectlyConvertIndividualColorValuesIntoRgb() {
		
		int rgbRed = Color.RED.getRGB();
		int rgbGreen = Color.GREEN.getRGB();
		int rgbBlue = Color.BLUE.getRGB();
		
		assertEquals(rgbRed, colorWorker.createRgbFromColors(255, 0, 0));
		assertEquals(rgbGreen, colorWorker.createRgbFromColors(0, 255, 0));
		assertEquals(rgbBlue, colorWorker.createRgbFromColors(0, 0, 255));
		assertEquals(rgbCustom.getRGB(), colorWorker.createRgbFromColors(138, 18, 200));
	}

}
