package LeagueInvaders;

import java.awt.Graphics;

public class Alien extends GameObject {
	int ySpeed;

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void setYSpeed(int speed) {
		this.ySpeed = speed;
	}
	
	public void draw(Graphics g) {
//		g.setColor(Color.YELLOW);
//		g.fillRect(this.x, this.y, this.width, this.height);
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
	
	public void update() {
		this.y += 1;
		super.update();
		
		if( this.y < 0 ) {
			this.isAlive = false;
		}
	}
	
}
