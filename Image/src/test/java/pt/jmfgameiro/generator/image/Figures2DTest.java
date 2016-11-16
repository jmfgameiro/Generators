package pt.jmfgameiro.generator.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Test;

import pt.jmfgameiro.generator.image.figures.CircleRandomizer;
import pt.jmfgameiro.generator.image.resources.PaletteRandomizer;
import pt.jmfgameiro.generator.number.IntegerRandomizer;

public class Figures2DTest {
	
	/***** CONSTANTS *****/
	private static final int WIDTH = 1920, HEIGHT = 1080, PALETTE_SIZE = 5;
	private static final Color TONE = new Color( 161, 178, 31 );
	private static final int MIN_RADIUS = 20, MAX_RADIUS = 150;
	private static final int MIN_CIRCLES = 15, MAX_CIRCLES = 25;
	private static final int MIN_INNER_CIRCLES = 1, MAX_INNER_CIRCLES = 5;
	private static final String IMAGE_PATH = System.getProperty("user.dir") + "\\outputGraphics";
	private static final String IMAGE_EXTENSION = "png";
	
	
	/***** PUBLIC *****/
	@Test
	public void testBrighter() {
		//create palette for the circles
		List< Color > palette = PaletteRandomizer.createPalette( PALETTE_SIZE, TONE, true );
		//create image
		BufferedImage img = test( palette );
		//write image
		File f = null;
		try {
			f = new File( IMAGE_PATH + "Bright."  + IMAGE_EXTENSION );
			ImageIO.write( img, IMAGE_EXTENSION, f );
		}
		catch( IOException e ) {
			e.printStackTrace();
		}
	}
	@Test
	public void testDarker() {
		//create palette for the circles
		List< Color > palette = PaletteRandomizer.createPalette( PALETTE_SIZE, TONE, false );
		//create image
		BufferedImage img = test( palette );
		//write image
		File f = null;
		try {
			f = new File( IMAGE_PATH + "Dark."  + IMAGE_EXTENSION );
			ImageIO.write( img, IMAGE_EXTENSION, f );
		}
		catch( IOException e ) {
			e.printStackTrace();
		}
	}
	
	
	/***** PRIVATE *****/
	private static BufferedImage test( List< Color > palette ) {
		//create buffered image object img
		BufferedImage img = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB );
		
		//create image
		Graphics g = img.getGraphics();
		g.setColor( palette.get( 0 ) );
		g.fillRect( 0, 0, WIDTH - 1, HEIGHT - 1 );
		
		//create all the circles
		int numCircles = IntegerRandomizer.random( MIN_CIRCLES, MAX_CIRCLES );
		for( int i = 0; i < numCircles; i++ ) {
			//
			int radius = IntegerRandomizer.random( MIN_RADIUS, MAX_RADIUS );
			int circles = IntegerRandomizer.random( MIN_INNER_CIRCLES, MAX_INNER_CIRCLES );
			while( radius > MAX_RADIUS / 3 && circles == MIN_INNER_CIRCLES ) {
				radius = IntegerRandomizer.random( MIN_RADIUS, MAX_RADIUS );
				circles = IntegerRandomizer.random( MIN_INNER_CIRCLES, MAX_INNER_CIRCLES );
			}
			
			//add circle to image
			g.drawImage(
					CircleRandomizer.create( circles, radius, palette ),
					IntegerRandomizer.random( WIDTH ),
					IntegerRandomizer.random( HEIGHT ),
					null );
		}
		
		//return created image
		return img;
	}
	
	
}
