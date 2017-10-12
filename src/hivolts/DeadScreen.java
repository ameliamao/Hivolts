package hivolts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DeadScreen {
	public PlayAgain playAgain;

	public DeadScreen(boolean dead){
		playAgain = new PlayAgain();
		playAgain.setBounds(100, 550, 100, 100); //SOMEBODY WITH GOOD ARTSY SENSE PLEASE CHANGE THIS
		playAgain.setVisible(false);

	}
	
	public void draw(Graphics g){
		if(HiVolts.gameStatus == false){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, HiVolts.windowWidth, HiVolts.windowHeight);
			playAgain.setVisible(true);
		}
		
	}
	
	public class PlayAgain extends JButton implements ActionListener {
		PlayAgain() {
			super("Play Again?");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			playAgain.setVisible(false);
			HiVolts.gameStatus = true;
			HiVolts.reset();
			//SOME ONE MAKE IT THAT THIS REPAINTS THE HIVOLTS CLASS
			//IM TOO TIRED
			//THIS IS TECHNICALLY BROKEN
			
		}
	}
}
