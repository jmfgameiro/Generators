package pt.jmfgameiro.generator.number;

import java.util.Random;

public final class DoubleRandomizer {
	
	/***** PUBLIC *****/
	public static final double random() {
		Random rand = new Random();
	    return Double.MAX_VALUE * rand.nextDouble();
	}
	public static final double random( double max ) {
		Random rand = new Random();
		return max * rand.nextDouble();
	}
	public static final double random( double min, double max ) {
		Random rand = new Random();
	    return min + ( max - min ) * rand.nextDouble();
	}
	
	
	
}
