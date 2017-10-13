package hivolts;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The player class creates a player object 
 * @author sophiaVera
 */
public class Player extends Square {
	
	boolean dead;
	int wantedX;
	int wantedY;
	
	//constructor
	public Player() {
			x = random();
			y = random();
			wantedX = x;
			wantedY = y;
			dead = false;
	}
	
	/**
	 * changes the position of the x and y positions of player based on 2 params
	 * and checks to see if the new position is within the bounds of the board
	 * @param newX: added to the original x-coordinate
	 * @param newY: added to the original y-coordinate
	 */
	public void changePosition(int newX, int newY){
		wantedX += newX;
		wantedY += newY;
		
		//checks to see if player is out of bounds
		if(wantedX < 0 || wantedY < 0 || wantedX > 11 || wantedY > 11){
			HiVolts.gameStatus = false;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(toCoordinate(x),toCoordinate(y), squareSide, squareSide);
	}

}
