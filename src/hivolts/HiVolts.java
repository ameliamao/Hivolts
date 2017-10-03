package hivolts;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//notice I switched to applet
//I'm using keylistener, which is under awt, so applet is better
@SuppressWarnings("serial")
public class HiVolts extends Applet implements KeyListener{
	public final int windowWidth = 1440;//to be changed...?
	public final int windowHeight = 1440;//to be changed too?
	public Fence[] fenceBorder = new Fence[44];
	public Fence[] randomFences = new Fence[20];
	public Player player;
	
	//not really nessacary...?
	public HiVolts(){
	}
	
	public void init(){
		setSize(windowWidth, windowHeight);
		this.setBackground(Color.DARK_GRAY);
		
		//other creating methods
		createBorder();
		createRandomFences();
		player = new Player(0,0);
		
		
		repaint();
		setVisible(true);
		addKeyListener(this);
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
	
	
	public void paint(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		drawBorder(g);
		//run all the draws for everything
		
	}
	
	
	//to be changed!!!
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("thing");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("thing");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("thing");
	}
}