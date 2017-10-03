package hivolts;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Square {
	
	public Player() {
		random();
	}
	
	public void draw(Graphics g){
		//for the time being:
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, squareSide, squareSide);
	}

}
