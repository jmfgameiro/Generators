package pt.jmfgameiro.generator.image.resources;

import java.awt.Color;

import pt.jmfgameiro.generator.number.IntegerRandomizer;

public final class ColorRandomizer {
	
	/***** CONSTANTS *****/
	public static final int MAX_COLOR_VALUE = 256, MIN_COLOR_VALUE = 0, STANDARD_DIFFERENCE = 0;
	
	
	/***** PUBLIC *****/
	public static final Color randomBlue( Color color ) {
		return new Color(
				color.getRed(),
				color.getGreen(),
				IntegerRandomizer.random( MAX_COLOR_VALUE ),
				color.getAlpha() );
	}
	public static final Color randomBlueBrighter( Color color ) {
		return new Color(
				color.getRed(),
				color.getGreen(),
				randomValueBrighter( color.getBlue(), STANDARD_DIFFERENCE ),
				color.getAlpha() );
	}
	public static final Color randomBlueDarker( Color color ) {
		return new Color(
				color.getRed(),
				color.getGreen(),
				randomValueDarker( color.getBlue(), STANDARD_DIFFERENCE ),
				color.getAlpha() );
	}
	public static final Color randomGreen( Color color ) {
		return new Color(
				color.getRed(),
				IntegerRandomizer.random( MAX_COLOR_VALUE ),
				color.getBlue(),
				color.getAlpha() );
	}
	public static final Color randomGreenBrighter( Color color ) {
		return new Color(
				color.getRed(),
				randomValueBrighter( color.getGreen(), STANDARD_DIFFERENCE ),
				color.getBlue(),
				color.getAlpha() );
	}
	public static final Color randomGreenDarker( Color color ) {
		return new Color(
				color.getRed(),
				randomValueDarker( color.getGreen(), STANDARD_DIFFERENCE ),
				color.getBlue(),
				color.getAlpha() );
	}
	public static final Color randomRed( Color color ) {
		return new Color(
				IntegerRandomizer.random( MAX_COLOR_VALUE ),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha() );
	}
	public static final Color randomRedBrighter( Color color ) {
		return new Color(
				randomValueBrighter( color.getRed(), STANDARD_DIFFERENCE ),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha() );
	}
	public static final Color randomRedDarker( Color color ) {
		return new Color(
				randomValueDarker( color.getRed(), STANDARD_DIFFERENCE ),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha() );
	}
	
	public static final Color random() {
		return new Color(
				IntegerRandomizer.random( MAX_COLOR_VALUE ),
				IntegerRandomizer.random( MAX_COLOR_VALUE ),
				IntegerRandomizer.random( MAX_COLOR_VALUE ) );
	}
	public static final Color randomBrighter( Color color, int difference ) {
		return new Color(
				randomValueBrighter( color.getRed(), difference ),
				randomValueBrighter( color.getGreen(), difference ),
				randomValueBrighter( color.getBlue(), difference ),
				color.getAlpha() );
	}
	public static final Color randomDarker( Color color, int difference ) {
		return new Color(
				randomValueDarker( color.getRed(), difference ),
				randomValueDarker( color.getGreen(), difference ),
				randomValueDarker( color.getBlue(), difference ),
				color.getAlpha() );
	}
	
	
	/***** PRIVATE *****/
	private static final int randomValueDarker( int current, int difference ) {
		//
		if( difference <= STANDARD_DIFFERENCE )
			difference = current;
		//
		int value = IntegerRandomizer.random( current - difference, current );
		//System.out.println( "[ " + current + ", " + difference + ", " + value + " ]" );
		if( value <= MIN_COLOR_VALUE )
			value = MIN_COLOR_VALUE;
		return value;
	}
	private static final int randomValueBrighter( int current, int difference ) {
		//
		if( difference <= STANDARD_DIFFERENCE )
			difference = MAX_COLOR_VALUE - current;
		//
		int value = IntegerRandomizer.random( current, current + difference);
		//System.out.println( "[ " + current + ", " + difference + ", " + value + " ]" );
		if( value >= MAX_COLOR_VALUE )
			value = MAX_COLOR_VALUE - 1;
		return value;
	}
	
	
}
