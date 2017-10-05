package hivolts;
import java.awt.*;

public class Fence extends Square{
	public final int width = 50;
	public final int height = 50;
	private final Color color = Color.ORANGE;
	
	//ashuuuuu
	// x and y are the player coordinates like 0-11
	//please do the 'math' for calculating the point in here
	//thaaaaankks
	public Fence(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	//btw I changed this to one variable 
	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillRect(x, y, squareSide, squareSide);
	}
	
}