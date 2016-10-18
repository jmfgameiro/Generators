package pt.jmfgameiro.generator.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.junit.Test;

public class Graphics2DTest {
	
	/***** CONSTANTS *****/
	private static final int WIDTH = 1920, HEIGHT = 1080, PALETTE_SIZE = 5;
	private static final Color TONE = new Color( 100, 100, 245 );
	private static final int MIN_RADIUS = 20, MAX_RADIUS = 150;
	private static final int MIN_CIRCLES = 15, MAX_CIRCLES = 25;
	private static final int MAX_AMOUNT_CIRCLES = 3;
	private static final String IMAGE_PATH = "C:\\_PERSONAL\\_WORKSPACES\\_IMAGES\\outputGraphics";
	private static final String IMAGE_EXTENSION = "png";
	
	
	/***** PUBLIC *****/
	@Test
	public void testBrighter() {
		//create palette for the circles
		List< Color > palette = PaletteGenerator.createPalette( PALETTE_SIZE, TONE, true );
		
		//create buffered image object img
		BufferedImage img = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB );
		
		//create image
		Graphics g = img.getGraphics();
		g.setColor( palette.get( 0 ) );
		g.fillRect( 0, 0, WIDTH - 1, HEIGHT - 1 );
		
		//create all the circles
		int numCircles = randCircles();
		for( int i = 0; i < numCircles; i++ ) {
			//add circle to image
			g.drawImage(
					CircleGenerator.createCircle( MAX_AMOUNT_CIRCLES, randRadius(), palette ),
					randPosWidth(),
					randPosHeight(),
					null );
		}
		
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
		List< Color > palette = PaletteGenerator.createPalette( PALETTE_SIZE, TONE, false );
		
		//create buffered image object img
		BufferedImage img = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB );
		
		//create image
		Graphics g = img.getGraphics();
		g.setColor( palette.get( 0 ) );
		g.fillRect( 0, 0, WIDTH - 1, HEIGHT - 1 );
		
		//create all the circles
		int numCircles = randCircles();
		for( int i = 0; i < numCircles; i++ ) {
			//add circle to image
			g.drawImage(
					CircleGenerator.createCircle( MAX_AMOUNT_CIRCLES, randRadius(), palette ),
					randPosWidth(),
					randPosHeight(),
					null );
		}
		
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
	private static int randRadius() {
		Random rand = new Random();
		return rand.nextInt( MAX_RADIUS - MIN_RADIUS ) + MIN_RADIUS;
	}
	private static int randCircles() {
		Random rand = new Random();
		return rand.nextInt( MAX_CIRCLES - MIN_CIRCLES ) + MIN_CIRCLES;
	}
	private static int randPosWidth() {
		Random rand = new Random();
		return rand.nextInt( WIDTH );
	}
	private static int randPosHeight() {
		Random rand = new Random();
		return rand.nextInt( HEIGHT );
	}
	
	
}
