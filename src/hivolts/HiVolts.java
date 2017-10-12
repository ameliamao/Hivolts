package hivolts;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class HiVolts extends Applet implements KeyListener{
	public static final int windowWidth = 1500;//to be changed...?
	public static final int windowHeight = 1500;//to be changed too?
	public static Grid grid;
	public char[] keys = {'q','w', 'e', 'a', 's','d','z','x','c', 'j'};
	public DeadScreen deadScreen;
	public static boolean gameStatus;
		
	public void init(){
		setSize(windowWidth, windowHeight);
		this.setBackground(Color.DARK_GRAY);
		
		deadScreen = new DeadScreen(false);
		add(deadScreen.playAgain);
		
		reset();
		
		repaint();
		setVisible(true);
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        System.out.println("init completed");
	}
	
	public static void reset(){
		grid = new Grid();
		gameStatus = true;
	}
	
	@Override
	public void paint(Graphics g){
		gameStatus = true;
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		grid.draw(g);
		if(!gameStatus){
			deadScreen.draw(g);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {	
		char key = e.getKeyChar();
		boolean contains = false;
		for (char c : keys) {
		    if (c == key) {
		        contains = true; 
		        break;
		    }
		 
		}
		if (contains) {
			grid.field[Grid.player.getX()][Grid.player.getY()] = null;
			switch (key) {
			case 'q': 
				Grid.player.changePosition(-1, -1);
				break;
			case 'w':
				Grid.player.changePosition(0, -1);
				break;
			case 'e':
				Grid.player.changePosition(1, -1);
				break;
			case 'a':
				Grid.player.changePosition(-1, 0);
				break;
			case 's':
				break;
			case 'd':
				Grid.player.changePosition(1, 0);
				break;
			case 'z':
				Grid.player.changePosition(-1, 1);
				break;
			case 'x':
				Grid.player.changePosition(0, 1);
				break;
			case 'c':
				Grid.player.changePosition(1, 1);
				break;
			case 'j':
				grid.changeToRandomPlayerPos();
				break;
			}
			int[] pos = {Grid.player.wantedX, Grid.player.wantedY};
			if(grid.isPlayerOnFence(pos) || grid.isPlayerOnMho(pos)) {
				System.out.println("goodbye");
				gameStatus = false;
			}
			else{
				Grid.player.x = Grid.player.wantedX;
				Grid.player.y = Grid.player.wantedY;
				System.out.println("hello");
				grid.field[Grid.player.x][Grid.player.y] = Grid.player;
				
				
			}
			if(key != 'j'){
				grid.moveMhos();
			}
		}
		repaint();
	}
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}