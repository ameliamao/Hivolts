package hivolts;

import java.awt.*;

import javax.swing.JApplet;
public class HiVolts extends JApplet{
	public final int width = 1440;
	public final int height = 1440;
	public Fence[] fenceBorder = new Fence[44];
	public Fence[] randomFences = new Fence[20];
	public HiVolts(){
		initialize();
	}
	public void initialize(){
		setBackground(Color.DARK_GRAY);
		setSize(width, height);
		repaint();
		createBorder();
		createRandomFences();
	}
	
	public void createBorder(){
		for(int i = 0; i < 12; i++){
			fenceBorder[i] = new Fence(10+(110 * i) , 10);
		}
		for(int i = 12; i < 24; i++){
			fenceBorder[i] = new Fence(10+ (110 * (i - 12)), 1220);
		}
		for(int i = 24; i < 34; i++){
			fenceBorder[i] = new Fence(10, 120 + (110 * (i - 24)));
		}
		for(int i = 34; i < 44; i++){
			fenceBorder[i] = new Fence(1220, 120 + (110 * (i - 34)));
		}
	}
	
	public void drawBorder(Graphics g){
		for (int i = 0; i < 44; i++){
			fenceBorder[i].draw(g);
		}
	}
	public void createRandomFences(){
		
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		drawBorder(g);
	}
}