package hivolts;
import java.util.Random;

import javax.swing.ImageIcon;

import java.awt.*;

public abstract class Square {
	int x, y;
	protected int width;
    protected int height;
    
    protected boolean vis;
    protected Image image;

	final int scalar = 50;
	final int squareSide = 40;

	public static int random2(){
		Random random = new Random();
		return random.nextInt(9)+1;
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
    
    public abstract void draw (Graphics g);
    
    public int toCoordinate(int index){
    	return index*scalar + 20;
    }
}
