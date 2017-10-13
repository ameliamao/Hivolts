package hivolts;

import java.awt.Graphics;

/**
 * The Grid class contains all the calculation methods for hivolts
 * @author ameliamao, sophiaVera, ashuBhown
 */
public class Grid {
	public static Player player; 
	public Square[][] field = new Square[12][12];
	
	public Grid(){
		player = new Player();
		field[player.x][player.y] = player;
		createGrid();
	}
	
	/**
	 * creates the borders of the fences
	 */
	public void createBorder(){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(x==0||x==11||y==0||y==11){
					field[x][y] = new Fence(x,y);
				}
			}
		}
	}
	
	/**
	 * creates 20 random fences inside the game board
	 */
	public void createRandomFences(){
		for (int i = 0; i < 20; i++) {
			while(true){
				int x = Square.random();
				int y = Square.random();
				if(field[x][y]==null){
					field[x][y] = new Fence(x,y);
					break;
				}
			}
		}
	}
	
	/**
	 * generates 12 randomly placed mhos on the board
	 */
	public void createMhos(){
		for (int i = 0; i < 12; i++) {
			while(true){
				int x = Square.random();
				int y = Square.random();
				if(field[x][y]==null){
					field[x][y] = new Mho(x,y);
					break;
				}
			}
		} 
	}
	
	/**
	 * places all generated objects together
	 */
	public void createGrid(){
		createBorder();
		createRandomFences();
		createMhos();
	}
	
	/**
	 *draws the complete board
	 */
	public void drawField(Graphics g){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if (field[x][y] != null){
					field[x][y].draw(g);
				}
			}
		}
	}
	
	/**
	 * checker for if it is possible for the mho to move on an empty space
	 * @param x: the x-coordinate of the mho
	 * @param y: the y-coordinate of the mho
	 * @return: a boolean to see if the mho can move 
	 */
	public boolean mhosCanMoveOnEmptySpaces(int x, int y) {
		boolean canMove = false;
		if (field[x][y]==null) {
			canMove = true;
		} return canMove;
	}
	
	/**
	 * checker for if it is possible for the mho to move on a fence
	 * @param x: the x-coordinate of the mho
	 * @param y: the y-coordinate of the mho
	 * @return: a boolean to see if the mho can move 
	 */
	public boolean mhosCanMoveOnFences(int x, int y) {
		boolean canMove = false;
		for (int cols = 0; cols < 12; cols++) {
			for (int rows = 0; rows < field.length; rows++) {
				if(field[cols][rows] instanceof Mho){
					if (x == cols && y == rows) {
						canMove = true;
					} 
				}
			} 
		}
		return canMove;
	}
	
	/**
	 * changes the player's position to another randomly generated spot
	 */
	public void changeToRandomPlayerPos() {
		int[] pos = new int[2];
		pos[0] = Square.random();
		pos[1] = Square.random();
		field[player.getX()][player.getY()] = null;

		player.wantedX = pos[0];
		player.wantedY = pos[1];
	}
	
	/**
	 * checks to see if the player is on a fence
	 * @param position: an int array for the x and y of the player
	 * @return: a boolean for whether the player is on a fence or not
	 */
	public boolean isPlayerOnFence(int[] position) {
		if (field[position[0]][position[1]] instanceof Fence) {
			return true;
		}
		return false;
	}
	
	/**
	 * checks to see if the player is on a mho
	 * @param position: an int array for the x and y of the player
	 * @return: a boolean for whether the player is on a mho or not
	 */
	public boolean isPlayerOnMho(int[] position) {
		if (field[position[0]][position[1]] instanceof Mho) {
			return true;
		}
		return false;
	}
	
	/**
	 * checks to see if a mho is on the player
	 * @param x: the x-coordinate of a mho
	 * @param y: the y-coordinate of a mho
	 * @return: a boolean for whether the player is on a mho or not
	 */
	public void isMhoOnPlayer(int x, int y){
		if(x == player.x && y == player.y){
			HiVolts.gameStatus = false;
		}
	}
	
	/**
	 * moves the mhos according to the specifications provided
	 */
	public void moveMhos(){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(field[x][y] instanceof Mho){
					if(!field[x][y].newMho){
						field[x][y] = null;
					}
					//if mho is directly on the player
					if(x == player.getX() && y == player.getY()){
						player.dead = true;
						HiVolts.gameStatus = false;
						return;
					}
					//if mho is directly horizontal to the player
					else if (x == player.getX()) {
						if (y < player.y) {
							isMhoOnPlayer(x, y+1);
							field[x][y+1] = new Mho(x, y+1);
						} else {
							isMhoOnPlayer(x, y-1);
							field[x][y-1] = new Mho(x, y-1);
						}
					}
					//if mho is directly vertical to the player
					else if (y == player.getY()) {
						if (x < player.x) {
							isMhoOnPlayer(x+1, y);
							field[x+1][y] = new Mho(x+1,y);
						} else {
							isMhoOnPlayer(x-1, y);
							field[x-1][y] = new Mho(x-1, y);
						}
					}
					else {
						int xDist = player.getX() - x; // Horizontal distance from player to mho
						int yDist = player.getY() - y; // Vertical distance from player to mho
						
						// Optimal diagonal direction to move in (both values are either 1 or -1)
						int xDirection = xDist / Math.abs(xDist), yDirection = yDist / Math.abs(yDist);
						// Coordinates of new diagonal position
						int[] diagPos = {x + xDirection, y + yDirection};
						
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
						int[] carPos = {x + cardinalDirection[0], y + cardinalDirection[1]};
						
						//checks if the mhos could move on an empty space going diagonally
						if (mhosCanMoveOnEmptySpaces(diagPos[0], diagPos[1])) {
							isMhoOnPlayer(diagPos[0], diagPos[1]);
							field[diagPos[0]][diagPos[1]] = new Mho(diagPos[0], diagPos[1]);
						}
						//checks if the mhos could move on an empty space going horizontally/vertically
						else if (mhosCanMoveOnEmptySpaces(carPos[0], carPos[1])) {	
							isMhoOnPlayer(carPos[0], carPos[1]);
							field[carPos[0]][carPos[1]] = new Mho(carPos[0], carPos[1]);
						} 
						//if the mho can not move onto an empty space and it can not move onto a fence, 
						//then it stays in the same position
						else if (!mhosCanMoveOnFences(diagPos[0], diagPos[1])) {
							field[x][y] = new Mho(x,y);
						} else if (!mhosCanMoveOnFences(carPos[0], carPos[1])) {
							field[x][y] = new Mho(x,y);
						}
					}
				}
			}
		}
	}
	
	/**
	 * clears the whole board
	 */
	public void clear(){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				field[x][y] = null;
			}
		}
	}
	
	/**
	 * updates the mhos on the board
	 */
	public void updateMhos(){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(field[x][y] instanceof Mho)
					field[x][y].newMho = false;
			}
		}
	}
	
	public void draw(Graphics g){
		drawField(g);
		player.draw(g);
	}
	
	/**
	 * checks to see if the player has won
	 * @return
	 */
	public boolean checkWin(){
		int counter = 0;
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(field[x][y] instanceof Mho)
					counter += 1;
			}
		}
		if(counter == 0){
			return true;
		}
		else{
			return false;
		}
	}
}
