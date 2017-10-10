package hivolts;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
public class HiVolts extends Applet implements KeyListener{
	public final int windowWidth = 1500;//to be changed...?
	public final int windowHeight = 1500;//to be changed too?
	public Square[][] field = new Square[12][12];
	public Player player; //will prob change this
	public char[] keys = {'q','w', 'e', 'a', 's','d','z','x','c'};
	public static ArrayList<Mho> Mhos = new ArrayList<Mho>();
	
	
	
	public void init(){
		setSize(windowWidth, windowHeight);
		this.setBackground(Color.DARK_GRAY);
		createBorder2();
		player = new Player();
		repaint();
		setVisible(true);
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	}
	
	public void createBorder2(){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(x==0||x==11||y==0||y==11){
					field[x][y] = new Fence(x,y);
				}
			}
		}
	}
	
	public void drawField(Graphics g){
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(field[x][y] != null){
					field[x][y].draw(g);
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		drawField(g);
		player.draw(g);
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
			field[player.getX()][player.getY()] = null;
			switch (key) {
			case 'q': 
				player.changePosition(-1, -1);
				break;
			case 'w':
				player.changePosition(0, -1);
				break;
			case 'e':
				player.changePosition(1, -1);
				break;
			case 'a':
				player.changePosition(-1, 0);
				break;
			case 's':
				player.changePosition(0, 1);
				break;
			case 'd':
				player.changePosition(1, 0);
				break;
			case 'z':
				player.changePosition(-1, 1);
				break;
			case 'x':
				//randomize this
				break;
			case 'c':
				player.changePosition(1, 1);
				break;
			}
			field[player.getX()][player.getY()] = player;
		}
		repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}