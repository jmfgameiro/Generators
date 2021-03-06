package pt.jmfgameiro.generator.image.figures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.List;

import pt.jmfgameiro.generator.number.IntegerRandomizer;

public final class CircleRandomizer implements Figure {
	
	
	/***** PUBLIC *****/
	/**
	 * Creates an image with a single circle
	 * @param radius Maximum radius possible of the circle
	 * @param tone Color of the circle
	 * @return Image with a circle
	 */
	public static final BufferedImage create( int radius, Color tone ) {
		//calculate circle diameter
		int diameter = radius * 2;
		
		//create buffered image object for circle
		BufferedImage circle = new BufferedImage( diameter, diameter, BufferedImage.TYPE_INT_ARGB );
		
		//create circle
		Graphics2D c = circle.createGraphics();
		c.setColor( tone );
		c.fillOval( 0, 0, diameter, diameter );
		c.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		
		return circle;
	}
	/**
	 * Creates an image with multiple inline circles
	 * @param amount Number of circles to create
	 * @param maxRadius Maximum radius possible of the circle
	 * @param palette Palette of colors in the circle
	 * @return Image with a circle
	 */
	public static final BufferedImage create( int amount, int maxRadius, List< Color > palette ) {
		//validate the amount of
		if( amount == 1 )
			return create( maxRadius, palette.get( IntegerRandomizer.random( palette.size() ) ) );
			
		//calculate circle diameter
		int diameter = maxRadius * 2;
		
		//calculate the difference between circle radius
		int radiusDifference = maxRadius / amount;
		
		//create buffered image object for circle
		BufferedImage circle = new BufferedImage( diameter, diameter, BufferedImage.TYPE_INT_ARGB );
		
		//create graphics
		Graphics2D c = circle.createGraphics();
		
		//iterate the multiple circles from bigger to smaller
		int lastColor = 0;
		for( int i = 0; i < amount; i++ ) {
			//
			int index = 0;
			while( index == lastColor )
				index = IntegerRandomizer.random( palette.size() );
			//
			int position = i * radiusDifference;
			BufferedImage newCircle = create( maxRadius - position, palette.get( index ) );
			c.drawImage( newCircle, position, position, null );
			//
			lastColor = index;
		}
		
		//
		return circle;
	}
	
	
}
