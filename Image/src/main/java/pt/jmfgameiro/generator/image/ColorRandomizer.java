package pt.jmfgameiro.generator.image;

import java.awt.Color;
import java.util.Random;

final class ColorRandomizer {
	
	
	/***** PUBLIC *****/
	public static Color randomBlue( Color color ) {
		return new Color(
				color.getRed(),
				color.getGreen(),
				randomValue(),
				color.getAlpha() );
	}
	public static Color randomBlueBrighter( Color color ) {
		return new Color(
				color.getRed(),
				color.getGreen(),
				randomValueBrighter( color.getBlue(), -1 ),
				color.getAlpha() );
	}
	public static Color randomBlueDarker( Color color ) {
		return new Color(
				color.getRed(),
				color.getGreen(),
				randomValueDarker( color.getBlue(), -1 ),
				color.getAlpha() );
	}
	public static Color randomGreen( Color color ) {
		return new Color(
				color.getRed(),
				randomValue(),
				color.getBlue(),
				color.getAlpha() );
	}
	public static Color randomGreenBrighter( Color color ) {
		return new Color(
				color.getRed(),
				randomValueBrighter( color.getGreen(), -1 ),
				color.getBlue(),
				color.getAlpha() );
	}
	public static Color randomGreenDarker( Color color ) {
		return new Color(
				color.getRed(),
				randomValueDarker( color.getGreen(), -1 ),
				color.getBlue(),
				color.getAlpha() );
	}
	public static Color randomRed( Color color ) {
		return new Color(
				randomValue(),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha() );
	}
	public static Color randomRedBrighter( Color color ) {
		return new Color(
				randomValueBrighter( color.getRed(), -1 ),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha() );
	}
	public static Color randomRedDarker( Color color ) {
		return new Color(
				randomValueDarker( color.getRed(), -1 ),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha() );
	}
	
	public static Color random() {
		return new Color(
				randomValue(),
				randomValue(),
				randomValue() );
	}
	public static Color randomBrighter( Color color, int difference ) {
		return new Color(
				randomValueBrighter( color.getRed(), difference ),
				randomValueBrighter( color.getGreen(), difference ),
				randomValueBrighter( color.getBlue(), difference ),
				color.getAlpha() );
	}
	public static Color randomDarker( Color color, int difference ) {
		return new Color(
				randomValueDarker( color.getRed(), difference ),
				randomValueDarker( color.getGreen(), difference ),
				randomValueDarker( color.getBlue(), difference ),
				color.getAlpha() );
	}
	
	
	/***** PRIVATE *****/
	private static int randomValue() {
		Random rand = new Random();
		return rand.nextInt( 256 );
	}
	private static int randomValueDarker( int max, int difference ) {
		if( max <= 0 )
			return 0;
		//
		if( difference == 0 )
			return max;
		//
		Random rand = new Random();
		if( difference < 0 )
			return rand.nextInt( 256 );
		//
		return rand.nextInt( max );
	}
	private static int randomValueBrighter( int min, int difference ) {
		//
		if( difference == 0 )
			return min;
		//
		Random rand = new Random();
		if( difference < 0 )
			return rand.nextInt( 256 - min ) + min;
		//
		int value = rand.nextInt( difference ) + min;
		if( value > 255 )
			value = 255;
		return value;
	}
	
	
}
