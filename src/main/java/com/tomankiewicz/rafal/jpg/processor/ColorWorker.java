package com.tomankiewicz.rafal.jpg.processor;

/**
 * @author Rafał
 * 
 * ColorWorker class is a color processing class. The color retrieval process is based on 
 * basic binary arithmetic. The ARGB colors represented as an integer are coded as follows:
 * 
 * 00000000 00000000 00000000 11111111
 * ^ Alpha  ^Red     ^Green   ^Blue
 * 
 * This allows extracting the individual color values from RBG colors represented as integers.
 * An example explaining the operations allowing to work with colors represented as integers
 * is the method retrieving the red component from an RGB value - getRed(int rgb).
 * This method shifts the red component of the RGB value to the right and performs a 
 * logical AND on the result as the example that follows:
 * 
 * Exemplary initial RGB value:
 * 11111111 11111111 00000000 00000000
 * ^ Alpha  ^Red
 * 
 * Result of the rgb >> 16 operation:
 * 00000000 00000000 11111111 11111111
 * 
 * Logical AND operation used in the return statement:
 * 00000000 00000000 11111111 11111111
 * 00000000 00000000 00000000 11111111
 * 
 * The result of the logical AND operation:
 * 00000000 00000000 00000000 11111111
 *
 */
class ColorWorker {

	/**
	 * Method retrieving the red component from an RGB value represented as an integer.
	 * @param rgb the RGB value represented as an integer
	 * @return the red component of the RGB value
	 */
	int getRed(int rgb) {
		return (rgb >> 16) & 0x000000FF;
	}

	/**
	 * Method retrieving the green component from an RGB value represented as an integer.
	 * @param rgb the RGB value represented as an integer
	 * @return the green component of the RGB value
	 */
	int getGreen(int rgb) {
		return (rgb >> 8) & 0x000000FF;
	}
	
	/**
	 * Method retrieving the blue component from an RGB value represented as an integer.
	 * @param rgb the RGB value represented as an integer
	 * @return the blue component of the RGB value
	 */
	int getBlue(int rgb) {
		return rgb & 0x000000FF;
	}
	
	/**
	 * Method converting the individual R, G and B values into an integer representation.
	 * The alpha value is set to maximum (no opacity) by default.
	 * @param red integer representation of the red color value
	 * @param green integer representation of the green color value
	 * @param blue integer representation of the blue color value
	 * @return an int representation of an RGB created from individual colors. The alpha value
	 * 			is set to no opacity
	 */
	int createRgbFromColors(int red, int green, int blue) {
		
		int rgb = 0;
		// setting the alpha value to 255 (no opacity):
		rgb |= 0xFF000000;
		// setting the color values to appropriate bits:
		rgb |= red << 16;
		rgb |= green << 8;
		rgb |= blue;
		
		return rgb;
	}
	
}
