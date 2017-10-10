package hivolts;

import java.awt.*;
import java.util.ArrayList;

public class Mho extends Square{
	public Mho(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Mho() {
		this.x = random2();
		this.y = random2();
	}
	
	public boolean canMove(ArrayList<Fence> fences){

		for(Fence fence:fences){
			if (fence.getX() == this.x  && fence.getY() == this.y){
				return false;
			}
		}
		return true;

	}

	
	public void move(Player player, HiVolts gameBoard) {
		if (this.x == player.getX()) {
			if (this.y < player.y) {
				this.y += 1;
			} else {
				this.y -= 1;
			}
			
		}
		else if (this.y == player.getY()) {
			if (this.x < player.x) {
				this.x += 1;
			} else {
				this.x -= 1;
			}
		}
		else {
			
		}
		
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(toCoordinate(x), toCoordinate(y), squareSide, squareSide);
	}

}
