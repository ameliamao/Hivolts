package hivolts;

import java.awt.*;
import java.util.ArrayList;

public class Mho extends Square{
	public Mho(int x, int y) {
		this.x = x;
		this.y = y;
	}
	boolean dead;
	
	public Mho() {
		this.x = random2();
		this.y = random2();
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
