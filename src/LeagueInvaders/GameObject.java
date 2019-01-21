package LeagueInvaders;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	public int x;
	public int y;
	public int width;
	public int height;
	boolean isAlive = true;
	Rectangle collisionBox;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {
//		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public void update() {
//		this.y+=11;
		collisionBox.setBounds(x, y, width, height);
	}
}
