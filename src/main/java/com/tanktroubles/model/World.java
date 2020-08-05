package com.tanktroubles.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	private List<Tank> tanks;
	private List<Bullet> bullets;
	private GameMap map;

	public World(GameMap map) {
		tanks = new ArrayList<>();
		bullets = new ArrayList<>();
		this.map = map;

		// FIXME: just for test
		tanks.add(new Tank(new Point2D(60, 60)));
		tanks.add(new Tank(new Point2D(160, 60)));
	}

	public List<Tank> getTanks() {
		return this.tanks;
	}

	public List<Bullet> getBullets() {
		return this.bullets;
	}

	public void moveTank(int tankIndex, MovementDirection direction) {
		Tank tank = this.tanks.get(tankIndex);
		Point2D tankNewPosition = tank.moveLookahead(direction);
		if (!map.isOnMap(tankNewPosition) || map.getCellAt(tankNewPosition).isObstacle())
			return;
		tank.move(direction);
	}

	public Bullet tankShoot(int tankIndex) {
		Tank tank = tanks.get(tankIndex);
		if (tank.hasBullet()) {
			Bullet bullet = tank.shoot();
			this.bullets.add(bullet);
			return bullet;
		}
		return null;
	}

	public void proceedBullet(Bullet bullet) {
		/* TODO: check if it hits a tank ---> destroy tank and return something...
		   and/or hits the boundaries of walls ---> just change the angle accordingly
		   */
		bullet.move();
	}

	public void removeBullet(Bullet bullet) {
		this.bullets.remove(bullet);
		bullet.owner.rechargeBullet();
	}

	public GameMap getMap() { return this.map; }
}
