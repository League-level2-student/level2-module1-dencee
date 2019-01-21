package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	private int ySpeed;
	
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.ySpeed = 10;
	}

	void setYSpeed(int speed) {
		this.ySpeed = speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public void update() {
		this.y -= ySpeed;
		super.update();
		
		if( this.y < 0 ) {
			this.isAlive = false;
		}
	}

}
