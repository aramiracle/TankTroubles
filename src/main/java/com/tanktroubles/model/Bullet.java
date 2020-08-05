package com.tanktroubles.model;

public class Bullet extends GameObject {
	public static int AGE = 4;  // seconds

    private double speed = 10;
	public Tank owner;
	private boolean isAlive = true;
	public double angle;

	public Bullet(Tank owner) {
		this.owner = owner;
		this.pos = new Point2D(owner.pos);
		this.angle = owner.angle;
	}

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed < 0)
            this.speed = 0;
        this.speed = speed;
    }

	public void move() {
		// TODO: check collision with obstacles (incl. tanks)

		double radianAngle = Math.toRadians(angle);
        double dx = Math.cos(radianAngle) * speed;
        double dy = Math.sin(radianAngle) * speed;
		this.pos.x += dx;
		this.pos.y += dy;
	}

	public Point2D moveLookahead() {
		return null; // TODO
	}

	public void discard() {
		this.isAlive = false;
	}

    @Override
    public Rectangle getBoundingBox() {
        return null;
    }
}
