package pt.jmfgameiro.generator.text;


import java.security.SecureRandom;
import java.util.List;
import java.util.Random;


public final class Text {
	
	/***** PUBLIC *****/
	public static final List< String > listWords() {
		Random random = new SecureRandom();
		int amount = random.nextInt( 3 ) + 3;
		return Words.randomValues( amount );
	}
	
	public static final String text() {
		return Paragraph.randomValue();
	}
	
	public static final String name() {
		return NameFirst.randomValue() + " " + NameLast.randomValue();
	}
	
	
}
