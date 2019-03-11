package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	Timer timer;
	RocketShip ship;
	Font textFont;
	ObjectManager objManager;

	private final int ROCKET_WIDTH = 50;
	private final int ROCKET_HEIGHT = 50;

	private final int MENU_STATE = 1;
	private final int GAME_STATE = 2;
	private final int END_STATE = 3;
	int currentState;

	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	public GamePanel() {
		timer = new Timer((1000 / 60), this);
		textFont = new Font("Arial", Font.BOLD, 48);
		ship = new RocketShip(250, 700, ROCKET_WIDTH, ROCKET_HEIGHT);
		objManager = new ObjectManager(ship);

		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		currentState = MENU_STATE;
	}

	public void startGame() {
		timer.start();
	}

	void updateScore() {

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

		if (!ship.isAlive) {
			currentState = END_STATE;
		}
	}

	void drawGameState(Graphics g) {
		// Draw background
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		
		// Draw score
		g.setColor(Color.WHITE);
		g.drawString("Score: " + objManager.getScore(), 20, 50);

		// Draw all objects: ship, aliens, bullets, etc.
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

	// This gets called each time the timer goes off.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ship.update();

		// Used to call the paint component immediately
		repaint();

		// Update the parameters (x, y, etc.) of the objects drawn
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
				System.out.println("LEFT " + ship.x + " " + ship.y);
				break;
			case KeyEvent.VK_UP:
				ship.setYSpeed(-5);
				break;
			case KeyEvent.VK_RIGHT:
				ship.setXSpeed(5);
				System.out.println("RIGHT " + ship.x + " " + ship.y);
				break;
			case KeyEvent.VK_DOWN:
				ship.setYSpeed(5);
				break;
			case KeyEvent.VK_SPACE:
				objManager.addProjectile(new Projectile(ship.x + ROCKET_WIDTH / 2, ship.y, 10, 10));
				break;
			default:
				System.out.println("ERROR: Invalid key code");
				break;
			}
		}

		if (key == KeyEvent.VK_ENTER) {

			// Must be called before updating the current state so the ship and
			// objects are recreated when in END_STATE
			if (currentState == END_STATE) {
				this.ship = new RocketShip(250, 700, ROCKET_WIDTH, ROCKET_HEIGHT);
				this.objManager = new ObjectManager(this.ship);
			}

			currentState = (currentState == END_STATE) ? MENU_STATE : currentState + 1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
			ship.setXSpeed(0);
		} else if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
			ship.setYSpeed(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
