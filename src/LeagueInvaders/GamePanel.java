package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	RocketShip ship;
	Font textFont;
	ObjectManager objManager;

	private final int MENU_STATE = 1;
	private final int GAME_STATE = 2;
	private final int END_STATE = 3;
	int currentState;

	public GamePanel() {
		timer = new Timer((1000 / 60), this);
		ship = new RocketShip(250, 700, 50, 50);
		textFont = new Font("Arial", Font.BOLD, 48);
		objManager = new ObjectManager(ship);
		currentState = MENU_STATE;
	}

	public void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setColor(Color.BLACK);
		g.setFont(textFont);
		g.drawString("League", 100, 50);
		g.drawString("Invaders", 90, 100);
	}

	void updateGameState() {
		objManager.manageEnemies();
		objManager.checkCollision();
		objManager.purgeObjects();
		objManager.update();
		
		if( !ship.isAlive ) {
			currentState = END_STATE;
		}
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		objManager.draw(g);
	}

	void updateEndState() {

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setColor(Color.BLACK);
		g.setFont(textFont);
		g.drawString("Game Over", 50, 50);
	}

	@Override
	public void paintComponent(Graphics g) {
		switch (currentState) {
		case MENU_STATE:
			drawMenuState(g);
			break;
		case GAME_STATE:
			drawGameState(g);
			break;
		case END_STATE:
			drawEndState(g);
			break;
		default:
			System.out.println("ERROR: Invalid Game State");
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ship.update();
		repaint();

		switch (currentState) {
		case MENU_STATE:
			updateMenuState();
			break;
		case GAME_STATE:
			updateGameState();
			break;
		case END_STATE:
			updateEndState();
			break;
		default:
			System.out.println("ERROR: Invalid Game State");
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode() + " key pressed");

		int key = e.getKeyCode();

		if (currentState == GAME_STATE) {
			switch (key) {
			case KeyEvent.VK_LEFT:
				ship.setXSpeed(-5);
				break;
			case KeyEvent.VK_UP:
				ship.setYSpeed(-5);
				break;
			case KeyEvent.VK_RIGHT:
				ship.setXSpeed(5);
				break;
			case KeyEvent.VK_DOWN:
				ship.setYSpeed(5);
				break;
			case KeyEvent.VK_SPACE:
				objManager.addProjectile(new Projectile(ship.x, ship.y, 10, 10));
			default:
				System.out.println("ERROR: Invalid key code");
				break;
			}
		}

		if (key == KeyEvent.VK_ENTER) {
			currentState = (currentState == END_STATE) ? MENU_STATE : currentState + 1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if( ( key == KeyEvent.VK_LEFT ) || ( key == KeyEvent.VK_RIGHT ) ) {
			ship.setXSpeed(0);
		} else if( ( key == KeyEvent.VK_UP ) || ( key == KeyEvent.VK_DOWN ) ) {
			ship.setYSpeed(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
