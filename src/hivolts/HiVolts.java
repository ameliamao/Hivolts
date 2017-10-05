package hivolts;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//notice I switched to applet
//I'm using keylistener, which is under awt, so applet is better
@SuppressWarnings("serial")
public class HiVolts extends Applet implements KeyListener{
	public final int windowWidth = 1500;//to be changed...?
	public final int windowHeight = 1500;//to be changed too?
	//ashu, could you fuse these into the field?  It'll make life a lot simpler for 
	public Fence[] fenceBorder = new Fence[44];
	public Fence[] randomFences = new Fence[20];
	//eventually all sqaures, player, mhos, will be stored in this master 2d array for simplicity
	public Square[][] field = new Square[11][11];
	public Player player;
	
	public void init(){
		setSize(windowWidth, windowHeight);
		this.setBackground(Color.DARK_GRAY);
		createBorder();
		createRandomFences();
		player = new Player();
		repaint();
		setVisible(true);
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
		System.out.println("init completed");
	}
	

	//could you use the constants?
	//sorry it looks weird on my computer because my computer is bad
	//if you put the math in the fence class it'll work...maybe
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
		for(int i = 0; i < 20; i++){
		randomFences[i] = new Fence(Square.random(), Square.random());
		}
	}
	
	public void drawRandomFences(Graphics g){
		for(int i = 0; i < 20; i++){
			randomFences[i].draw(g);
		}
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		drawBorder(g);
		drawRandomFences(g);
		player.draw(g);		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
		if(e.getKeyChar() == 'q'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(-1, -1);
			field[player.getX()][player.getY()] = player;
		}
		else if(e.getKeyChar() == 'w'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(0, -1);
		}
		else if(e.getKeyChar() == 'e'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(1, -1);
		}
		else if(e.getKeyChar() == 'a'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(-1, 0);
		}
		else if(e.getKeyChar() == 's'){
			//RANDOMIFYYY!!!
		}
		else if(e.getKeyChar() == 'd'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(1, 0);
		}
		else if(e.getKeyChar() == 'z'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(-1, 1);
		}
		else if(e.getKeyChar() == 'x'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(0, 1);
		}
		else if(e.getKeyChar() == 'c'){
			field[player.getX()][player.getY()] = null;
			player.changePosition(1, 1);
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}