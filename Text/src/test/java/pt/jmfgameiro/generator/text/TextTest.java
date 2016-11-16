package pt.jmfgameiro.generator.text;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TextTest {
	
	/***** TESTS *****/
	@Test
	public void singleWordsTest() {
		List< String > words = Text.listWords();
		assertNotNull( words );
		assertTrue( words.size() >= 3 );
		assertTrue( words.size() <= 5 );
	}
	@Test
	public void randomTextTest() {
		String text = Text.text();
		assertNotNull( text );
		assertNotEquals( "", text );
	}
	@Test
	public void randomNameTest() {
		String name = Text.name();
		assertNotNull( name );
		assertNotEquals( "", name );
		assertTrue( name.contains( " " ) );
	}
	
	
}
