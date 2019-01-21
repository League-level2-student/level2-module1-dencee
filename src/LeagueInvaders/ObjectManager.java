package LeagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	int enemySpawnTimeMs = 500;
	long enemyTimer;
	RocketShip rocketShip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	public ObjectManager(RocketShip rs) {
		this.rocketShip = rs;
	}

	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	public void addAlien(Alien a) {
		aliens.add(a);
	}

	public void update() {
		this.rocketShip.update();

		for (Projectile p : projectiles) {
			p.update();
		}

		for (Alien a : aliens) {
			a.update();
		}
	}

	public void draw(Graphics g) {
		this.rocketShip.draw(g);

		for (Projectile p : projectiles) {
			p.draw(g);
		}

		for (Alien a : aliens) {
			a.draw(g);
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTimeMs) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for( int i=0; i < projectiles.size(); i++ ) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}

		for ( int i=0; i < aliens.size(); i++ ) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
	}
	
	public void checkCollision() {
		for(Alien a : aliens){
	        if(rocketShip.collisionBox.intersects(a.collisionBox)){
	        	rocketShip.isAlive = false;
	        }
	        
	        for( Projectile p : projectiles ) {
	        	if( p.collisionBox.intersects(a.collisionBox) ) {
	        		a.isAlive = false;
	        	}
	        }
		}
	}
}
