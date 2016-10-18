package pt.jmfgameiro.generator.number;

import java.util.Random;

public final class IntegerRandomizer {
	
	
	/*****  *****/
	public static final int random() {
		Random rand = new Random();
		return rand.nextInt();
	}
	public static final int random( int max ) {
		Random rand = new Random();
		return rand.nextInt( max );
	}
	public static final int random( int min, int max ) {
		Random rand = new Random();
		return rand.nextInt( max - min ) + min;
	}
	
	
}
