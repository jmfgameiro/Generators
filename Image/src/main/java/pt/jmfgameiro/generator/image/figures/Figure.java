package pt.jmfgameiro.generator.image.figures;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

public interface Figure {
	
	public static BufferedImage create( int radius, Color tone ) {
		throw new UnsupportedOperationException();
	}
	
	public static BufferedImage create( int amount, int maxRadius, List< Color > palette ) {
		throw new UnsupportedOperationException();
	}
	
}
