package hivolts;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Square {
	
	boolean dead;
	int wantedX;
	int wantedY;
	
	public Player() {
			x = random2();
			y = random2();
			wantedX = x;
			wantedY = y;
			dead = false;
	}
	
	public void changePosition(int newX, int newY){
		wantedX += newX;
		wantedY += wantedY + newY;
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
