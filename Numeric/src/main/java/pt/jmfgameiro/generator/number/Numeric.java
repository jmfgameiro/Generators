package pt.jmfgameiro.generator.number;

public final class Numeric {
	
	/***** PUBLIC *****/
	public static final double randomDouble( double min, double max ) {
	    return min + ( double )( Math.random() * ( ( max - min ) + 1 ) );
	}
	
	
	
}
