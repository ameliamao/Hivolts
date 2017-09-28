package hivolts;
import java.util.Random;

public abstract class Square {
	int x;
	int y;
	int xCoordinate;
	int yCoordinate;
	
	
	
	public void random(){
		Random random = new Random();
		x = random.nextInt(12);
		y = random.nextInt(12);
	}

}
