package com.tanktroubles.model;

public class Rectangle {
    private Point2D topleft;
    private Point2D bottomright;

    public Rectangle(Point2D topleft, Point2D bottomright) {
        this.topleft = topleft;
        this.bottomright = bottomright;
    }

    public boolean hasIntersectionWith(Rectangle other) {
        return other.hasPoint(topleft) ||
                other.hasPoint(bottomright) ||
                other.hasPoint(new Point2D(bottomright.x, topleft.y)) ||
                other.hasPoint(new Point2D(topleft.x, bottomright.y));
    }

    public boolean hasPoint(Point2D point) {
        return point.x >= topleft.x && point.x <= bottomright.x
                && point.y <= topleft.y && point.y >= bottomright.y;
    }
}
