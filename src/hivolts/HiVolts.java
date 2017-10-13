package hivolts;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.net.URL;

/**
 * The Hivolts class essentially creates the game and the game board. 
 * It also listens to the keys and updates the game.
 * @author ameliamao, sophiaVera, ashuBhown
 */
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
		
	/**
	 * This function starts the game, creating the board and all the gimmicks
	 */
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
	}
	
	/**
	 * reset() clears the board and restarts the game
	 */
	public static void reset(){
		gameStatus = true;
		grid.clear();
		grid.createGrid();
		grid.updateMhos();
		grid.changeToRandomPlayerPos();
	}
	
	/**
	 * draws the board and the images
	 */
	@Override
	public void paint(Graphics g){
		if(gameStatus){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			grid.draw(g);
		}
		 g.drawImage(helpScreen, 650, 0, this);  
		isDead(g);
		isWon(g);
	}
	
	/**
	 * this function checks the keys that are pressed 
	 * and moves the player accordingly
	 */
	@Override
	public void keyPressed(KeyEvent e) {	
		char key = e.getKeyChar();
		boolean contains = false;
		for (char c : keys) { //for checks to see if the key pressed is a key that the game uses
		    if (c == key) {
		        contains = true; 
		        break;
		    }
		}
		if (contains) {
			grid.field[Grid.player.getX()][Grid.player.getY()] = null;
			switch (key) {
			case 'q': //up and left
				Grid.player.changePosition(-1, -1);
				break;
			case 'w': //up
				Grid.player.changePosition(0, -1);
				break;
			case 'e'://up and right
				Grid.player.changePosition(1, -1);
				break;
			case 'a'://left
				Grid.player.changePosition(-1, 0);
				break;
			case 's'://sit
				break;
			case 'd'://right
				Grid.player.changePosition(1, 0);
				break;
			case 'z'://down and left
				Grid.player.changePosition(-1, 1);
				break;
			case 'x'://down
				Grid.player.changePosition(0, 1);
				break;
			case 'c'://down and right
				Grid.player.changePosition(1, 1);
				break;
			case 'j'://jumps to a random place on the board with no fences
				grid.changeToRandomPlayerPos();
				break;
			case 'u': //restarts the game
				reset();
				repaint();
			}
			int[] pos = {Grid.player.wantedX, Grid.player.wantedY};
			
			//checks to see if player is dies from its move
			if(grid.isPlayerOnFence(pos) || grid.isPlayerOnMho(pos)) {
				gameStatus = false;
			}
			else{
				Grid.player.x = Grid.player.wantedX;
				Grid.player.y = Grid.player.wantedY;
				grid.field[Grid.player.x][Grid.player.y] = Grid.player;
			}
			if(key != 'j'){ //if key pressed is j, then the mhos do not move
				grid.moveMhos();
				grid.updateMhos();
			}
		}
		repaint();
	}
	
	//checks to see if player has died
	public void isDead(Graphics g){
		if(!gameStatus){
			 g.drawImage(deadScreen, 0, 0, this);  
		}
	}
	
	//checks to see if player won
	public void isWon(Graphics g){
		if(grid.checkWin()){
			g.drawImage(wonScreen, 0, 0, this);
		}
	}
	
	//gets the instructions, winScreen, and deadScreen images
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