package hivolts;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Square {
	
	public Player() {
			x = random2();
			y = 2; // because my screen is too small, to be changed later
	}
	
	public void changePosition(int newX, int newY){
		x = x + newX;
		y = y + newY;
		//then maybe some checkers or something
	}
	
	public void draw(Graphics g){
		//for the time being:
		g.setColor(Color.GREEN);
		//multiplying by 10, because we currently need to sort out x,y vs the pixel coordinates
		g.fillRect(10*x, 10*y, squareSide, squareSide);
	}

}
