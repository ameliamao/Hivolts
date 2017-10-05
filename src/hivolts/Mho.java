package hivolts;

import java.awt.*;

public class Mho extends Square{
	public Mho(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private void Mho() {
		loadImage("src/res/player.png");
        getImageDimensions();
	}
	
	public void draw(Graphics g) {
		
	}
}
