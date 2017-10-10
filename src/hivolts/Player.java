package hivolts;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Square {
	
	static boolean dead;
	
	public Player() {
			x = random2();
			y = random2(); // because my screen is too small, to be changed later
			dead = false;
	}
	
	public void changePosition(int newX, int newY){
		x = x + newX;
		y = y + newY;
		//then maybe some checkers or something
	}
	
	public boolean death(int deathX, int deathY){
		if (this.x == deathX && this.y == deathY){
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g){
		//for the time being:
		g.setColor(Color.GREEN);
		//multiplying by 10, because we currently need to sort out x,y vs the pixel coordinates
		g.fillRect(toCoordinate(x),toCoordinate(y), squareSide, squareSide);
	}

}
