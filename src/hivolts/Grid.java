package hivolts;

import java.awt.Graphics;

public class Grid {
	public static Player player; 
	public Square[][] field = new Square[12][12];
	
	public Grid(){
		createGrid();
	}
	
	public void createBorder(){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(x==0||x==11||y==0||y==11){
					field[x][y] = new Fence(x,y);
				}
			}
		}
	}
	
	public void createRandomFences(){
		for (int i = 0; i < 12; i++) {
			while(true){
				int x = Square.random2();
				int y = Square.random2();
				if(field[x][y]==null){
					field[x][y] = new Fence(x,y);
					//Fences.add(new Fence(x,y));
					System.out.println("randoms");
					break;
				}
			}
		}
	}
	
	public void createMhos(){
		for (int i = 0; i < 6; i++) {
			while(true){
				int x = Square.random2();
				int y = Square.random2();
				if(field[x][y]==null){
					field[x][y] = new Mho(x,y);
					//Mhos.add(new Mho(x,y));
					break;
				}
			}
		} 
	}
	
	public void createGrid(){
		createBorder();
		player = new Player();
		createRandomFences();
		createMhos();
	}
	
	public void drawField(Graphics g){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if (field[x][y] != null){
					field[x][y].draw(g);
				}
			}
		}
	}
	
	public boolean mhosCanMoveOnEmptySpaces(int x, int y) {
		boolean canMove = false;
		if (field[x][y]==null) {
			canMove = true;
		} return canMove;
	}
	
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
	public void changeToRandomPlayerPos() {
		int[] pos = new int[2];
		pos[0] = Square.random2();
		pos[1] = Square.random2();
		while(!isPlayerOnFence(pos)) {
			pos[0] = Square.random2();
			pos[1] = Square.random2();
		}
		field[player.getX()][player.getY()] = null;
//		for (int x = 0; x < 12; x++) {
//			for (int y = 0; y < 12; y++) {
//				if(field[x][y] == player){
//					System.out.println("if");
//					field[x][y] = null;
//					player.x = pos[0];
//					player.y = pos[1];
//				//	field[pos[0]][pos[1]] = player;
//				}
//			}
		player.x = pos[0];
		player.y = pos[1];
		//}
		
	}
	public boolean isPlayerOnFence(int[] position) {
		if (field[position[0]][position[1]] instanceof Fence) {
			return false;
		}
		return true;
	}
	
	public void moveMhos(){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(field[x][y] instanceof Mho){
					field[x][y] = null;
					if(x == player.getX() && y == player.getY()){
						HiVolts.gameStatus = false;
					}
					else if (x == player.getX()) {
						if (y < player.y) {
							field[x][y+1] = new Mho(x, y+1);
							//y += 1;
						} else {
							field[x][y-1] = new Mho(x, y-1);
							//y -= 1;
						}
					}
					else if (y == player.getY()) {
						if (x < player.x) {
							//x += 1;
							field[x+1][y] = new Mho(x+1,y);
						} else {
							//x -= 1;
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
						
						if (mhosCanMoveOnEmptySpaces(diagPos[0], diagPos[1])) {
							field[diagPos[0]][diagPos[1]] = new Mho(diagPos[0], diagPos[1]);
							
						} else if (mhosCanMoveOnEmptySpaces(carPos[0], carPos[1])) {	
							field[carPos[0]][carPos[1]] = new Mho(carPos[0], carPos[1]);
						} else if (mhosCanMoveOnFences(diagPos[0], diagPos[1])) {
							// Move diagonally if landing on a fence
							//this.x = diagPos[0];
							//this.y = diagPos[1];
							//this.dead = true;
							
							//HiVolts.gameStatus = false;
							//Nothing because its dead???
						} else if (mhosCanMoveOnFences(carPos[0], carPos[1])) {
							// Move cardinalDirectionally if landing on a fence
							//this.x = carPos[0];
							//this.y = carPos[1];	
							//this.dead = true;
							
							//HiVolts.gameStatus = false;
							//dead so nothing??
							//ameria plz look this over,
							
							//i hope it works
						}
					}
				}
			}
		}
	}
	
	public void draw(Graphics g){
		drawField(g);
		player.draw(g);
	}
	
}
