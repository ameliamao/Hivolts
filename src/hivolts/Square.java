package hivolts;
import java.util.Random;

public abstract class Square {
	//all are ints because coordinates are never going to be doubles
	
	//numerical place aka 0-11 by 0-11
	int[][] coordinates[][];
	
	//actual points on the screen
	int x, y;
	
	final int squareSide = 100;
	
	public static int random(){
		Random random = new Random();
		return (((random.nextInt(10)+1) * 110) + 10);
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}

}
