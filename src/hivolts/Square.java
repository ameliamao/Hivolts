package hivolts;

import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 * The Square class is the parent class for Mho, Player, and Fence
 * @author sophiaVera, ameliamao, ashuBhown
 */
public abstract class Square {
	int x, y, wantedX, wantedY;
	protected int width;
    protected int height;
    
    protected boolean vis;
    protected Image image;

	final int scalar = 50;
	final int squareSide = 40;
	
	boolean newMho = true; // this is only used inside of mho
	
	/**
	 * this function generates a random number between 0 and 10
	 * @return a random integer
	 */
	public static int random(){
		Random random = new Random();
		return random.nextInt(9)+1;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}

	public int getWantedX() {
		return wantedX;
	}
	
	public int getWantedY() {
		return wantedY;
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
    
    //scalar for moving an object's x and y coordinates
    public int toCoordinate(int index){
    	return index*scalar + 20;
    }
}
