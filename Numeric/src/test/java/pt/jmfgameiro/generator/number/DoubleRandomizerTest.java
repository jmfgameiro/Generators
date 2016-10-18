package pt.jmfgameiro.generator.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleRandomizerTest {
	
	/***** CONSTANTS *****/
	private static final double MIN = 10.0, MAX =  15.0;
	
	
	/***** TEST *****/
	@Test
	public void randomDouble() {
		double rand = DoubleRandomizer.random( MIN, MAX );
		assertTrue( rand >= MIN );
		assertTrue( rand <= MAX );
	}
	
	
}
