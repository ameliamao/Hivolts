package hivolts;
import java.util.Random;

import javax.swing.ImageIcon;

import java.awt.*;

public abstract class Square {
	//all are ints because coordinates are never going to be doubles
	
	//numerical place aka 0-11 by 0-11
	//int[][] coordinates[][];  <-- decided not to use this...?
	
	
	//actual points on the screen
	int x, y;
	protected int width;
    protected int height;
    
    protected boolean vis;
    protected Image image;

	final int squareSide = 100;
	
	//what ashu is currently using
	//theres like a million comments about this, but random should return random from 0-11
	public static int random(){
		Random random = new Random();
		return (((random.nextInt(10)+1) * 110) + 10);
	}
	
	//Could we make this the final random-ifier? 
	//You could then plug in this to a "tocoordinate" (below)
	public static int random2(){
		Random random = new Random();
		return random.nextInt(10)+1;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
    
    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    //Someone make a "tocoordinate" method that turns the x,y (0-11) to the actual coordinate (probably in the hundreds)??????
}
