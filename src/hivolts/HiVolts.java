package hivolts;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class HiVolts extends Applet implements KeyListener{
	public final int windowWidth = 1500;//to be changed...?
	public final int windowHeight = 1500;//to be changed too?
	public Square[][] field = new Square[12][12];
	public Player player; //will prob change this
	
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
					System.out.println("drawin field");
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