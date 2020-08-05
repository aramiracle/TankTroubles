package com.tanktroubles.model;

public class Tank extends GameObject {
    public static final double ANGLE_SPEED = 6;

    public double angle = 0;        // angle of tank w.r.t. the x axis
    public double speed = 10;

    private int bulletNum = 2;

	public Tank() {
	}

	public Tank(Point2D position) {
		this.pos = position;
	}


    public void rotate(RotationDirection direction) {
        int dAngle = (direction == RotationDirection.RIGHT) ? 1 : -1;
        angle += ANGLE_SPEED * dAngle;
        angle %= 360;
    }

    public void move(MovementDirection direction) {
        this.pos = moveLookahead(direction);
    }

	public Point2D moveLookahead(MovementDirection direction) {
		// FIXME: what if the speed is so high that it can "jump" over the wall?
		// FIXME: moves inside the walls... improve the computations

		double radianAngle = Math.toRadians(this.angle);
        int _direction = direction == MovementDirection.FORWARD ? 1 : -1;
        double dx = Math.cos(radianAngle) * speed * _direction;
        double dy = Math.sin(radianAngle) * speed * _direction;

		return new Point2D(this.pos.x + dx, this.pos.y + dy);
	}

	public boolean hasBullet() {
		return this.bulletNum > 0;
	}

	public void rechargeBullet() {
		this.bulletNum++;
	}

	public Bullet shoot() {
		this.bulletNum--;
		return new Bullet(this);
	}

    @Override
    public Rectangle getBoundingBox() {
        return null;
    }
}