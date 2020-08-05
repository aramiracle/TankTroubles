package com.tanktroubles.model;

public class Point2D {
    public double x;
    public double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

	public Point2D(Point2D point) {
		this.x = point.x;
		this.y = point.y;
	}

	public String toString() {
		return "Point2D(" + x + ", " + y + ")";
	}
}
