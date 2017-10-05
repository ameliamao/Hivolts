package hivolts;
import java.awt.*;

public class Fence extends Square{
	public final int width = 50;
	public final int height = 50;
	private final Color color = Color.ORANGE;
	
	public Fence(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Fence(){
		this.x = random2();
		this.y = random2();
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillRect(toCoordinate(x), toCoordinate(y), squareSide, squareSide);
	}

	
}