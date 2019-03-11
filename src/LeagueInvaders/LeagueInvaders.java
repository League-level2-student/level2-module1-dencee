package LeagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	public static final int HEIGHT = 800;
	public static final int WIDTH = 1400;
	JFrame frame;
	GamePanel panel;
	
	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LeagueInvaders().setup();
	}

	public void setup() {
		this.frame.add(panel);
		this.frame.addKeyListener(panel);
		this.frame.setTitle("League Invaders");
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.frame.pack();

		this.panel.startGame();
	}
}
