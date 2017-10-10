package hivolts;

import java.awt.*;
import java.util.ArrayList;

public class Mho extends Square{
	public Mho(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Mho() {
		this.x = random2();
		this.y = random2();
	}
	
	public boolean canMove(ArrayList<Fence> fences){

		for(Fence fence:fences){
			if (fence.getX() == this.x  && fence.getY() == this.y){
				return false;
			}
		}
		return true;

	}

	
	public void move(Player player, HiVolts gameBoard) {
		if(this.x == player.getX() && this.y == player.getY()) {
			//player dies
		}
		
		else if (this.x == player.getX()) {
			if (this.y < player.y) {
				this.y += 1;
			} else {
				this.y -= 1;
			}
		}
		
		else if (this.y == player.getY()) {
			if (this.x < player.x) {
				this.x += 1;
			} else {
				this.x -= 1;
			}
		}
		
		else {
			int xDist = player.getX() - this.x; // Horizontal distance from player to mho
			int yDist = player.getY() - this.y; // Vertical distance from player to mho
			
			// Optimal diagonal direction to move in (both values are either 1 or -1)
			int xDirection = xDist / Math.abs(xDist), yDirection = yDist / Math.abs(yDist);
			// Coordinates of new diagonal position
			int[] diagPos = {this.x + xDirection, this.y + yDirection};
			
			/* If diagonal movement is impossible, move horizontally if
			 * horizontal distance is greater than or equal to vertical distance,
			 * and vertically otherwise.
			 */
			int[] cardinalDirection = new int[2];
			if (Math.abs(xDist) >= Math.abs(yDist)) {
				cardinalDirection[0] = xDirection;
			} else {
				cardinalDirection[1] = yDirection;
			}
			
			// Coordinates of new cardinalDirection position
			int[] carPos = {this.x + cardinalDirection[0], this.y + cardinalDirection[1]};
			
			if (gameBoard.mhosCanMoveOnEmptySpaces(diagPos[0], diagPos[1])) {
				// Move diagonally if landing on an empty space
				this.x = diagPos[0];
				this.y = diagPos[1];
			} else if (gameBoard.mhosCanMoveOnEmptySpaces(carPos[0], carPos[1])) {
				// Move cardinalDirectionly if landing on an empty space
				this.x = carPos[0];
				this.y = carPos[1];				
			} else if (gameBoard.mhosCanMoveOnFences(diagPos[0], diagPos[1])) {
				// Move diagonally if landing on a fence
				this.x = diagPos[0];
				this.y = diagPos[1];
			} else if (gameBoard.mhosCanMoveOnFences(carPos[0], carPos[1])) {
				// Move cardinalDirectionly if landing on a fence
				this.x = carPos[0];
				this.y = carPos[1];	
			}
		}
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(toCoordinate(x), toCoordinate(y), squareSide, squareSide);
	}

}
