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

	
	//what ashu is currently using
	//theres like a million comments about this, but random should return random from 0-11
	public static int random(){
		Random random = new Random();
		return (((random.nextInt(10)+1) * 110) + 10);
	}
	
	//Could we make this the final random thing? 
	//You could then plug in this to a "to coordinate" (below)

    
	final int scalar = 50;
	final int squareSide = 40;

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
    
    public abstract void draw (Graphics g);
    
    public int toCoordinate(int index){
    	return index*scalar + 20;
    }
}
