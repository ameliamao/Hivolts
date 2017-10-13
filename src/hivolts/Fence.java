package hivolts;
import java.awt.*;
/**
 * The Fence Class creates and draws one fence object
 * @author ashuBhown
 */
public class Fence extends Square{
	private final Color color = Color.ORANGE;
	
	//constructor
	public Fence(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//random fence coordinates x and y
	public Fence(){
		this.x = random2();
		this.y = random2();
	}
	
	/**
	 * draws the fence using coordinates
	 */
	@Override
	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillRect(toCoordinate(x), toCoordinate(y), squareSide, squareSide);
	}

	
}