package pt.jmfgameiro.generator.image;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class PaletteGenerator {
	
	
	/***** PUBLIC *****/
	/**
	 * Creates a palette of colors.
	 * @param amount Number of colors in the palette
	 * @return Colors in the palette
	 */
	public static List< Color > createPalette( int amount ) {
		List< Color > pallete = new ArrayList< Color >();
		for( int i = 0; i < amount; i++ )
			pallete.add( ColorRandomizer.random() );
		return pallete;
	}
	/**
	 * Creates a palette of colors.
	 * @param amount Number of colors in the palette
	 * @param tone Base color for the palette
	 * @param type Type of the palette to create 
	 * <code>null</code> if the palette surrounds the tone (NOT IMPLEMENTED)
	 * <code>true</code> if the palette is brighter than the tone
	 * <code>false</code> if the palette is darker than the tone
	 * @return Colors in the palette
	 */
	public static List< Color > createPalette( int amount, Color tone, Boolean type ) {
		if( type == null )
			return createPaletteArround( amount, tone );
		else if( type )
			return createPaletteBrighter( amount, tone );
		return createPaletteDarker( amount, tone );
	}
	
	
	/***** PRIVATE *****/
	/**
	 * Creates a palette of colors.
	 * @param amount Number of colors in the palette
	 * @param tone Base color for the palette
	 * @return Colors in the palette
	 */
	private static List< Color > createPaletteArround( int amount, Color tone ) {
		throw new UnsupportedOperationException(); //TODO
	}
	/**
	 * Creates a brighter palette of colors.
	 * @param amount Number of colors in the palette
	 * @param tone Base color for the palette
	 * @return Colors in the palette
	 */
	private static List< Color > createPaletteBrighter( int amount, Color tone ) {
		List< Color > pallete = new ArrayList< Color >();
		pallete.add( tone );
		
		int minRGB = tone.getRed();
		if( tone.getGreen() < minRGB )
			minRGB = tone.getGreen();
		if( tone.getBlue() < minRGB )
			minRGB = tone.getBlue();
		int difference = ( 256 - minRGB ) * 2 / amount;
		
		System.out.println( "DIFFERENCE: " + difference );
		
		for( int i = 1; i < amount; i++ ) {
			tone = ColorRandomizer.randomBrighter( tone, difference );
			pallete.add( tone );
		}
		return pallete;
	}
	/**
	 * Creates a darker palette of colors.
	 * @param amount Number of colors in the palette
	 * @param tone Base color for the palette
	 * @return Colors in the palette
	 */
	private static List< Color > createPaletteDarker( int amount, Color tone ) {
		List< Color > pallete = new ArrayList< Color >();
		pallete.add( tone );
		
		int minRGB = tone.getRed();
		if( tone.getGreen() < minRGB )
			minRGB = tone.getGreen();
		if( tone.getBlue() < minRGB )
			minRGB = tone.getBlue();
		int difference = minRGB / amount;
		
		for( int i = 1; i < amount; i++ ) {
			tone = ColorRandomizer.randomDarker( tone, difference );
			pallete.add( tone );
		}
		return pallete;
	}
	
	
}
