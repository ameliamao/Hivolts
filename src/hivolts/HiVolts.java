package hivolts;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.net.URL;

@SuppressWarnings("serial")
public class HiVolts extends Applet implements KeyListener{
	public static final int windowWidth = 1500;
	public static final int windowHeight = 1500;
	public static Grid grid;
	public char[] keys = {'q','w', 'e', 'a', 's','d','z','x','c', 'j', 'u'};
	public static boolean gameStatus;
	public Image helpScreen;
	public Image deadScreen;
	public Image wonScreen;
		
	public void init(){
		setSize(windowWidth, windowHeight);
		this.setBackground(Color.DARK_GRAY);
		
		grid = new Grid();
		gameStatus = true;
		grid.updateMhos();
		
		repaint();
		setVisible(true);
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        loadImage();
        System.out.println("init completed");
	}
	
	public static void reset(){
		gameStatus = true;
		grid.clear();
		grid.createGrid();
		grid.updateMhos();
		grid.changeToRandomPlayerPos();
	}
	
	@Override
	public void paint(Graphics g){
		if(gameStatus){
			System.out.println("should be printing when alive and normal");
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			grid.draw(g);
		}
		 g.drawImage(helpScreen, 650, 0, this);  
		isDead(g);
		isWon(g);
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
			case 'u':
				reset();
				repaint();
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
				grid.updateMhos();
			}
		}
		repaint();
	}
	
	public void isDead(Graphics g){
		if(!gameStatus){
			System.out.println("prints when currently ded");
			 g.drawImage(deadScreen, 0, 0, this);  
		}
	}
	
	public void isWon(Graphics g){
		if(grid.checkWin()){
			g.drawImage(wonScreen, 0, 0, this);
		}
	}
	
	public void loadImage(){
		helpScreen = getImage(getDocumentBase(), "res/Untitled-1.png");
		deadScreen = getImage(getDocumentBase(), "res/DeadScreen.png");
		wonScreen = getImage(getDocumentBase(), "res/WonScreen.png");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
}