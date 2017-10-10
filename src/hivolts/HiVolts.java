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
	public char[] keys = {'q','w', 'e', 'a', 's','d','z','x','c', 'j'};
	public static ArrayList<Mho> Mhos = new ArrayList<Mho>();
	public static ArrayList<Fence> Fences = new ArrayList<Fence>();
	
	
	
	public void init(){
		setSize(windowWidth, windowHeight);
		this.setBackground(Color.DARK_GRAY);
		createBorder2();
		createRandomFences();
		createMhos();
		player = new Player();
		repaint();
		setVisible(true);
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        System.out.println("init completed");
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
	
	public void createRandomFences(){
		for (int i = 0; i < 20; i++) {
			while(true){
				int x = Square.random2();
				int y = Square.random2();
				if(field[x][y]==null){
					field[x][y] = new Fence(x,y);
					Fences.add(new Fence(x,y));
					break;
				}
			}
		}
	}
	
	public void createMhos(){
		for (int i = 0; i < 12; i++) {
			while(true){
				int x = Square.random2();
				int y = Square.random2();
				if(field[x][y]==null){
					field[x][y] = new Mho(x,y);
					Mhos.add(new Mho(x,y));
					break;
				}
			}
		} 
	}
	
	public boolean mhosCanMoveOnEmptySpaces(int x, int y) {
		boolean canMove = false;
		if (field[x][y]==null) {
			canMove = true;
		} return canMove;
	}
	
	public boolean mhosCanMoveOnFences(int x, int y) {
		boolean canMove = false;
		for (int i = 0; i < Fences.size(); i++) {
			if (x == Fences.get(i).getX() && y == Fences.get(i).getY()) {
				canMove = true;
			} 
		} return canMove;
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
		drawMhos(g);
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
				break;
			case 'd':
				player.changePosition(1, 0);
				break;
			case 'z':
				player.changePosition(-1, 1);
				break;
			case 'x':
				player.changePosition(0, 1);
				break;
			case 'c':
				player.changePosition(1, 1);
				break;
			case 'j':
				//randomize this
				break;
			}
			field[player.getX()][player.getY()] = player;
		}
		repaint();
	}
	public static void drawMhos(Graphics g) {
		for (int i = 0; i < Mhos.size(); i++) {
			Mhos.get(i).draw(g);	
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < Mhos.size(); i++) {
			Mho m = Mhos.get(i);
			
			if (m == null) continue;
			char key = e.getKeyChar();
			boolean contains = false;
			for (char c : keys) {
			    if (c == key) {
			        contains = true; 
			        break;
			    }
			}
			if (contains && key != 'j') {
				m.move(player, this);
				repaint();
			}
			
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}