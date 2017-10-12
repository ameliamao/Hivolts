package hivolts;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Square {
	
	static boolean dead;
	
	public Player() {
			x = random2();
			y = random2();
			dead = false;
	}
	
	public void changePosition(int newX, int newY){
		x = x + newX;
		y = y + newY;
	}
	
	
	
	public boolean death(int deathX, int deathY){
		if (this.x == deathX && this.y == deathY){
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(toCoordinate(x),toCoordinate(y), squareSide, squareSide);
	}

}
