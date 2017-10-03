package hivolts;
import java.util.Random;

import javax.swing.ImageIcon;

import java.awt.*;

public abstract class Square {
	//all are ints because coordinates are never going to be doubles
	
	//numerical place aka 0-11 by 0-11
	int[][] coordinates[][];
	
	//actual points on the screen
	int x, y;
	protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;
	
	final int squareSide = 100;
	
	public static int random(){
		Random random = new Random();
		return (((random.nextInt(10)+1) * 110) + 10);
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

}
