package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	private int xSpeed;
	private int ySpeed;
	
	void setXSpeed(int speed) {
		this.xSpeed = speed;
	}
	void setYSpeed(int speed) {
		this.ySpeed = speed;
	}
	
	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.xSpeed = 0;
		this.ySpeed = 0;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public void update() {
		this.x += xSpeed;
		this.y += ySpeed;
	}

}
