package hivolts;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class HiVolts extends JPanel{
	public final int width = 1440;
	public final int height = 1440;
	public HiVolts(){
		initialize();
	}
	public void initialize(){
		setBackground(Color.DARK_GRAY);
		setSize(width, height);
		repaint();
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public static void main(String[] args) {
		JFrame b = new JFrame();
		HiVolts h = new HiVolts();
		b.add(h);
		b.setSize(2500, 1500);
		b.setVisible(true);
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}