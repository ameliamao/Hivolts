package hivolts;
import java.awt.*;

public class Fence {
	public final int width = 100;
	public final int height = 100;
	private double x;
	private double y;
	private final Color color = Color.ORANGE;
	
	public Fence(double x, double y){
		this.x = x;
		this.y = height;
		
	}
	public void draw (Graphics g){
		g.setColor(this.color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}
	
}