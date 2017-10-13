package hivolts;

import java.awt.*;
import java.util.ArrayList;

/**
 * The Mho class, creates one Mho object and generates a random position, if needed.
 * @author ameliamao
 */
public class Mho extends Square{
	boolean newMho = true;
	
	//constructors
	public Mho(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Mho() {
		x = random();
		y = random();
		wantedX = x;
		wantedY = y;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(toCoordinate(x), toCoordinate(y), squareSide, squareSide);
	}
}
