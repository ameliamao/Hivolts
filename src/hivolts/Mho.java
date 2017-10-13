package hivolts;

import java.awt.*;
import java.util.ArrayList;

public class Mho extends Square{
	boolean newMho = true;
	
	public Mho(int x, int y) {
		this.x = x;
		this.y = y;
	}
	boolean dead;
	
	public Mho() {
		x = random2();
		y = random2();
		wantedX = x;
		wantedY = y;
		dead = false;
	}
	
	public boolean canMove(ArrayList<Fence> fences){

		for(Fence fence:fences){
			if (fence.getX() == this.x  && fence.getY() == this.y){
				return false;
			}
		}
		return true;

	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(toCoordinate(x), toCoordinate(y), squareSide, squareSide);
	}

}
